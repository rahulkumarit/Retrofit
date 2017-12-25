package com.rnd.retofitsample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.rnd.retofitsample.R;
import com.rnd.retofitsample.fragments.HomeFragment;

/**
 * Created by Devrepublic-14 on 9/12/2017.
 */

public class HomeActivty extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try {
            init();
           } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        replaceFragment(new HomeFragment(), "");
      }

}
