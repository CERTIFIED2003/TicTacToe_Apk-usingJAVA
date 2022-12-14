package com.example.g1_tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true ;

    //     Player Representation
    //     X - 0
    //     O - 1
    int activePlayer = 0 ;
    int[] gameState = {2,2,2,2,2,2,2,2,2} ;

    //     State Meanings
    //     0 - X
    //     1 - O
    //     2 - Null

    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}} ;

    public void PlayerTap(View view)
    {
        ImageView img = (ImageView) view ;
        int tappedImage = Integer.parseInt(img.getTag().toString()) ;
        if(!gameActive)
        {
            gameReset(view) ;

        }
        if(gameState[tappedImage] == 2)
        {
            gameState[tappedImage] = activePlayer ;
            img.setTranslationY(-1000f) ;

            if(activePlayer == 0)
            {
                img.setImageResource(R.drawable.cross) ;
                activePlayer = 1;
                TextView status = findViewById(R.id.status) ;
                status.setText("  Player O Turn ") ;
            }

            else
            {
                img.setImageResource(R.drawable.round) ;
                activePlayer = 0 ;
                TextView status = findViewById(R.id.status) ;
                status.setText(" Player X Turn ") ;
            }
            img.animate().translationYBy(1000f).setDuration(300) ;
        }

        // Check if any player has Won
        for(int[] winPositions: winPositions)
        {
            if(gameState[winPositions[0]] == gameState[winPositions[1]] &&
                gameState[winPositions[1]] == gameState[winPositions[2]] &&
                gameState[winPositions[0]] != 2)
            {
                // Someone has won! - Let's find out who
                String winnerStr ;
                gameActive = false ;
                if(gameState[winPositions[0]] == 0)
                {
                    winnerStr = " Player X has Won! :) " ;
                }

                else
                {
                    winnerStr = " Player O has Won! :) " ;
                }

                // Update the status bar for Winner Announcement
                TextView status = findViewById(R.id.status) ;
                status.setText(winnerStr) ;
            }

        }
        boolean emptySquare = false ;
        for(int squareState:gameState)
        {
            if(squareState == 2)
            {
                emptySquare = true ;
                break ;
            }
        }
        if(!emptySquare && gameActive)
        {
            // Game Drawn
            gameActive = false ;
            String winnerStr ;
            winnerStr = " Game Drawn :( " ;
            TextView status = findViewById(R.id.status) ;
            status.setText(winnerStr) ;
        }


    }

    public void gameReset(View view)
    {
        gameActive = true ;
        activePlayer = 0 ;
        for(int i=0; i<gameState.length; i++)
        {
            gameState[i] = 2 ;

        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0) ;
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0) ;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
