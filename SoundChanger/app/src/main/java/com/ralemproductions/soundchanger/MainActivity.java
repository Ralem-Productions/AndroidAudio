package com.ralemproductions.soundchanger;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Debug;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.IOException;


public class MainActivity extends Activity {

    public MediaRecorder recorder = null;
    private MediaPlayer player;
    private String OUTPUT_FILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OUTPUT_FILE = Environment.getExternalStorageDirectory() + "/audiorecorder.3gpp";
    }

    public void StartClick(View view) throws IOException {
        if (recorder != null) {
            recorder.release();
        }

        File outFile = new File(OUTPUT_FILE);

        if (outFile.exists()) {
            outFile.delete();
        }

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(OUTPUT_FILE);
        try {
            recorder.prepare();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        recorder.start();
    }


    public void StopClick(View view)
    {
        if(recorder != null) {
                recorder.stop();
        }
    }

    public void PlayBackClick(View view)
    {
        if(player != null){player.release();}
        player = new MediaPlayer();
        try {
            player.setDataSource(OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();
    }
}
