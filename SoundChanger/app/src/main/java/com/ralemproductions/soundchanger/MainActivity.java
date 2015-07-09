package com.ralemproductions.soundchanger;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private MediaRecorder recorder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void StartClick(View view) {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setOutputFile(getFilePath());

        try {
            recorder.prepare();
            recorder.start();
        }catch(Exception e){

        }
    }

    private String getFilePath()
    {
        String filePath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filePath, "MediaRecorderSample");

        if(!file.exists()) {
            file.mkdir();
        }

        return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".mp4");
    }

    public void StopClick(View view)
    {
        if(recorder != null) {
            recorder.stop();
            recorder.reset();
            recorder.release();



            recorder = null;
        }
    }

    public void PlayBackClick(View view)
    {

    }
}
