package com.rnd.retofitsample.wscalls;

import com.rnd.retofitsample.interfaces.ApiInterface;
import com.rnd.retofitsample.models.AddLanguage;
import com.rnd.retofitsample.models.AllLanguage;
import com.rnd.retofitsample.models.Category;
import com.rnd.retofitsample.models.SubCategory;
import com.rnd.retofitsample.wsutils.ApiClient;

import retrofit2.Call;

/**
 * Created by Devrepublic-14 on 7/20/2017.
 */

public class WsFactory {

    public static Call getCategoryCall() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Category> call = apiService.getCategories();
        return call;
    }

    public static Call getSubCategoryCall(String subCat) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SubCategory> call = apiService.getSubCategories(subCat);
        return call;
    }


    public static Call getLangauges() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<AllLanguage> call = apiService.getLanguage();
        return call;
    }

    public static Call addLangauges() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<AddLanguage> call = apiService.addLanguage();
        return call;
    }


}




