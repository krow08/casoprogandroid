package com.xd.casoprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xd.casoprog.Jugador;

import java.util.ArrayList;


public class Adapter extends BaseAdapter {
    ArrayList<Jugador> lista;

    Context context;
    //Proporciona cantidad de elementos de los que consta el arraylust
    public Adapter(Context context, ArrayList<Jugador> lista ) {
        this.lista = lista;
        this.context = context;
    }//Costryctor

    @Override
    public int getCount() {
        return lista.size();
    }

    //Este metodo devuelve un objeto de una posicion determinads.
    @Override
    public Object getItem(int posicion) {
        return lista.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    //Este metodo es el ecargado de "inflar" a personalizar nuestra lista.
    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        //AQui pregunta si la vista esta vacia, y si es asi ke infla con un layout de items.
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.scores_lyt, null);
        }
        TextView txtName= convertView.findViewById(R.id.txtNombre);
        TextView txtScore= convertView.findViewById(R.id.txtScore);

        txtName.setText(lista.get(posicion).getNombre());
        txtScore.setText(lista.get(posicion).getScore());

        return convertView;
    }
}
