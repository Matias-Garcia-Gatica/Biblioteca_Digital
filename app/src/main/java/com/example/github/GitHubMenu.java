package com.example.github;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Biblioteca.Planes_biblio;

public class GitHubMenu extends AppCompatActivity
{
    private Spinner spin1;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_menu);

        spin1 = (Spinner)findViewById(R.id.spinner);
        txt1 = (TextView)findViewById(R.id.text1);

        ArrayList<String> listalibros = (ArrayList<String>) getIntent().getSerializableExtra("listalibros");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listalibros);

        spin1.setAdapter(adapt);
    }
    public void Calcular(View V)
    {
        String Valores = spin1.getSelectedItem().toString();

        Planes_biblio libro= new Planes_biblio();  // Construir mi objeto.
        int resultFarenheith = libro.getFarenheith();
        int resultRevival =  libro.getRevival();
        int resultElAlquimista = libro.getElAlquimista();

        if(Valores.equals("Farenheith") )
        {
            txt1.setText("El precio del plan es: "+resultFarenheith );
        }

        if(Valores.equals("Revival") )
        {
            txt1.setText("El precio del plan es: "+resultRevival );
        }

        if(Valores.equals("El Alquimista") )
        {
            txt1.setText("El precio del plan es: "+resultElAlquimista );
        }
    }
}