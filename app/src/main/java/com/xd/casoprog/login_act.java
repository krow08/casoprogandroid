package com.xd.casoprog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_act extends AppCompatActivity {
    Button btnRegistrar;
    EditText txtNombre, txtScore;

    private String score = " ";
    private Object arraylist[];
    private Registro registro = Registro.getInstancia();
    private Adapter adapterP;

    Jugador jugador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_lyt);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtNombre = findViewById(R.id.txtNombre);
        txtScore = findViewById(R.id.txtScore);

        score = getIntent().getStringExtra("score");
        txtScore.setText(score);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor digite el nombre", Toast.LENGTH_SHORT).show();
                } else {
                    jugador = new Jugador(txtNombre.getText().toString(), txtScore.getText().toString());
                    String mensaje = registro.agregarJugador(jugador);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login_act.this,Menu_act.class);
                    startActivity(intent);


                }
            }
        });


    }
}