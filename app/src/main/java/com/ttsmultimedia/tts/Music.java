package com.ttsmultimedia.tts;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by devajanuar on 8/14/2015.
 */
public class Music extends Activity implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemClickListener {

    ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] programmingLang = {"1. OneOkRock - Be The Light", "2. OneOkRock - The Beginning", "3. Magic - Rude"};
    Button play, stop, nextbtn, prevbtn;
    SeekBar SB;
    MediaPlayer MP;
    AudioManager AM;
    int pos;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        play = (Button) findViewById(R.id.btnplay);
        stop = (Button) findViewById(R.id.btnstop);
        SB = (SeekBar) findViewById(R.id.seekBar);
        MP = new MediaPlayer();

        AM = (AudioManager) getSystemService(this.AUDIO_SERVICE);
        int maxVolume = AM.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = AM.getStreamVolume(AudioManager.STREAM_MUSIC);
        SB.setMax(maxVolume);
        SB.setProgress(curVolume);
        SB.setOnSeekBarChangeListener(this);
        btnback = (ImageButton) findViewById(R.id.btnbck);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Music.this, MainActivity.class);
                startActivity(i);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pos=1;
                if (!MP.isPlaying()) {
                    try {
                        MP.prepare();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    play.setText("Pause");

                    MP.start();
                } else if (MP.isPlaying()) {
                    play.setText("Play");
                    MP.pause();
                }
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (MP.isPlaying()) {
                    MP.stop();
                    play.setText("Play");
                    onStart();
                }
            }
        });
        nextbtn = (Button) findViewById(R.id.btnnext);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos == 1) {
                    MP.stop();
                    pos = 2;
                    onStart();
                }
                if (pos == 2) {
                    MP.stop();
                    pos = 3;
                    onStart();
                }
            }
        });

        prevbtn = (Button) findViewById(R.id.btnprv);
        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos == 2) {
                    MP.stop();
                    pos = 1;
                    onStart();
                }
                if (pos == 3) {
                    MP.stop();
                    pos = 2;
                    onStart();
                }
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, programmingLang);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


    }


    protected void onPause() {
        super.onPause();
        MP.release();
    }

    protected void onStart() {
        super.onStart();
        if (pos == 1) {
            pos = 1;
            play.setText("pause");
            MP = MediaPlayer.create(this, R.raw.bethelight);
            try {
                MP.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MP.start();

        }
        if (pos == 2) {
            pos = 2;
            play.setText("pause");
            MP = MediaPlayer.create(this, R.raw.thebeginning);
            try {
                MP.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MP.start();

        }
        if (pos == 3) {
            pos = 3;
            play.setText("pause");
            MP = MediaPlayer.create(this, R.raw.rude);
            try {
                MP.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MP.start();
        }


    }

    protected void kedua() {
        super.onStart();
        MP = MediaPlayer.create(this, R.raw.thebeginning);
        try {
            MP.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        AM.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String message = "" + ((TextView) view).getText();
        if (message.equals("1. OneOkRock - Be The Light")) {
            pos = 1;
            MP.stop();
            onStart();
        }
        if (message.equals("2. OneOkRock - The Beginning")) {
            pos = 2;
            MP.stop();
            onStart();


        } else if (message.equals("3. Magic - Rude")) {
            pos = 3;
            MP.stop();
            onStart();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}

