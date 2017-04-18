package com.ccdp.apppln;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ccdp.apppln.api.DataAPI;
import com.ccdp.apppln.model.Data;
import com.ccdp.apppln.model.DataResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 3/7/2017.
 */
public class EditDataActivity extends AppCompatActivity {

    private EditText txtIdPelanggan;
    private EditText txtNama;
    private EditText txtTanggal;
    private EditText txtJumlah;
    private EditText txtUserId;
    private Button btnSave;
    private Retrofit retrofit;
    private int id;
    String token;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(EditDataActivity.this);
        token = settings.getString("com.ccdp.apppln.token","");

        txtIdPelanggan = (EditText) findViewById(R.id.id_pelanggan);
        txtNama = (EditText) findViewById(R.id.nama);
        txtTanggal = (EditText) findViewById(R.id.tanggal);
        txtJumlah = (EditText) findViewById(R.id.jumlah);
        txtUserId = (EditText) findViewById(R.id.userid);
        btnSave = (Button) findViewById(R.id.btn_save);



        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final DataAPI dataAPI = retrofit.create(DataAPI.class);
        Call<DataResults> call = dataAPI.find(id,token);
        call.enqueue(new Callback<DataResults>() {
            @Override
            public void onResponse(Call<DataResults> call, Response<DataResults> response) {
                try {
                    DataResults results = response.body();
                    List<Data> mems = results.data;
                    Data data = mems.get(0);
                    Log.d("REQUEST = ", call.request().toString());
                    String strId = String.valueOf(data.getId());
                    String strIdPelanggan = String.valueOf(data.getIdPelanggan());
                    txtIdPelanggan.setText(strIdPelanggan);
                    txtNama.setText(data.getNama());
                    txtTanggal.setText(data.getTanggal());
                    txtJumlah.setText(data.getJumlah());
                    String strUserId = String.valueOf(data.getUserid());
                    txtUserId.setText(strUserId);
                }catch (Exception e){
                    Toast.makeText(EditDataActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<DataResults> call, Throwable t) {
                Toast.makeText(EditDataActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtIdPelanggan.getText().toString().equals("")) {
                    Toast.makeText(EditDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtNama.getText().toString().equals("")) {
                    Toast.makeText(EditDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtTanggal.getText().toString().equals("")){
                    Toast.makeText(EditDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtJumlah.getText().toString().equals("")){
                    Toast.makeText(EditDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtUserId.getText().toString().equals("")) {
                    Toast.makeText(EditDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditDataActivity.this, "Input Text is Tidak Kosong", Toast.LENGTH_SHORT).show();
                }
                Call<Data> call = dataAPI.update(txtIdPelanggan.getText().toString(), txtNama.getText().toString(), txtTanggal.getText().toString(), txtJumlah.getText().toString(), txtUserId.getText().toString(),id,token);
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(EditDataActivity.this, "data berhasil disimpan", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditDataActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(EditDataActivity.this, "Data gagal disimpan", Toast.LENGTH_SHORT);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(EditDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
