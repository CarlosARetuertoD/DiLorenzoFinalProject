package com.example.dilorenzoapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.Clases.Trabajador;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PerfilActivity extends AppCompatActivity {
    TextInputLayout txt_nombre, txt_apellidos, txt_dni, txt_contrasenia, txt_contacto;
    CircleImageView img_foto_perfil;
    String user_dni;
    FloatingActionButton fab_close_session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        ObtenerDni();
        Inicializador();
        ConexionRetrofit();
    }
    void ObtenerDni(){
        SharedPreferences preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        user_dni = preferences.getString("user_dni","0000000");
    }
    void Inicializador(){
        fab_close_session = findViewById(R.id.fab_close_session);
        txt_nombre = findViewById(R.id.txt_nombres);
        txt_apellidos = findViewById(R.id.txt_apellidos);
        txt_dni = findViewById(R.id.txt_dni);
        txt_contrasenia = findViewById(R.id.txt_contrasenia);
        txt_contacto = findViewById(R.id.txt_contacto);
        img_foto_perfil = findViewById(R.id.img_foto_perfil);

        fab_close_session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PerfilActivity.this, "Hasta luego .... ", Toast.LENGTH_SHORT).show();
                CerrarSession();
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    void CerrarSession(){
        SharedPreferences settings = this.getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("session_state",false);
        editor.putString("user_dni", null);
        editor.commit();
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<Trabajador> trabajador = interfazServicios.ConsultarTrabajador(user_dni);
        trabajador.enqueue(new Callback<Trabajador>() {
            @Override
            public void onResponse(Call<Trabajador> call, Response<Trabajador> response) {
                ActualizarData(response.body());
            }

            @Override
            public void onFailure(Call<Trabajador> call, Throwable t) {

            }
        });
    }
    void ActualizarData(Trabajador trabajador){
        txt_nombre.getEditText().setText(trabajador.getNombre());
        txt_apellidos.getEditText().setText(trabajador.getApellidos());
        txt_dni.getEditText().setText(trabajador.getDni());
        txt_contrasenia.getEditText().setText(trabajador.getContrasenia());
        txt_contacto.getEditText().setText(trabajador.getContacto());
        Glide.with(this).load(trabajador.getFoto_perfil()).into(img_foto_perfil);
    }
}
