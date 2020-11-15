package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView TVNombre;
    private TextView TVTelefono ;
    private TextView TVEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre   = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email    = parametros.getString(getResources().getString(R.string.pemail));

        TVNombre   = (TextView) findViewById(R.id.TVNombre);
        TVTelefono = (TextView) findViewById(R.id.TvTelefono);
        TVEmail    = (TextView) findViewById(R.id.TVEmail);

        TVNombre.setText(nombre);
        TVTelefono.setText(telefono);
        TVEmail.setText(email);

    }

    public void llamar(View v){
       String telefono =  TVTelefono.getText().toString();
       startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefono)));

    }

    public void EnviarMail(View v){
        String email = TVEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("Mail to: "));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}