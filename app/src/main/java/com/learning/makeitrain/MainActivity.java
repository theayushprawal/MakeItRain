package com.learning.makeitrain;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        moneyValue = findViewById(R.id.moneyValue);

    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));

        if(moneyCounter <=9000){
            moneyValue.setTextColor(Color.GRAY);
        }
        else if(moneyCounter >= 10000 && moneyCounter <= 19000){
            moneyValue.setTextColor(Color.GREEN);
        }
        else if(moneyCounter >= 20000){
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.Red));
            moneyCounter -= 1000;

            Snackbar.make(moneyValue, R.string.max_info, Snackbar.LENGTH_LONG).show();

        }

    }
    public void showInfo(View view){

        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", view1 -> Log.d("Snack", "showInfo: Snack bar More"))
                .show();
    }

}