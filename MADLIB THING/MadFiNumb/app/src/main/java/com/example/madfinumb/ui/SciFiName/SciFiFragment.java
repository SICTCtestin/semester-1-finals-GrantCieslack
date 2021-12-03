package com.example.madfinumb.ui.SciFiName;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.madfinumb.R;

import java.util.Random;

public class SciFiFragment extends Fragment {
    EditText firstNameTXT;
    EditText lastNameTXT;
    EditText cityTXT;
    EditText schoolTXT;
    EditText broTXT;
    EditText sisTXT;
    TextView output;
    Button generatorBTN;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_scifi,container,false);

        firstNameTXT = rootView.findViewById(R.id.firstTXT);
        lastNameTXT = rootView.findViewById(R.id.lastTXT);
        cityTXT = rootView.findViewById(R.id.cityTXT);
        schoolTXT = rootView.findViewById(R.id.schoolTXT);
        broTXT = rootView.findViewById(R.id.broTXT);
        sisTXT = rootView.findViewById(R.id.sisTXT);
        output = rootView.findViewById(R.id.output);
        generatorBTN = rootView.findViewById(R.id.generator);

        //utilize and onClickListener to connect to the button
        generatorBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                generate();
            }
        });
        return rootView;
    }
    //generate SciFiName
    private void generate(){
        String first = String.valueOf(firstNameTXT.getText());
        String last = String.valueOf(lastNameTXT.getText());
        String city = String.valueOf(cityTXT.getText());
        String school = String.valueOf(schoolTXT.getText());
        String brother = String.valueOf(broTXT.getText());
        String sister = String.valueOf(sisTXT.getText());


        int rF = (int) (Math.random()*firstNameTXT.length());
        int rL = (int) (Math.random()*lastNameTXT.length());
        int rC = (int) (Math.random()*cityTXT.length());
        int rS = (int) (Math.random()*schoolTXT.length());
        int rB = (int) (Math.random()* broTXT.length());
        int rSi = (int) (Math.random()*sisTXT.length());

        //generate scifi first name
        String sciFiFirst = first.substring(0,rF) + last.substring(rL);

        //generate scifi last name
        String sciFiLast = city.substring(0,rC) + school.substring(rS);

        //generate scifi home name
        String sciFiHome = brother.substring(rB) + sister.substring(0,rSi);

        output.setText(String.format("Welcome! %s %s from %s",sciFiFirst,sciFiLast,sciFiHome));

    }
}