package com.example.csc475_portfolio_gnorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;


public class JoinGame_Activity extends AppCompatActivity {

    private boolean phoneDevice = true;

    //Initialize UI Elements
    private Button createLobby;
    private Button joinLobby;
    private EditText lobbyCode;
    //Unique session ID for identifying players in game
    private String sessionID;


    //***************     onCreate()     ***************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i(TAG, "onCreate");

       //TODO Create unique session ID
        sessionID = UUID.randomUUID().toString();

        //Load associated layout xml
        setContentView(R.layout.activity_join_lobby);

        //PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        if(screenSize==Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {phoneDevice=false;}

        if(phoneDevice)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        //TODO Link buttons to resources
        createLobby = findViewById(R.id.create_lobby_button);
        joinLobby = findViewById(R.id.join_lobby_button);
        lobbyCode = findViewById(R.id.lobbyName_ET);

        //TODO Button click creates new lobby
        createLobby.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v) {

            String joinPassLobby = lobbyCode.getText().toString();

            Intent intent = new Intent(v.getContext(), Lobby_Activity.class);
            intent.putExtra(Intent.EXTRA_TEXT, joinPassLobby);
            v.getContext().startActivity(intent);
            }});

        //TODO Button click joins existing lobby
        joinLobby.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v){

            String joinPassLobby = lobbyCode.getText().toString();

            Intent intent = new Intent(v.getContext(), Lobby_Activity.class);
            intent.putExtra(Intent.EXTRA_TEXT, joinPassLobby);
            v.getContext().startActivity(intent);
        }});


        //TODO CREATE METHOD FOR PASSING DATA TO SERVER
        //TODO CREATE METHOD FOR RECEIVING DATA FROM SERVER

    }//onCreate()

    protected void onStart()
    {
        super.onStart();

    }


}
