package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private Button btnReq;
    private TextView textView;
    RequestQueue queue;
    StringRequest stringRequest;
    String url="https://run.mocky.io/v3/07f37d9f-a9e6-408a-bef3-93f12d92e216";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReq= (android.widget.Button) findViewById(R.id.btnReq);
        textView=(TextView)findViewById(R.id.textView);

        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

    }
    private void getData(){
        //creazione coda richieste
    queue = Volley.newRequestQueue(this);
    //creazione richiesta
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //visualizzare risultato
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //visualizzare messaggio di errore
                textView.setText("Errore");
            }
        });

                //aggiunta richiesta alla coda
        queue.add(stringRequest);
    }
}