package com.example.p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class SecondActivity extends Activity {
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    private DecimalFormat decimalFormatMes = new DecimalFormat("#,##0.000");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button button = findViewById(R.id.button2);
        TextView valueInitialTextView = findViewById(R.id.value_initial);
        TextView percentageTextView = findViewById(R.id.value_percentage);
        TextView percentageMesTextView = findViewById(R.id.value_percentage_mes);
        TextView moneyTextView = findViewById(R.id.value_money);
        TextView yearTextView = findViewById(R.id.value_year);

        Intent intent = getIntent();
        String moneyStr = intent.getStringExtra("money");
        String year = intent.getStringExtra("year");
        String percentageStr = intent.getStringExtra("percentage");

        double principal = Double.parseDouble(moneyStr.replace(",", ""));
        double rate = Double.parseDouble(percentageStr) / 100;
        double n = Double.parseDouble(year) * 12;
        double mes = Double.parseDouble(String.valueOf(rate)) / 12;

        double c = (principal * mes) / (Math.pow(1 + mes, n) - 1);

        valueInitialTextView.setText("R$ " + decimalFormat.format(c));
        moneyTextView.setText("R$ " + decimalFormat.format(principal));
        percentageTextView.setText(percentageStr + "%");
        percentageMesTextView.setText(decimalFormatMes.format(mes) + "%");
        yearTextView.setText(year + " ano(s)");

        button.setOnClickListener(v -> {
            Intent mainActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(mainActivityIntent);
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
