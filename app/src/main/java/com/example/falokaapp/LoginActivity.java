package com.example.falokaapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.falokaapp.Model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //====DUMMY USER====
    User userDummy;
    //==================

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.userDummy = new User();
        this.userDummy.setUsername("AGUS");
        this.userDummy.setEmail("agus@gmail.com");
        this.userDummy.setPassword("AGUS");

        edtUsername = findViewById(R.id.edt_regis_username);
        edtPassword = findViewById(R.id.edt_regis_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_login){
            actionLogin();
        }
        if(view.getId() == R.id.btn_register){
            actionRegister();
        }
    }

    public void actionLogin(){
//        User user = new User();
//        user.setUsername(edtUsername.getText().toString().trim());
//        user.setPassword(edtPassword.getText().toString().trim());
//        if(!isEmptyField(user)){
//            if(isValidUser(user)) {
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
//                loginIntent.putExtra(ListProductActivity.EXTRA_USERNAME, user.getUsername());
//                loginIntent.putExtra(ListProductActivity.EXTRA_PASSWORD, user.getPassword());
                startActivity(loginIntent);
//            }
//        }
    }

    public void actionRegister(){
        Intent registerIntent = new Intent(LoginActivity.this, RegisterAvtivity.class);
        startActivity(registerIntent);
    }

    public boolean isEmptyField(User user){
        boolean fill = false;
        if(TextUtils.isEmpty(user.getUsername())){
            fill = true;
            edtUsername.setError("Masukkan username / email dahulu!");
        }
        if(TextUtils.isEmpty(user.getPassword())){
            fill = true;
            edtPassword.setError("Masukkan password!");
        }
        return fill;
    }

    public boolean isValidUser(User user){
        boolean valid = false;
        if((user.getUsername().equals(userDummy.getEmail())) || (user.getUsername().equals(userDummy.getUsername()))){
            if(user.getPassword().equals(userDummy.getPassword())){
                valid = true;
            }
        }else{
            Toast toast = Toast.makeText(this, "Username dan Password tidak sesuai!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return valid;
    }
}
