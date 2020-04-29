package com.latencot.platoon.retrofit;

import com.latencot.platoon.model.ImageClass;

import java.math.BigInteger;
import java.nio.channels.MulticastChannel;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
    String base_url = "http://192.168.43.88/api/v1/";

    @FormUrlEncoded
    @POST(ApiHelper.upload_credentials)
    Call<ResponseBody> uploadCredentials(
            @Field("email_id") String email_id,
            @Field("mobile_no") String mobile_no
    );
    @FormUrlEncoded
    @POST(ApiHelper.login)
    Call<ResponseBody> logIn(
            @Field("email_id") String email_id,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST(ApiHelper.get_user_data)
    Call<ResponseBody> getUserData(
            @Field("serial_id") BigInteger serial_id
    );
    @FormUrlEncoded
    @POST(ApiHelper.update_user_data)
    Call<ResponseBody> updateUserData(
            @Field("serial_id") BigInteger serial_id,
            @Field("company_name") String company_name,
            @Field("address") String address,
            @Field("pincode") long postalcode,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST(ApiHelper.register_user)
    Call<ResponseBody> uploadUserData(
            @Field("serial_id") BigInteger serial_id,
            @Field("company_name") String company_name,
            @Field("address") String address,
            @Field("pincode") long postalcode,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST(ApiHelper.update_location)
    Call<ResponseBody> updateLocation(
            @Field("serial_id") BigInteger serial_id,
            @Field("location_lat") Double location_lat,
            @Field("location_lng") Double location_lng
    );
    @Multipart
    @POST(ApiHelper.upload_image)
    Call<ResponseBody> uploadImage(
            @Part("serial_id") RequestBody serial_id,
            @Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST(ApiHelper.get_user_all_data)
    Call<ResponseBody> getUserAllData(
            @Field("serial_id") BigInteger serial_id);
}
