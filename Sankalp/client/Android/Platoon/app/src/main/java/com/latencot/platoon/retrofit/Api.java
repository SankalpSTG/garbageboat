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

    @FormUrlEncoded
    @POST(ApiHelper.upload_feedback)
    Call<ResponseBody> uploadFeedback(
            @Field("serial_id") BigInteger serial_id,
            @Field("rating") float rating,
            @Field("header") String header,
            @Field("description") String description,
            @Field("category") String category);

    @FormUrlEncoded
    @POST(ApiHelper.upload_problem)
    Call<ResponseBody> uploadProblem(
            @Field("serial_id") BigInteger serial_id,
            @Field("header") String header,
            @Field("description") String description,
            @Field("category") String category);
    @FormUrlEncoded
    @POST(ApiHelper.get_specific_problems)
    Call<ResponseBody> getSpecificProblems(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.get_specific_solutions)
    Call<ResponseBody> getSpecificProblemSolutions(
            @Field("problem_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.login_without_password)
    Call<ResponseBody> loginWithoutPassword(
            @Field("email_id") String email_id);

    @FormUrlEncoded
    @POST(ApiHelper.login_with_email_and_mobile_no)
    Call<ResponseBody> loginWithEmailAndMobileNo(
            @Field("email_id") String email_id,
            @Field("mobile_no") String mobile_no);

    @FormUrlEncoded
    @POST(ApiHelper.add_boat)
    Call<ResponseBody> addBoat(
            @Field("credential_id") BigInteger serial_id,
            @Field("registration_number") BigInteger registration_no,
            @Field("type") String boat_type,
            @Field("pet_name") String petname);

    @FormUrlEncoded
    @POST(ApiHelper.get_boats_all)
    Call<ResponseBody> getAllBoats(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.get_boat_specific)
    Call<ResponseBody> getBoatSpecific(
            @Field("registration_number") BigInteger registration_no);
    @FormUrlEncoded
    @POST(ApiHelper.delete_boat_specific)
    Call<ResponseBody> deleteBoatSpecific(
            @Field("registration_number") BigInteger registration_no);

    @FormUrlEncoded
    @POST(ApiHelper.get_all_projects)
    Call<ResponseBody> getAllProjects(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.add_project)
    Call<ResponseBody> addProject(
            @Field("serial_id") BigInteger serial_id,
            @Field("project_name") String project_name,
            @Field("project_description") String project_description,
            @Field("is_anonymous") int isanonymous);

    @FormUrlEncoded
    @POST(ApiHelper.get_specific_projects)
    Call<ResponseBody> getSpecificProjects(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.update_project_location)
    Call<ResponseBody> updateProjectLocation(
            @Field("serial_id") BigInteger serial_id,
            @Field("location_lat") Double location_lat,
            @Field("location_lng") Double location_lng);

    @FormUrlEncoded
    @POST(ApiHelper.delete_project)
    Call<ResponseBody> deleteProject(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.get_associated_boats)
    Call<ResponseBody> getAssociatedBoats(
            @Field("serial_id") BigInteger project_id);

    @FormUrlEncoded
    @POST(ApiHelper.get_boats_unmapped)
    Call<ResponseBody> getUnmappedBoats(
            @Field("serial_id") BigInteger serial_id);

    @FormUrlEncoded
    @POST(ApiHelper.add_boat_to_project)
    Call<ResponseBody> addBoatToProject(
            @Field("serial_id") BigInteger registration_no,
            @Field("project_id") BigInteger project_id);

    @FormUrlEncoded
    @POST(ApiHelper.delete_boat_from_project)
    Call<ResponseBody> deleteBoatFromProject(
            @Field("serial_id") BigInteger registration_no,
            @Field("project_id") BigInteger project_id);
}