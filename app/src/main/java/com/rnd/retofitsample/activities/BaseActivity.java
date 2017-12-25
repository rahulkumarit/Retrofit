package com.rnd.retofitsample.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rnd.retofitsample.R;

/**
 * Created by Devrepublic-14 on 6/23/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract void init();

    public void replaceFragment(Fragment fragmentname, String tag) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainCantainer, fragmentname, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    public void removeFragmnet() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
//        super.onBackPressed();
    }


}
