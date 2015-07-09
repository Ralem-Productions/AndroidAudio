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
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;


public class MainActivity extends Activity {

    public MediaRecorder recorder = null;
    private MediaPlayer player;
    private String OUTPUT_FILE;
    private Button recordButton;
    private TextView recordString;
    private boolean currentlyRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OUTPUT_FILE = Environment.getExternalStorageDirectory() + "/audiorecorder.3gpp";
        recordButton = (Button) findViewById(R.id.recordButton);
        recordString = (TextView) findViewById(R.id.recordString);
        currentlyRecording = false;
    }

    public void RecordButtonClicked(View view){
        if(!currentlyRecording){
            Start();
            recordButton.setText("Stop Recording");
            recordString.setText("YOU ARE RECORDING");
            currentlyRecording = true;
        }else{
            Stop();
            recordButton.setText("Start Recording");
            recordString.setText("READY TO RECORD");
            currentlyRecording = false;
        }
    }

    public void Start() {
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


    public void Stop()
    {
        if(recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
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
