package com.rnd.retofitsample.activities;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.rnd.retofitsample.receivers.NetworkStateReceiver;

/**
 * Created by Devrepublic-14 on 7/25/2017.
 */

public class CheckActivity extends BaseActivity implements NetworkStateReceiver.NetworkStateReceiverListener {
    private NetworkStateReceiver networkStateReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
//        startService(new Intent(this, CheckINetwork.class));
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void networkAvailable() {
        Toast.makeText(this, "Netowork available" + "Ws Call here", Toast.LENGTH_LONG).show();
    }

    @Override
    public void networkUnavailable() {
        Toast.makeText(this, "Netowork not available" + "Popup", Toast.LENGTH_LONG).show();
    }


}
