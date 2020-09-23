package com.example.csc475_portfolio_gnorris;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;


import java.util.Locale;
import java.util.Random;

public class MainGame_Activity extends AppCompatActivity {

    private Button game_quit_button;
    private TextView game_lobby_TV;
    private TextView game_location_TV;
    private TextView game_role_TV;
    private TextView game_timer_TV;
    private CountDownTimer gameCountdown;
    private long timeRemaining = 300000L; // Set for 5 minutes
    private static long INTERVAL = 1000L;
    private String currentLocation;
    private String whoIsTheSpy;
    private String player_codename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String lobbyText_Ite = extras.getString("EXTRA_LOBBY");
        player_codename = extras.getString("EXTRA_CODENAME");


        game_lobby_TV = findViewById(R.id.game_activity_lobby_TV);
        game_location_TV = findViewById(R.id.game_activity_location_TV);
        game_role_TV = findViewById(R.id.game_activity_role_TV);
        game_timer_TV = findViewById(R.id.game_activity_countdown);

        game_lobby_TV.setText(lobbyText_Ite);

        game_quit_button = (Button) findViewById(R.id.game_activity_quit_button);
        game_quit_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(view.getContext(),JoinGame_Activity.class);
                //view.getContext().startActivity(intent);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        //THIS USES A RANDOM LOCATION GENERATED LOCALLY TO BYPASS HAVING TO USE A SERVER - FOR TESTING
        super.onStart();
        final boolean isSpy = determineSpy();

        String displayLocation = setRandomLocation(isSpy);

        game_location_TV.setText("Location: "+displayLocation);
        game_role_TV.setText("Role: "+setRole(isSpy));


        gameCountdown = new CountDownTimer(timeRemaining, INTERVAL) {
            @Override
            public void onTick(long l) {
                game_timer_TV.setText(String.format(Locale.getDefault(), "%d sec.", l / 1000L));
                timeRemaining = l;
            }
            @Override
            public void onFinish() {
                game_timer_TV.setText("Done");
                game_location_TV.setText("Location: "+currentLocation);
                String theSpyWas = whoWasTheSpy(isSpy);
                game_role_TV.setText("The Spy: "+theSpyWas);
            }
        };
        gameCountdown.start();
    }

    private boolean determineSpy()
    {
        boolean isSpy = new Random().nextBoolean();
        return isSpy;
    }

    private String setRandomLocation(boolean isSpy)
    {
        String sendLocation = "";
        int randomLocInt = new Random().nextInt(21);
        String locRes = "location_";
        String locInt = Integer.toString(randomLocInt);
        locRes = locRes+locInt;
        System.out.println(locInt);
        int resID = getResources().getIdentifier(locRes,"string",getPackageName());
        currentLocation = getString(resID);


        if(!isSpy){
            sendLocation = currentLocation;
        }
        else
            {
                sendLocation = "Unknown";
            }
        return sendLocation;
    }

    private String whoWasTheSpy(boolean spy)
    {
        String returnSpy;
        if (!spy)
        {
            returnSpy = "Network Player";
        }
        else {returnSpy = player_codename;}
        return returnSpy;
    }

    private String setRole(boolean spy)
    {
        String sendRole;
        if(!spy)
        {
            sendRole = "Not the Spy";
        }
        else {sendRole = "You are the Spy";}
        return sendRole;
    }
}//end Class
