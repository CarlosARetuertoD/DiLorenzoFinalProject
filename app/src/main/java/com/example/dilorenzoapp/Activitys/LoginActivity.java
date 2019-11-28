package com.example.dilorenzoapp.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dilorenzoapp.Clases.Trabajador;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText edit_username_dni, edit_password_login;
    Button btn_login;
    SharedPreferences preferences;
    Boolean session_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        Inicializadores();
        session_state = preferences.getBoolean("session_state",false);
        if(session_state == true){
            Toast.makeText(LoginActivity.this, "Bienvenido ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Menu.class);
            startActivity(intent);
        }
    }
    public void Inicializadores(){
        edit_username_dni = findViewById(R.id.edit_username_dni);
        edit_password_login = findViewById(R.id.edit_password_login);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_username_dni.getText().toString().equals("") && edit_password_login.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Ingrese un DNI o Contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    ConexionRetrofit(edit_username_dni.getText().toString());
                }
            }
        });
    }
    public void ConexionRetrofit(String dni){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<Trabajador> trabajador = interfazServicios.ConsultarTrabajador(dni);
        trabajador.enqueue(new Callback<Trabajador>() {
            @Override
            public void onResponse(Call<Trabajador> call, Response<Trabajador> response) {
                if(response.body() == null){
                    Toast.makeText(LoginActivity.this, "DNI o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }else{
                    ValidarDatos(response.body());
                }
            }
            @Override
            public void onFailure(Call<Trabajador> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    void ValidarDatos(Trabajador trabajador){
        if(trabajador.getContrasenia().equals(edit_password_login.getText().toString())){
            ActualizarPreferencias(trabajador.getDni());
            Toast.makeText(LoginActivity.this, "Bienvenido " + trabajador.getNombre(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Menu.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "DNI o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
    void ActualizarPreferencias(String dni){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("session_state",true);
        editor.putString("user_dni", dni);
        editor.commit();
    }

}
