package com.ccdp.apppln.api;

import com.ccdp.apppln.model.Data;
import com.ccdp.apppln.model.DataResults;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Asus on 3/6/2017.
 */
public interface DataAPI {

    @GET("data/all")
    Call<DataResults> all(@Query("token") String token);

    @GET("data/find")
    Call<DataResults> find(@Query("id") int id,@Query("token") String token);

    @FormUrlEncoded
    @POST("data/insert")
    Call<Data> insert(@Field("id_pelanggan") String idPelanggan,
                             @Field("nama") String Nama,
                             @Field("tanggal") String Tanggal,
                             @Field("jumlah") String Jumlah,
                             @Field("userid") String userId,
                                @Field("token") String token);

    @FormUrlEncoded
    @POST("data/update")
    Call<Data> update(@Field("id_pelanggan") String idPelanggan,
                             @Field("nama") String Nama,
                             @Field("tanggal") String Tanggal,
                             @Field("jumlah") String Jumlah,
                             @Field("userid") String userId,
                             @Field("id") int id,
                                @Field("token") String token);

    @FormUrlEncoded
    @POST("data/delete")
    Call<Data> delete(@Field("id") int id,@Field("token") String token);

    @Multipart
    @POST("data/upload")
    Call<ResponseBody> upload(@Part("id") int id,@Part MultipartBody.Part file,@Part("token") String token);

}
