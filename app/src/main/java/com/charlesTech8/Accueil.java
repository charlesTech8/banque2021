package com.charlesTech8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }

    public void depot(View view) {
        Intent depot = new Intent(this, Depot.class);
        startActivity(depot);
    }

    public void retrait(View view) {
        Intent retrait = new Intent(this, Retrait.class);
        startActivity(retrait);
    }

    public void transfert(View view) {
        Intent transfert = new Intent(this, Transfert.class);
        startActivity(transfert);
    }

    public void historique(View view) {

    }

    public void consulter(View view) {

    }

    public void deconnexion(View view) {
        finish();
    }

    public void client(View view) {
        Intent client = new Intent(this, Client.class);
        startActivity(client);
    }
}