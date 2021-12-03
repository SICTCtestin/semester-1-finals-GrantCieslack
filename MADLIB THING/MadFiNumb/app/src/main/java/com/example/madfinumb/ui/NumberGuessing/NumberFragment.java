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

public class NumberFragment extends Fragment {

    public TextView HiLo;
    public EditText guessTXT;
    public Button guessBTN;
    public Button resetBTN;
    public int tries;
    public int rando = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_numberguess,container,false);

        guessBTN = rootView.findViewById(R.id.guessBTN);
        resetBTN = rootView.findViewById(R.id.resetBTN);
        HiLo = rootView.findViewById(R.id.textViewHiLo);
        guessTXT = rootView.findViewById(R.id.editTextGuess);


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
        return rootView;
    }

    private void setup(){
        tries = 5;
        Random rng = new Random();
        rando = rng.nextInt(100);
        Log.d("setup", String.valueOf(rando));
//        rando = (int) (Math.random()*100);
    }

    private void guess(){
        String g = String.valueOf(guessTXT.getText());
       int i = Integer.valueOf(g);;

       if(i==rando){
           HiLo.setText("Great Job! You guessed the number!");
           setup();
       }
       else if(i<rando){
           tries-=1;
           HiLo.setText("Higher! You have "+tries+" tries left.");
       }
       else if(i>rando){
           tries-=1;
           HiLo.setText("Lower! You have "+tries+" tries left.");
        }
       if(tries==0){
           HiLo.setText("Game Over! Try again.");
           setup();
       }
    }


}
