package com.rnd.retofitsample.wsutils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devrepublic-14 on 7/14/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://life2grow.com/i5radio/user/";

/*
    http://devlabs.nl/catcher/public/api/category/1/subcategories
*/

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
