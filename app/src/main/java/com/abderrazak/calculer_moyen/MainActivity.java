package com.abderrazak.calculer_moyen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import  android.widget.Button ;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText note1;
    private EditText note2;
    private EditText note3;
    private EditText note4;
    private TextView resuletF ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1) ;
        note2 = findViewById(R.id.note2) ;
        note3 = findViewById(R.id.note3) ;
        note4 = findViewById(R.id.note4) ;
        resuletF = findViewById(R.id.Resulet) ;

        Button calculateMoyen = findViewById(R.id.submit);
        calculateMoyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateMoyen();
            }
        });

    }
    private void calculateMoyen(){
        String note1str = note1.getText().toString();
        String note2str = note2.getText().toString();
        String note3str = note3.getText().toString();
        String note4str = note4.getText().toString();
        if (note1str.length() == 0 ||note2str.length() == 0 ||note3str.length() == 0 || note4str.length() == 0  ){
            Toast.makeText(this, "checed de note 1 or 2 or 3 or 4 ",Toast.LENGTH_SHORT).show();
            return;
        }
        float note_1 = Float.parseFloat(note1str);
        float note_2 = Float.parseFloat(note2str);
        float note_3 = Float.parseFloat(note3str);
        float note_4 = Float.parseFloat(note4str);
        if(note_1 < 0 || note_1 > 20 || note_2 < 0 || note_2 > 20 || note_3 < 0 || note_3 > 20 ||note_4 < 0 || note_4 > 20 ){
            Toast.makeText(this, "checed de note 1 or 2 or 3 or 4",Toast.LENGTH_SHORT).show();
            return;
        }
        float moiyen = (note_1 + note_2 + note_3 + note_4)/4 ;
        String result = interpretMoyen(moiyen) ;
        resuletF.setText("your moiyene is : " + moiyen + "\n" + result);
    }

    private String interpretMoyen( float moiyen)
    {
        if (moiyen >= 16 ){
            return "Excellent" ;
        } else if (moiyen >= 14) {
            return "Tres bien";
        } else if (moiyen >= 12) {
            return "bien";
        } else if (moiyen >= 10) {
            return "Assez bien" ;
        }
        return "Echec" ;


    }

}