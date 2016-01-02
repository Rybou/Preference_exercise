package com.example.bourymbodj.preference_exercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText password;
    private CheckBox lock;
    private EditText reminder;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password= (EditText) findViewById(R.id.pw);
        lock= (CheckBox) findViewById(R.id.screenLock);
        reminder= (EditText)findViewById(R.id.update);
        save= (Button) findViewById(R.id.save);

        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("password", password.getText().toString());
        editor.putString("reminder",reminder.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

    }
}
