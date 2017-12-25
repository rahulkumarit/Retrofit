package com.rnd.retofitsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerView;
import com.example.jean.jcplayer.JcStatus;
import com.rnd.retofitsample.R;
import com.rnd.retofitsample.activities.musictest.AudioAdapter;
import com.rnd.retofitsample.activities.musictest.MainActivity;
import java.util.ArrayList;

/**
 * Created by Devrepublic-14 on 9/13/2017.
 */
public class HomeFragment extends BaseFragment implements JcPlayerView.OnInvalidPathListener, JcPlayerView.JcPlayerViewStatusListener {

    private View view;
    private static final String TAG = MainActivity.class.getSimpleName();
    private JcPlayerView player;
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        try {
            init();
           } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void init() {
        getRefefrence();
    }

    private void getRefefrence() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        player = (JcPlayerView) view.findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("url audio", "http://www.villopim.com.br/android/Music_01.mp3"));
        jcAudios.add(JcAudio.createFromAssets("Asset audio 1", "49.v4.mid"));
        jcAudios.add(JcAudio.createFromAssets("Asset audio 2", "56.mid"));
        jcAudios.add(JcAudio.createFromAssets("Asset audio 3", "a_34.mp3"));
        jcAudios.add(JcAudio.createFromRaw("Raw audio 1", R.raw.a_34));
        jcAudios.add(JcAudio.createFromRaw("Raw audio 2", R.raw.a_203));

        player.initPlaylist(jcAudios);
        player.registerInvalidPathListener(this);
        player.registerStatusListener(this);
        adapterSetup();

    }

    protected void adapterSetup() {
        audioAdapter = new AudioAdapter(player.getMyPlaylist());
        audioAdapter.setOnItemClickListener(new AudioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                player.playAudio(player.getMyPlaylist().get(position));
            }

            @Override
            public void onSongItemDeleteClicked(int position) {
                Toast.makeText(getContext(), "Delete song at position " + position, Toast.LENGTH_SHORT).show();
//                if(player.getCurrentPlayedAudio() != null) {
//                    Toast.makeText(MainActivity.this, "Current audio = " + player.getCurrentPlayedAudio().getPath(),
//                            Toast.LENGTH_SHORT).show();
//                }
                removeItem(position);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioAdapter);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    private void removeItem(int position) {
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(true);
        //        jcAudios.remove(position);
        player.removeAudio(player.getMyPlaylist().get(position));
        audioAdapter.notifyItemRemoved(position);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }


    @Override
    public void onPausedStatus(JcStatus jcStatus) {

    }

    @Override
    public void onContinueAudioStatus(JcStatus jcStatus) {

    }

    @Override
    public void onPlayingStatus(JcStatus jcStatus) {

    }

    @Override
    public void onTimeChangedStatus(JcStatus jcStatus) {
        updateProgress(jcStatus);
    }

    @Override
    public void onCompletedAudioStatus(JcStatus jcStatus) {
        updateProgress(jcStatus);
    }

    @Override
    public void onPreparedAudioStatus(JcStatus jcStatus) {

    }

    private void updateProgress(final JcStatus jcStatus) {
        Log.d(TAG, "Song id = " + jcStatus.getJcAudio().getId() + ", song duration = " + jcStatus.getDuration()
                + "\n song position = " + jcStatus.getCurrentPosition());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // calculate progress
                float progress = (float) (jcStatus.getDuration() - jcStatus.getCurrentPosition()) / (float) jcStatus.getDuration();
                progress = 1.0f - progress;
                audioAdapter.updateProgress(jcStatus.getJcAudio(), progress);
            }
        });
    }

    @Override
    public void onPathError(JcAudio jcAudio) {
        Toast.makeText(getContext(), jcAudio.getPath() + " with problems", Toast.LENGTH_LONG).show();

    }
}
