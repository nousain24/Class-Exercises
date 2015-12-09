package com.example.chengen.crowdsafetyalerts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;

public class Aggression extends AppCompatActivity {
    Button ECall,mapBtn;
    String target;
    EditText desAgg;
    int sec,min,hour;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggression);
        ECall = (Button) findViewById(R.id.btnAgg);
        mapBtn = (Button)findViewById(R.id.btnAggMap);
        desAgg = (EditText)findViewById(R.id.etAgg);
        ECall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar time = Calendar.getInstance();
                sec = time.getTime().getSeconds();
                min = time.getTime().getMinutes();
                hour = time.getTime().getHours();
                target = MapsActivity.getTarget();
                send();
            }
        });
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void send(){
        Socket clientSocket=null;
        String time = hour+":"+min+":"+sec;
        try{
            clientSocket = new Socket("168.192.1.10",7000);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("Aggression:  "+time+"  "+target+"  "+desAgg.getText().toString());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(this, "Send successfully", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            System.out.println();
        }
    }
}


