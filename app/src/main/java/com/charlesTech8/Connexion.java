package com.charlesTech8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Connexion extends AppCompatActivity {

    EditText txtemail, txtpwd;
    Button btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        txtemail = (EditText) findViewById(R.id.email);
        txtpwd = (EditText) findViewById(R.id.password);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtemail.getText().toString();
                String pwd = txtpwd.getText().toString();
                bg background = new bg(Connexion.this);
                background.execute(email, pwd);
            }

        });


    }


    public View.OnClickListener getOnClickListener(View.OnClickListener onClickListener) {
        return onClickListener;
    }


    private class bg extends AsyncTask<String, Void, String> {
        AlertDialog d;
        Context c;

        public bg(Context context) {
            this.c = context;
        }


        @Override
        protected void onPreExecute() {
            d = new AlertDialog.Builder(c).create();
            d.setTitle("Etat de connexion");

        }


        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            String email = strings[0];
            String pwd = strings[1];

            //pour connaître l'adresse ip tapez la commande ipconfig dans l'invite de commande
            String constr = "http://adresse ip/banque2021/connexion.php";

            try {
                URL url = new URL(constr);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);
                OutputStream ops = http.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode("email", "UTF-8") +
                        "&&" + URLEncoder.encode("pwd", "UTF-8") + "=" + URLEncoder.encode("pwd", "UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
                String ligne = "";
                while ((ligne = reader.readLine()) != null) {
                    result += ligne;
                }
                reader.close();
                ips.close();
                http.disconnect();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("error", e.getMessage());
            }

            return result;
        }


        @Override
        protected void onPostExecute(String s) {

            d.setMessage(s);
            d.show();
            if (s.contains("success")) {
                Intent i = new Intent(getApplicationContext(), Client.class);
                startActivity(i);

            }
        }

    }
}