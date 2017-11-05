package com.example.admin.bai_tap_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView txtUser;
    Button btSignOut;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtUser = (TextView) findViewById(R.id.txtShowUser);
        btSignOut = (Button) findViewById(R.id.buttonSignOut);
        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("data");
        txtUser.setText(" "+student.getUserName() + ".");
        btSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WelcomeActivity.this,MainActivity.class);
                intent1.putExtra("data",true);
                startActivity(intent1);
                finish();
            }
        });
    }
}
