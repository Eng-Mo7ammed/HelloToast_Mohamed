package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import androidx.activity.SystemBarStyle;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    private TextView displayCountText;
    private Button buttonZero;
    private Button buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT));
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        displayCountText = findViewById(R.id.show_count);
        buttonZero = findViewById(R.id.button_zero);
        buttonCount = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }


    public void showCount(View view) {
        count++;
        displayCountText.setText(String.valueOf(count));

        if (count % 2 == 0) {
            buttonCount.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        } else {
            buttonCount.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        }

        buttonZero.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
    }

    public void showZero(View view) {
        count = 0;
        displayCountText.setText(String.valueOf(count));
        buttonZero.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
    }
}