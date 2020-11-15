package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Joan Ibarra","11112222","joan.ibarra@gmail.com"));
        contactos.add(new Contacto("Lucca Ariaudo","33334444","lucca.ariaudo@gmail.com"));
        contactos.add(new Contacto("Braulio Oyola","99998888","braulio.oyola@gmail.com"));
        contactos.add(new Contacto("Nicolas Soto","55556666","nicolas.soto@gmail.com"));
        contactos.add(new Contacto("Federico Báez","77770000","federico.baez@gmail.com"));

        ArrayList<String> NombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos)
        {
            NombresContacto.add(contacto.getNombre());
        }
        
        ListView MyList = (ListView) findViewById(R.id.MyList);
        MyList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NombresContacto));

        MyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());

                startActivity(intent);

                finish();
            }
        });
    }
}