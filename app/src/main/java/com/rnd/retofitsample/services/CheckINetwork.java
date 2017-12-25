package com.rnd.retofitsample.services;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.rnd.retofitsample.receivers.NetworkStateReceiver;

/**
 * Created by Devrepublic-14 on 7/25/2017.
 */

public class CheckINetwork extends Service implements NetworkStateReceiver.NetworkStateReceiverListener {
    private NetworkStateReceiver networkStateReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
        return START_STICKY;
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
