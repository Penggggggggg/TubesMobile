package com.f55119019.tugasbesar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView log;
    EditText inputEmail, pass1, pass2;
    String email,password, password2;
    Button btndaftar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        log = (TextView)findViewById(R.id.sudahAdaAkun);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.email);
        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.password2);
        btndaftar = findViewById(R.id.buttonDaftar);
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        email = inputEmail.getText().toString();
        password = pass1.getText().toString();
        password2 = pass2.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "Registrasi Sukses", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}