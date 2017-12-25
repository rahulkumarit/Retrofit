package com.rnd.retofitsample.interfaces;

import com.rnd.retofitsample.models.AddLanguage;
import com.rnd.retofitsample.models.AllLanguage;
import com.rnd.retofitsample.models.Category;
import com.rnd.retofitsample.models.SubCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Devrepublic-14 on 7/14/2017.
 */

public interface ApiInterface {

    @GET("categories")
    Call<Category> getCategories();

    @GET
    Call<SubCategory> getSubCategories(@Url String url);

    @POST("allLangSongs")
    Call<AllLanguage> getLanguage();

    @POST("userLanguage")
    Call<AddLanguage> addLanguage();


   /* @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);


    @Multipart
    @POST("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);
*/
}


