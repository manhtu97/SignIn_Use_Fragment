package com.example.admin.bai_tap_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUser,edtPass,edtEmail,edtConfirm,btLogIn;
    Button btSign;
    SharedPreferences sharedPreferences;

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        Intent intent1 = getIntent();
        boolean data = intent1.getBooleanExtra("data", false);
        if (data) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("taikhoan");
            editor.remove("matkhau");
            editor.remove("email");
            editor.commit();
        }
        edtUser.setText(sharedPreferences.getString("taikhoan", ""));
        //edtUser.setText("");
        // nếu taikhoan ko co nội dung thì setText se dung string thu 2 là "".
        edtPass.setText(sharedPreferences.getString("matkhau", ""));
        Log.d("aaa", String.valueOf(edtUser.getText()));
        edtEmail.setText(sharedPreferences.getString("email", ""));
        final Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        if (edtUser.getText().toString().equals("")) {
            btSign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String UserName = edtUser.getText().toString();
                    String PassWord = edtPass.getText().toString();
                    String Email = edtEmail.getText().toString();
                    Student student = new Student(UserName, Email, PassWord);
                    intent.putExtra("data", student);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("taikhoan", UserName);
                    editor.putString("matkhau", PassWord);
                    editor.putString("email", Email);
                    editor.commit();
                    startActivity(intent);
                }
            });
        } else {
            String UserName = edtUser.getText().toString();
            String PassWord = edtPass.getText().toString();
            String Email = edtEmail.getText().toString();
            Student student = new Student(UserName, Email, PassWord);
            intent.putExtra("data", student);
            startActivity(intent);
        }
        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignIn = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intentSignIn);
            }
        });
    }
    private void AnhXa() {
        btLogIn         = (EditText) findViewById(R.id.btSignin);
        btSign          = (Button)   findViewById(R.id.btSignIn);
        edtUser         = (EditText) findViewById(R.id.edtUserName);
        edtEmail        = (EditText) findViewById(R.id.edtEmail);
        edtPass         = (EditText) findViewById(R.id.edtPassWord);
        edtConfirm      = (EditText) findViewById(R.id.edtConfirmPass);
    }
}
