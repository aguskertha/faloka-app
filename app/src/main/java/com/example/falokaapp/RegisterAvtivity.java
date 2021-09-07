package com.example.falokaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.falokaapp.Model.User;

public class RegisterAvtivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvLogin;
    EditText edtUsername;
    EditText edtPassword;
    EditText edtUlangPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = findViewById(R.id.edt_regis_username);
        edtPassword = findViewById(R.id.edt_regis_password);
        edtUlangPassword = findViewById(R.id.edt_regis_ulangpassword);

        tvLogin = findViewById(R.id.tv_login_disini);
        tvLogin.setOnClickListener(this);

        btnRegister = findViewById(R.id.btn_regis_register);
        btnRegister.setOnClickListener(this);

        edtUlangPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!validPassword(edtPassword.getText().toString().trim(), edtUlangPassword.getText().toString().trim())){
                    edtUlangPassword.setError("Password tidak sama!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tv_login_disini){
            actionLogin();
        }
        if(view.getId() == R.id.btn_regis_register){
            actionRegister();
        }
    }

    public void actionLogin(){
        Intent intentLogin = new Intent(RegisterAvtivity.this, LoginActivity.class);
        startActivity(intentLogin);
    }

    public void actionRegister(){
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String ulangPassword = edtUlangPassword.getText().toString().trim();

        if(!validPassword(password, ulangPassword)){
            Toast toast = Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if(!isEmptyField(user)){
                Toast toast = Toast.makeText(this, "Register berhasil!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public boolean validPassword(String password, String ulangPass){
        return password.equals(ulangPass);
    }

    public boolean isEmptyField(User user){
        boolean fill = false;
        if(TextUtils.isEmpty(user.getUsername())){
            fill = true;
            edtUsername.setError("Masukkan username!");
        }
        if(TextUtils.isEmpty(user.getPassword())){
            fill = true;
            edtPassword.setError("Masukkan password!");
        }
        return fill;
    }
}