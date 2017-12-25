package com.rnd.retofitsample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.rnd.retofitsample.R;

/**
 * Created by Devrepublic-14 on 8/8/2017.
 */

public class TestRotationAcitivity extends BaseActivity {

    TextView txtRotate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rotation);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        txtRotate = (TextView) findViewById(R.id.txtRotate);
     }


}
