package com.ccdp.apppln;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DatePicker;
import android.widget.TextView;

import com.ccdp.apppln.api.DataAPI;
import com.ccdp.apppln.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 3/7/2017.
 */
public class AddDataActivity extends AppCompatActivity{

    private EditText txtIdPelanggan;
    private EditText txtNama;
    private EditText txtTanggal;
    private EditText txtJumlah;
    private EditText txtUserId;
    private Button btnSave;
    String token;

    private Retrofit retrofit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(AddDataActivity.this);
        token = settings.getString("com.ccdp.apppln.token","");

        txtIdPelanggan = (EditText) findViewById(R.id.id_pelanggan);
        txtNama = (EditText) findViewById(R.id.nama);
        txtTanggal = (EditText) findViewById(R.id.tanggal);
        txtJumlah = (EditText) findViewById(R.id.jumlah);
        txtUserId = (EditText) findViewById(R.id.userid);
        btnSave = (Button) findViewById(R.id.btn_save);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final DataAPI dataAPI = retrofit.create(DataAPI.class);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtIdPelanggan.getText().toString().equals("")) {
                    Toast.makeText(AddDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtNama.getText().toString().equals("")) {
                    Toast.makeText(AddDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtTanggal.getText().toString().equals("")){
                    Toast.makeText(AddDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtJumlah.getText().toString().equals("")){
                    Toast.makeText(AddDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else if (txtUserId.getText().toString().equals("")) {
                    Toast.makeText(AddDataActivity.this, "Input Text Kosong..Tolong masukan Text", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddDataActivity.this, "Input Text is Tidak Kosong", Toast.LENGTH_SHORT).show();
                }
                Call<Data> call = dataAPI.insert(txtIdPelanggan.getText().toString(),txtNama.getText().toString(),txtTanggal.getText().toString(),txtJumlah.getText().toString(),txtUserId.getText().toString(),token);                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(AddDataActivity.this, "data berhasil disimpan", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddDataActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else{

                            Toast.makeText(AddDataActivity.this,"Data gagal disimpan",Toast.LENGTH_SHORT);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(AddDataActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
