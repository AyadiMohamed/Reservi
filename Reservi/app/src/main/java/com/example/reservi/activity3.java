package com.example.reservi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity3 extends AppCompatActivity {
    private TextView ticketclient,totaltickets,tempsestime,tvspinnerGouvernorat;
    private Button  AnnulezReservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        AnnulezReservation=findViewById(R.id.annulerreservation);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        String totalticket = mDatabase.child(String.valueOf(Activity2.tvspinnerGouvernorat)).child(String.valueOf(Activity2.tvspinnerDelegtaion)).child("ticketActuel").push().getKey();
        String ticket = mDatabase.child(String.valueOf(Activity2.tvspinnerGouvernorat)).child(String.valueOf(Activity2.tvspinnerDelegtaion)).child("dernièReTicket").push().getKey();
        ticketclient=findViewById(R.id.editTextNumber2);
        ticketclient.setText(ticket+1);
        totaltickets=findViewById(R.id.editTextNumber3);
        totaltickets.setText(totalticket);
        tempsestime=findViewById(R.id.tempestimé);
        int x= (Integer.parseInt(String.valueOf(ticketclient)))*5-(Integer.parseInt(String.valueOf(totaltickets)))*5;
        tempsestime.setText(x);

        AnnulezReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(activity3.this,Activity2.class);
                startActivity(intent);
            }
        });

    }
}