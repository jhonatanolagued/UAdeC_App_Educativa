package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ventana_Registro extends AppCompatActivity {

    EditText nombre;
    EditText usuario;
    EditText contrasena;
    EditText confir_contrasena;
    Button boton_register;
    TextView login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana__registro);
        db= new DatabaseHelper(this);
        nombre = (EditText)findViewById(R.id.txtNombre);
        usuario = (EditText)findViewById(R.id.txtUsuario);
        contrasena = (EditText)findViewById(R.id.txtPassword);
        confir_contrasena = (EditText)findViewById(R.id.txtConfir_Contrasena);
        boton_register = (Button)findViewById(R.id.button);
        login = (TextView)findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToLogin = new Intent (Ventana_Registro.this,MainActivity.class);
                startActivity(moveToLogin);
            }
        });
        boton_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString().trim();
                String pwd = contrasena.getText().toString().trim();
                String cnf_pwd = confir_contrasena.getText().toString().trim();
                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val < 0 && user.equals("") && pwd.equals("") && cnf_pwd.equals("")){
                        Toast.makeText(Ventana_Registro.this,"Error al registrar",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Ventana_Registro.this,"Te has registrado", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Ventana_Registro.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }

                }
                else{
                    Toast.makeText(Ventana_Registro.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
