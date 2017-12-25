package com.rnd.retofitsample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rnd.retofitsample.R;

/**
 * Created by Devrepublic-14 on 7/31/2017.
 */

public class TestSurfaceView extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_test_serface_view);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() {

    }


}
