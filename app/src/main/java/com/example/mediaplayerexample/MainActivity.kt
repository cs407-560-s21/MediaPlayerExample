package com.example.mediaplayerexample

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    var myMediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
        A button for Starting sound.
        If it is the first time, it creates the MediaPlayer object with the song provided
    */
    fun playSound(view: View) {
        if (myMediaPlayer == null){
            myMediaPlayer = MediaPlayer.create(this, R.raw.song)
        }
        myMediaPlayer?.start()
    }

    /*
        A button for Pausing sound.
    */
    fun pauseSound(view: View) {
        if(myMediaPlayer != null){
            myMediaPlayer?.pause()
        }
    }

    /*
        A button for Stopping sound after it has been started or paused.
    */
    fun stopSound(view: View) {
        stopSong()
    }

    /*
        Helper function to handle stopping the sound
    */
    private fun stopSong(){
        if(myMediaPlayer != null){
            //myMediaPlayer?.stop()
            // Release is probably better option to release the system resources used
            myMediaPlayer?.release()
            myMediaPlayer = null
        }
    }

    /*
        Stop the song if onStop() is called
    */
    override fun onStop() {
        super.onStop()
        stopSong()
    }

}