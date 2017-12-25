package com.rnd.retofitsample.activities;

import android.icu.util.TimeZone;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.rnd.retofitsample.R;

/**
 * Created by Devrepublic-14 on 9/14/2017.
 */

public class TestTimeZone extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_time);
         try {
            init();
         } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init() {
        Log.e("Time zone", "" + TimeZone.getDefault());

    }


}
