package com.ttsmultimedia.tts;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by devajanuar on 8/14/2015.
 */
public class TTS extends Activity {
    TextToSpeech tts;
    EditText editText;
    Button play;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        editText = (EditText) findViewById(R.id.text);
        play = (Button) findViewById(R.id.btn_speech);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = editText.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    public void onPause(){
        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item){
        int id = Item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(Item);
    }

}

