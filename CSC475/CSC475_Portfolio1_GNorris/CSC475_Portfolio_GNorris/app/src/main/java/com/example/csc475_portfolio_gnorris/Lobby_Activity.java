package com.example.csc475_portfolio_gnorris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Lobby_Activity extends AppCompatActivity {
    Button lobby_quit_button;
    Button lobby_codename_button;
    Button lobby_ready_button;
    TextView lobby_code_textview;
    EditText lobby_codename_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        //Get intent from Join Game Activity
        Intent intent = getIntent();
        String lobbyText_Ite = intent.getStringExtra(Intent.EXTRA_TEXT);


        lobby_quit_button = findViewById(R.id.lobby_quit_button);
        lobby_codename_button = findViewById(R.id.lobby_codename_button);
        lobby_ready_button = findViewById(R.id.lobby_ready_button);
        lobby_code_textview = findViewById(R.id.lobby_code_TV);
        lobby_codename_editText = findViewById(R.id.lobby_changeCodename_TE);
        lobby_code_textview.setText(lobbyText_Ite);

        lobby_ready_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                String joinPassLobby = lobby_code_textview.getText().toString();
                String codeNamePassLobby = lobby_codename_editText.getText().toString();
                Bundle extras = new Bundle();
                extras.putString("EXTRA_LOBBY",joinPassLobby);
                extras.putString("EXTRA_CODENAME",codeNamePassLobby);

                Intent intent = new Intent(view.getContext(), MainGame_Activity.class);
                intent.putExtras(extras);

                view.getContext().startActivity(intent);
            }
        });


        //Quit button, return to Join Game Activity
        lobby_quit_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), JoinGame_Activity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        //Use a fragment manager to add / remove players and their status from the lobby screen.
        //Will allow players to see who is in the lobby and their ready status before starting game
        //When all players are ready, game will begin.

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //TODO Integrate web services with class.
        //TODO Add fragments (players). Set timer to update each element.
        //fragmentTransaction.add(R.id.lobby_players_constraintlayout, LobbyPlayers_Fragment);
    }

}
