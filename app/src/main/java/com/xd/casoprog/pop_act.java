package com.xd.casoprog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.w3c.dom.Text;

public class pop_act extends AppCompatActivity {

    ImageButton btnJuego;
    Button btnLogin;
    EditText txtScore;
    private String score = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_lyt);
        btnJuego = findViewById(R.id.btnJuego);
        btnLogin = findViewById(R.id.btnLogin);


        score = getIntent().getStringExtra("score");


        btnJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnJuego = new Intent(pop_act.this, juego_act.class);
                startActivity(btnJuego);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent btnLogin = new Intent(pop_act.this, login_act.class);
                btnLogin.putExtra("score", score);
                startActivity(btnLogin);
            }
        });



    }

}
