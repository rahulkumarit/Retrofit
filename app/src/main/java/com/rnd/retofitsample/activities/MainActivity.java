package com.rnd.retofitsample.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.rnd.retofitsample.R;
import com.rnd.retofitsample.interfaces.RVClickBack;
import com.rnd.retofitsample.models.AddLanguage;
import com.rnd.retofitsample.models.AllLanguage;
import com.rnd.retofitsample.wscalls.WsFactory;
import com.rnd.retofitsample.wsutils.JsonResponse;
import com.rnd.retofitsample.wsutils.StaticUtils;
import com.rnd.retofitsample.wsutils.WsUtils;

import java.util.ArrayList;

import retrofit2.Call;

public class MainActivity extends BaseActivity implements JsonResponse, AdapterView.OnItemClickListener, View.OnClickListener, RVClickBack {

    private static final String TAG = "FacebookLogin";
    private Button btnAllLanguage, btnAddLanguage;
    private RecyclerView rvOther;
    private SelectLanguageAdapter selectLanguageAdapter;
    private ArrayList<AllLanguage.Other> others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        btnAllLanguage = (Button) findViewById(R.id.btnAllLanguage);
        btnAddLanguage = (Button) findViewById(R.id.btnAddLanguage);
        rvOther = (RecyclerView) findViewById(R.id.rvOther);
        btnAllLanguage.setOnClickListener(this);
        btnAddLanguage.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void successResponse(Object response, int code) {
        switch (code) {
            case StaticUtils.REQUEST_ADD_LANGUAGE:
                AddLanguage addLanguage = (AddLanguage) response;
                break;
            case StaticUtils.REQUEST_ALL_LANGUAGE:
                AllLanguage allLanguage = (AllLanguage) response;
                others = (ArrayList<AllLanguage.Other>) allLanguage.getOther();
                selectLanguageAdapter = new SelectLanguageAdapter((ArrayList<AllLanguage.Other>) allLanguage.getOther(), this);
                rvOther.setAdapter(selectLanguageAdapter);
                break;
            default:
                break;
        }

    }

    @Override
    public void failureRespons(Throwable error, int code) {
        Log.e("Response Error: ", "Size :" + error);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAllLanguage:
                wsResponseAllLanguage();
                break;
            case R.id.btnAddLanguage:
                wsResponseAddLanguage();
                break;
        }
    }

        private void wsResponseAllLanguage() {
            Call callForCateory = WsFactory.getLangauges();
            WsUtils.getJsonReponse(callForCateory, StaticUtils.REQUEST_ALL_LANGUAGE, this);
        }

    private void wsResponseAddLanguage() {
        Call callForCateory = WsFactory.addLangauges();
        WsUtils.getJsonReponse(callForCateory, StaticUtils.REQUEST_ADD_LANGUAGE, this);
    }

    @Override
    public void rvOnItemClick(int position, View view) {
        if (others.get(position).isChecked()) {
            others.get(position).setChecked(false);
         } else {
            others.get(position).setChecked(true);
         }
        others.add(position, others.get(position));
        selectLanguageAdapter.notifyDataSetChanged();
        rvOther.setAdapter(selectLanguageAdapter);
    }

    private class SelectLanguageAdapter extends RecyclerView.Adapter<SelectLanguageAdapter.SelectLanguageHolder> {
        private ArrayList<AllLanguage.Other> others;
        private RVClickBack rvClickback;


        public SelectLanguageAdapter(ArrayList<AllLanguage.Other> others, RVClickBack rvClickback) {
            this.others = others;
            this.rvClickback = rvClickback;
        }

        @Override
        public SelectLanguageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_select_laguage, parent, false);
            return new SelectLanguageHolder(view);
        }

        @Override
        public void onBindViewHolder(final SelectLanguageHolder holder, final int position) {
            holder.txtCheck.setText(others.get(position).getLangName());

            if (others.get(position).isChecked()) {
                holder.txtCheck.setSelected(false);
            } else {
                holder.txtCheck.setSelected(false);
            }

            holder.txtCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvClickback.rvOnItemClick(position, v);
                }
            });
        }

        @Override
        public int getItemCount() {
            return others.size();
        }

        class SelectLanguageHolder extends RecyclerView.ViewHolder {
            private TextView txtCheck;

            public SelectLanguageHolder(View view) {
                super(view);
                txtCheck = (TextView) view.findViewById(R.id.txtCheck);

            }
        }
    }
}