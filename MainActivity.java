package com.example.jianingsun.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private static final String TAG1="Color";
    private static final String TAG2="Correction";
    private Game leftOrRight= new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNameButton(R.id.btnLeft, "Port(left) is red ");
        setupNameButton(R.id.btnRight, "Starboard(right) is green.");
        setupMeaningButton(R.id.btnMeansLeft, Game.Side.PORT);
        setupMeaningButton(R.id.btnMeansRight,Game.Side.STARBOARD);
        UpdateUI();

    }
    private void setupNameButton(int buttonId, final String direction){
        Button button=(Button)findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1,direction);
                Toast.makeText(getApplicationContext(),direction,Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }
    private void setupMeaningButton(int buttonId, final Game.Side side){
        Button btn=(Button)findViewById(buttonId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftOrRight.checkIfCorrect(side)){
                    Log.i(TAG2,"User guess of "+leftOrRight.getChosenSideName()+" was Correct!");
                    Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT)
                            .show();
                    UpdateUI();

                }
                else{
                    Log.i(TAG2,"User guess of "+leftOrRight.getChosenSideName()+" was Incorrect.");
                    Toast.makeText(getApplicationContext(),"Incorrect. :(",Toast.LENGTH_SHORT)
                            .show();
                    UpdateUI();

                }
            }
        });

    }

    private void UpdateUI(){
        leftOrRight = new Game();
        TextView text = (TextView) findViewById(R.id.txt);
        text.setText(leftOrRight.getChosenSideName());

    }
}
