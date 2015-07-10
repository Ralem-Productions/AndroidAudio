package com.ralemproductions.soundchanger; /**
 * Created by Josh on 7/8/2015.
 */

import android.app.Activity;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.audiofx.AudioEffect;
import android.net.rtp.AudioStream;
import android.media.audiofx.PresetReverb;


public class modifier extends Activity{
    //the type of voice
    private int penis;
    //the modified sound file
    private MediaPlayer modifiedFile;
    PresetReverb reverb = new PresetReverb(1,0);

    // takes the audio and the style parameter and passes to new function
   void ChangeVoice(MediaPlayer mediaPlayer, int style){

        //helium, robot, cave, drunk man, megaphone, underwater, reverse, child, alien, censorship
    switch(style){
        case 1:
            Helium(mediaPlayer);
        case 2:
            Cave(mediaPlayer);
        case 3:
            Drunk(mediaPlayer);
        case 4:
            Megaphone(mediaPlayer);
        case 5:
            Underwater(mediaPlayer);
        case 6:
            Reverse(mediaPlayer);
        case 7:
            Child(mediaPlayer);
        case 8:
            Alien(mediaPlayer);
        case 9:
            Censorship(mediaPlayer);

    }


   };

    MediaPlayer Helium(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Robot(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Cave(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Drunk(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Megaphone(MediaPlayer mediaPlayer){

        mediaPlayer.attachAuxEffect(reverb.getId());
        reverb.setPreset(PresetReverb.PRESET_LARGEHALL);
        reverb.setEnabled(true);
        mediaPlayer.setAuxEffectSendLevel(1.0f);
        modifiedFile = mediaPlayer;
        return modifiedFile;
    }
    MediaPlayer Underwater(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Reverse(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Child(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Alien(MediaPlayer mediaPlayer){

        return modifiedFile;
    }
    MediaPlayer Censorship(MediaPlayer mediaPlayer){

        return modifiedFile;
    }






}
