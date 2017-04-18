package com.ccdp.apppln;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ccdp.apppln.adapter.DataAdapter;
import com.ccdp.apppln.api.DataAPI;
import com.ccdp.apppln.api.UserAPI;
import com.ccdp.apppln.model.Data;
import com.ccdp.apppln.model.DataResults;
import com.ccdp.apppln.model.LoginResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Data> datas;
    private static DataAdapter adapter;
    Retrofit retrofit;
    DataAPI dataAPI;
    UserAPI userAPI;
    private ProgressDialog mProgressDialog;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        token = settings.getString("com.ccdp.apppln.token","");

        listView =(ListView) findViewById(R.id.lvnotes);

        retrofit= new Retrofit.Builder()
                .baseUrl(Constants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataAPI = retrofit.create(DataAPI.class);
        Call<DataResults> call = dataAPI.all(token);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        call.enqueue(new Callback<DataResults>() {
            @Override
            public void onResponse(Call<DataResults> call, Response<DataResults> response) {
                try{
                    datas.clear();
                    DataResults results = response.body();
                    List<Data> mems = results.data;
                    for(Data m: mems){
                        datas.add(m);
                    }
                    adapter.notifyDataSetChanged();

                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }

                }catch (Exception e){
                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }

                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataResults> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }

            }
        });

        if(datas == null){
            datas = new ArrayList<>();
        }

        adapter = new DataAdapter(getApplicationContext(),R.layout.row_item,datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data data = datas.get(position);
                Intent intent = new Intent(MainActivity.this,ViewDataActivity.class);
                intent.putExtra("id",data.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        switch (id){
            case R.id.action_add:
                intent = new Intent(MainActivity.this,AddDataActivity.class);
                startActivity(intent);
                break;

            case R.id.action_logout:
                logout();
                break;

            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        userAPI = retrofit.create(UserAPI.class);
        Call<LoginResult> call = userAPI.logout(token);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                try {
                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                    LoginResult result = response.body();
                    Log.d("LoginActivity", result.message);
                    if(result.success){
                        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.remove("com.ccdp.apppln.token");
                        editor.remove("com.ccdp.apppln.isLogin");
                        editor.remove("com.ccdp.apppln.username");
                        editor.commit();

                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }catch (Exception e){
                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        });
    }
}
