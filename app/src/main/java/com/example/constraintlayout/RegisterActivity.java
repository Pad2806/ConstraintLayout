package com.example.constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TextView showLogin, showPass, showPNum, showRePass;
    Button btn_register;
    EditText register, pNum, pass, rePass;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        TextView btn = findViewById(R.id.haveaccount);
        showLogin = findViewById(R.id.showemail);
        showPass = findViewById(R.id.showpass);
        showPNum = findViewById(R.id.showPNum);
        showRePass = findViewById(R.id.showRepass);
        btn_register = findViewById(R.id.btn_register);
        register = findViewById(R.id.email_register);
        pNum = findViewById(R.id.pNum_register);
        pass = findViewById(R.id.pass_register);
        rePass = findViewById(R.id.repass_register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(RegisterActivity.this, LoginActivity.class)});
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterInfo();
            }
        });
    }
    protected void showRegisterInfo(){
        String userName = register.getText().toString();
        String txtpNum = pNum.getText().toString();
        String txtpassWord = pass.getText().toString();
        String txtRepassWord = rePass.getText().toString();

        if (userName.isEmpty()){
            showError(register, "Bạn phải nhập email!!!");
        } else if (!userName.contains("@") || !userName.contains(".com")) {
            showError(register, "Email phải bao gồm @ và .com!!!");
        } else if (txtpNum.isEmpty()) {
            showError(pNum, "Bạn phải nhập số điện thoại!!!");
        } else if (pNum.length() !=10) {
            showError(pNum, "Số điện thoại phải gồm 10 số!!!");
        } else if(txtpassWord.isEmpty()){
            showError(pass, "Bạn phải nhập mật khẩu!!!");
        } else if(txtRepassWord.isEmpty()){
            showError(pass, "Bạn phải xác nhận mật khẩu!!!");
        } else if (!txtpassWord.equals(txtRepassWord)) {
            showError(rePass, "Mật khẩu không giống xác nhận mật khẩu!!!");
        }else {
            showLogin.setText(userName);
            showPNum.setText(txtpNum);
            showPass.setText(txtpassWord);
            showRePass.setText(txtRepassWord);
        }
    }
    private void showError(EditText error, String s){
        error.setError(s);
        error.requestFocus();
    }
}
