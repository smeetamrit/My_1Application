package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button buttonChangeText;
    private CheckBox checkBox;
    private Switch switchToggle;
    private RadioButton radioButton;
    private ImageView imageView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        buttonChangeText = findViewById(R.id.buttonChangeText);
        checkBox = findViewById(R.id.checkBox);
        switchToggle = findViewById(R.id.switchToggle);
        radioButton = findViewById(R.id.radioButton);
        imageView = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.imageButton);

        // Button to Change TextView Text
        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = editText.getText().toString();
                textView.setText(newText.isEmpty() ? "Hello World!" : newText);
            }
        });

        // ImageButton to Show Toast with Width and Height
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = imageButton.getWidth();
                int height = imageButton.getHeight();
                Toast.makeText(MainActivity.this,
                        "Width: " + width + ", Height: " + height, Toast.LENGTH_SHORT).show();
            }
        });

        // Compound Button State Toast
        View.OnClickListener compoundButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stateMessage = "Checkbox: " + (checkBox.isChecked() ? "Checked" : "Unchecked")
                        + ", Switch: " + (switchToggle.isChecked() ? "On" : "Off")
                        + ", RadioButton: " + (radioButton.isChecked() ? "Selected" : "Not Selected");

                Toast.makeText(MainActivity.this, stateMessage, Toast.LENGTH_SHORT).show();
            }
        };

        // Attach Listener to Compound Buttons
        checkBox.setOnClickListener(compoundButtonListener);
        switchToggle.setOnClickListener(compoundButtonListener);
        radioButton.setOnClickListener(compoundButtonListener);
    }
}
