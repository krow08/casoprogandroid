package com.xd.casoprog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

public class scores_act extends AppCompatActivity {
    ListView listScores;
    Jugador jugador;

    Registro registroS;

    Button btnVolver;
    ArrayAdapter adapterP;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.scores_lyt);

        registroS=Registro.getInstancia();

        listScores=findViewById(R.id.listScores);

//        btnVolver = findViewById(R.id.btnVolver);
//
//        btnVolver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent btnVolver = new Intent(scores_act.this, Menu_act.class);
//                startActivity(btnVolver);
//            }
//        });

        adapterP=new ArrayAdapter<Jugador>(scores_act.this,android.R.layout.simple_list_item_1,registroS.devolverLista() ) ;

//        adapterP = new Adapter(scores_act.this, registroS.devolverLista());
        listScores.setAdapter(adapterP);

    }
}