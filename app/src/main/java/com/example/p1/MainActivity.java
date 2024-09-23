package com.example.p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText moneyInput = findViewById(R.id.input_money);
                EditText percentageInput = findViewById(R.id.input_percentage);
                EditText yearsInput = findViewById(R.id.input_year);

                String money = moneyInput.getText().toString();
                String percentage = percentageInput.getText().toString();
                String year = yearsInput.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("money", money);
                intent.putExtra("year", year);
                intent.putExtra("percentage", percentage);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
