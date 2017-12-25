package com.rnd.retofitsample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import com.rnd.retofitsample.R;

/**
 * Created by Devrepublic-14 on 7/21/2017.
 */

public class SubCategoryActivity extends BaseActivity {
    private ListView lvSubCat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_category_activity);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        lvSubCat = (ListView) findViewById(R.id.lvSubCat);
    }

}
