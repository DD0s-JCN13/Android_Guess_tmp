package com.later.squad.randomgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtext;
    TextView tvhint;
    Random ran = new Random();
    int target = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        target = ran.nextInt(10)+1;
        findview();
    }

    public void findview(){
        edtext = findViewById(R.id.ed_Text);
        tvhint = findViewById(R.id.txt_hint);
    }

    public void Guess(View view){
        int readin = Integer.parseInt(edtext.getText().toString());
        if(readin > target){
            tvhint.setText("小一點");
        }else if(readin < target){
            tvhint.setText("大一點");
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("答案是 "+target+" ，請按restart重新開始遊戲")
                    .setPositiveButton("OK",null)
                    .setTitle("恭喜你答對了")
                    .show();
        }
    }
    public void Restart(View v){
        tvhint.setText("");
        edtext.setText("");
        target = ran.nextInt(10)+1;
    }
}
