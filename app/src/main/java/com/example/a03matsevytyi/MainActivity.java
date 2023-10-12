package com.example.a03matsevytyi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resultTextView = findViewById(R.id.result);

        EditText inputField = findViewById(R.id.inputField);

        final Button countWordsButton = findViewById(R.id.countWordsButton);
        AtomicInteger choice = new AtomicInteger();

        final Spinner chooseWhatToDo = findViewById(R.id.chooseWhatToDo);

        String[] items = new String[]{"Count Words", "Count Characters"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseWhatToDo.setAdapter(adapter);

        countWordsButton.setOnClickListener(v -> {
            if(inputField.getText().toString().isEmpty() || inputField.getText().toString().equals("Input your text here")){
                Toast.makeText(this, "write down your text", Toast.LENGTH_SHORT).show();
                return;
            }
            if(choice.get() == 0){
                resultTextView.setText("You have " + new SuperCounter().countWords(inputField.getText().toString()) + " words");
            }
            else {
                resultTextView.setText("You have " + new SuperCounter().countChar(inputField.getText().toString()) + " characters");
            }
        });

        chooseWhatToDo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String inpt = chooseWhatToDo.getSelectedItem().toString();
                if(inpt.equals("Count Characters")){
                    choice.set(1);
                } else if(inpt.equals("Count Words")){
                    choice.set(0);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                countWordsButton.setText("Nothing selected");
            }

        });

        inputField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    inputField.setText("");
                }
            }
        });

    }
}