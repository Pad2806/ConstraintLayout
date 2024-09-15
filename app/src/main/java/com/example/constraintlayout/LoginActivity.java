package com.example.constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{
    private EditText txtlogin, txtpassWord;
    private TextView login, password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        TextView btn = findViewById(R.id.register);
        txtlogin = findViewById(R.id.txtlogin);
        txtpassWord = findViewById(R.id.txtpassWord);
        login = findViewById(R.id.showemail);
        password = findViewById(R.id.showpass);
        btn_login = findViewById(R.id.btn_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(LoginActivity.this, RegisterActivity.class)});
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginInfo();
            }
        });

    }

    protected void showLoginInfo(){
        String userName = txtlogin.getText().toString();
        String passWord = txtpassWord.getText().toString();

        if (userName.isEmpty()){
            showError(txtlogin, "Bạn phải nhập email!!!");
        } else if (!userName.contains("@") || !userName.contains(".com")) {
            showError(txtlogin, "Email phải bao gồm @ và .com!!!");
        } else if(passWord.isEmpty()){
            showError(txtpassWord, "Bạn phải nhập mật khẩu!!!");
        }else{
            login.setText(userName);
            password.setText(passWord);
        }


    }
    private void showError(EditText error, String s){
        error.setError(s);
        error.requestFocus();
    }
}
