package com.ccdp.apppln;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.ccdp.apppln.api.DataAPI;
import com.ccdp.apppln.model.Data;
import com.ccdp.apppln.model.DataResults;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewDataActivity extends AppCompatActivity {

    private TextView txtId;
    private TextView txtIdPelanggan;
    private TextView txtNama;
    private TextView txtTanggal;
    private TextView txtJumlah;
    private TextView txtUserId;
    private Button btnDelete, btnEdit,btnPhoto;
    private int id;
    private Retrofit retrofit;
    private ImageView photo;
    File file;

    ProgressDialog mProgressDialog;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_view_data);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(ViewDataActivity.this);
        token = settings.getString("com.ccdp.apppln.token","");

        txtId = (TextView) findViewById(R.id.id);
        txtIdPelanggan = (TextView) findViewById(R.id.id_pelanggan);
        txtNama = (TextView) findViewById(R.id.nama);
        txtTanggal = (TextView) findViewById(R.id.tanggal);
        txtJumlah = (TextView) findViewById(R.id.jumlah);
        txtUserId = (TextView) findViewById(R.id.userid);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        btnPhoto = (Button)  findViewById(R.id.btn_photo);
        photo = (ImageView) findViewById(R.id.photo);

        //ambil data terbaru dari server
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final DataAPI dataAPI = retrofit.create(DataAPI.class);
        Call<DataResults> call = dataAPI.find(id,token);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        call.enqueue(new Callback<DataResults>() {
            @Override
            public void onResponse(Call<DataResults> call, Response<DataResults> response) {
                try {
                    DataResults results = response.body();
                    List<Data> mems = results.data;
                    Data data = mems.get(0);
                    Log.d("REQUEST = ", call.request().toString());
                    String strId = String.valueOf(data.getId());
                    txtId.setText(strId);
                    String strIdPelanggan = String.valueOf(data.getIdPelanggan());
                    txtIdPelanggan.setText(strIdPelanggan);
                    txtNama.setText(data.getNama());
                    txtTanggal.setText(data.getTanggal());
                    txtJumlah.setText(data.getJumlah());
                    String strUserId = String.valueOf(data.getUserid());
                    txtUserId.setText(strUserId);
                    String photoUrl = Constants.BASE_ASSETS + data.getId() + ".jpg";
                    Glide.with(getApplicationContext())
                            .load(photoUrl).error(R.mipmap.ic_launcher)
                            .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(photo);

                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                } catch (Exception e) {
                    Toast.makeText(ViewDataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResults> call, Throwable t) {
                Toast.makeText(ViewDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(ViewDataActivity.this);
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        DataAPI dataAPI = retrofit.create(DataAPI.class);
                        Call<Data> call = dataAPI.delete(id, token);
                        Log.d("call request", call.request().toString());
                        call.enqueue(new Callback<Data>() {
                            @Override
                            public void onResponse(Call<Data> call, Response<Data> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(ViewDataActivity.this, "data berhasil dihapus", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                } else {
                                    Toast.makeText(ViewDataActivity.this, "Data gagal dihapus", Toast.LENGTH_SHORT);
                                }

                            }

                            @Override
                            public void onFailure(Call<Data> call, Throwable t) {
                                Toast.makeText(ViewDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                android.support.v7.app.AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewDataActivity.this, EditDataActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, Constants.CAMERA_REQUEST_CODE);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile(file);
            }
        });
    }
    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(ViewDataActivity.this);
    }

    private void uploadFile(File file) {

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("gambar", file.getName(), requestFile);

        // finally, execute the request
        Log.d("BEGIN UPLOAD",file.getAbsolutePath());
        DataAPI dataAPI = retrofit.create(DataAPI.class);
        Call<ResponseBody> call = dataAPI.upload(id,body,token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                onBackPressed();
            }


            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(Constants.CAMERA_REQUEST_CODE == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            photo.setImageBitmap(bitmap);
            photo.setDrawingCacheEnabled(true);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            //String path = Environment.getExternalStorageDirectory().toString();
            file = new File(getCacheDir(), id+".jpg");
            try {
                FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
