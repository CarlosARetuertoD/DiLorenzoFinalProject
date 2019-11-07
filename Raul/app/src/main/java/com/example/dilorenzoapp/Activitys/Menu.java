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
    ImageView bgapp, clover;
    LinearLayout textsplash, texthome;
    ConstraintLayout menus;
    Animation frombottom;
    ImageButton btn_ventas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        bgapp =  findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash =  findViewById(R.id.textsplash);
        texthome =  findViewById(R.id.texthome);
        menus =  findViewById(R.id.menus);

        btn_ventas = findViewById(R.id.btn_ventas);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(800);
        clover.animate().alpha(0).setDuration(800).setStartDelay(1600);
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

    }
}