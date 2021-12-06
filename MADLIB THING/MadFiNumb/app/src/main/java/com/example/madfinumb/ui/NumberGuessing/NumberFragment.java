package com.example.madfinumb.ui.NumberGuessing;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Random;
import com.example.madfinumb.R;

import org.w3c.dom.Text;

public class NumberFragment extends Fragment {

    public TextView hiLoTXT;
    public TextView scoreTXT;
    public EditText guessTXT;
    public Button guessBTN;
    public Button resetBTN;
    public int tries;
    public int rando = 0;
    public int score = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //create rootview
        View rootView = inflater.inflate(R.layout.fragment_numberguess,container,false);

        //set variables to elemtents on the xml
        guessBTN = rootView.findViewById(R.id.guessBTN);
        resetBTN = rootView.findViewById(R.id.resetBTN);
        hiLoTXT = rootView.findViewById(R.id.textViewHiLo);
        guessTXT = rootView.findViewById(R.id.editTextGuess);
        scoreTXT = rootView.findViewById(R.id.scoreTXT);


        guessBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               guess();
            }
        });

        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setup();
            }
        });

        setup();
        hiLoTXT.setText("Guess the Number:");
        return rootView;
    }

    private void setup(){
        //setup for the game
        tries = 5;
        //create rand
        Random rng = new Random();
        //make rand an int
        rando = rng.nextInt(100);
        Log.d("setup", String.valueOf(rando));
    }

    private void guess(){
        //grabs input
        String g = String.valueOf(guessTXT.getText());
        //makes it an int
       int i = Integer.valueOf(g);;

       if(i==rando){
           //this is for a correct guess
           hiLoTXT.setText("Great Job! You guessed the number!");
           score+=50+5*tries;
           setup();
           scoreTXT.setText("Score: "+score);
       }
       else if(i<rando){
           //guess is too low
           tries-=1;
           hiLoTXT.setText("Higher! You have "+tries+" tries left.");
       }
       else if(i>rando){
           //guess is too high
           tries-=1;
           hiLoTXT.setText("Lower! You have "+tries+" tries left.");
        }
       if(tries==0){
           //out of guess
           hiLoTXT.setText("Game Over! The number was "+rando+"! Try again.");
           setup();
       }
    }
}
