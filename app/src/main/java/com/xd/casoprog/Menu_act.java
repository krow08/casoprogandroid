package com.xd.casoprog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Menu_act extends AppCompatActivity {

    Button btnJuego;
    Button btnScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu_lyt);

        btnJuego = findViewById(R.id.btnJuego);
        btnScores = findViewById(R.id.btnScores);


        btnJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent btnJuego = new Intent(Menu_act.this, juego_act.class);
                startActivity(btnJuego);
            }
        });

        btnScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnScores = new Intent(Menu_act.this, scores_act.class);
                startActivity(btnScores);
            }
        });
    }
}
