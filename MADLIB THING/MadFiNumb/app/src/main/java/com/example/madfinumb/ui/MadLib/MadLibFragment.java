package com.example.madfinumb.ui.MadLib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.madfinumb.R;

import java.util.Random;

public class MadLibFragment extends Fragment {
    EditText nounTXT1;
    EditText nounTXT2;
    EditText verbTXT1;
    EditText verbTXT2;
    EditText adjTXT1;
    EditText adjTXT2;
    EditText colorTXT;
    EditText excTXT;
    TextView output;
    Button generatorBTN;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,
                container,
                savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_madlib, container, false);

        nounTXT1 = rootView.findViewById(R.id.editTextNoun);
        nounTXT2 = rootView.findViewById(R.id.editTextNoun2);
        verbTXT1 = rootView.findViewById(R.id.editTextVerb1);
        verbTXT2 = rootView.findViewById(R.id.editTextVerb2);
        adjTXT1 = rootView.findViewById(R.id.editTextAdj1);
        adjTXT2 = rootView.findViewById(R.id.editTextAdj2);
        colorTXT = rootView.findViewById(R.id.editTextAdjColor);
        excTXT = rootView.findViewById(R.id.editTextExclaim);
        output = rootView.findViewById(R.id.madlibTXT);
        generatorBTN = rootView.findViewById(R.id.generatorBTN);

        generatorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate();
            }
        });
        return rootView;
    }


    public void generate() {
        Random rng = new Random();
        int randomNumber = rng.nextInt(3);
        switch (randomNumber) {
            case 0:
                output.setText("The " + adjTXT1.getText() + " " + nounTXT1.getText() + " will " + verbTXT1.getText() + " toward the " + adjTXT2.getText() + " " + nounTXT2.getText() + " and " + verbTXT2.getText() + " just before the " + colorTXT.getText() + " moon screams out '" + excTXT.getText() + "'.");
                break;
            case 1:
                output.setText("'" + excTXT.getText() + "!' cries the " + adjTXT1.getText() + " " + nounTXT1.getText() + " as the " + colorTXT.getText() + " " + nounTXT2.getText() + " " + verbTXT1.getText() + "s" + " on top of them near the " + adjTXT2.getText() + " river that will " + verbTXT2.getText() + " for an eternity.");
                break;
            case 2:
                output.setText("William, the " + adjTXT1.getText() + " " + nounTXT1.getText() + " sees the " + colorTXT.getText() + " " + nounTXT2.getText() + " " + verbTXT1.getText() + " past. '" + excTXT.getText() + "!' he says." + " The " + nounTXT2.getText() + " only comes when the ground turns " + adjTXT2.getText() + ".");
                break;
        }
    }
}
