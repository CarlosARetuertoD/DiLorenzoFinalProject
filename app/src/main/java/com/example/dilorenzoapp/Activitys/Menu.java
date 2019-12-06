package com.example.dilorenzoapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dilorenzoapp.R;

public class Menu extends AppCompatActivity {
    ImageView bgapp;
    LinearLayout textsplash, texthome;
    ConstraintLayout menus;
    Animation frombottom;
    ImageButton btn_ventas, btn_perfil,btn_tus_zonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp =  findViewById(R.id.bgapp);
        textsplash =  findViewById(R.id.textsplash);
        texthome =  findViewById(R.id.texthome);
        menus =  findViewById(R.id.menus);

        btn_tus_zonas = findViewById(R.id.btn_zonas);
        btn_ventas = findViewById(R.id.btn_ventas);
        btn_perfil = findViewById(R.id.btn_perfil);
        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(800);
        textsplash.animate().translationY(140).alpha(0).setDuration(1800).setStartDelay(3000);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        btn_ventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, PedidosActivity.class);
                startActivity(intent);
            }
        });

        btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
        btn_tus_zonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ZonasTrabajadorActivity.class);
                startActivity(intent);
            }
        });

    }
}