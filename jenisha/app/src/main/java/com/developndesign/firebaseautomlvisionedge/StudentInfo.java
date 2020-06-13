package com.developndesign.firebaseautomlvisionedge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentInfo extends AppCompatActivity {

    Button btn_show;
    EditText search_bar;
    TextView Username, id, Group;

    TextView name, group;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        btn_show = findViewById(R.id.btn_show);

//        Username = findViewById(R.id.Username);

        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        group = findViewById(R.id.group);

//        Group = findViewById(R.id.Group);

        search_bar = findViewById(R.id.search_bar);
        final String jenisha= "Full Name: Jenisha Nagarkoti, Student ID: 1928956, Group: C3G2 ";
        final String grishma= "Full Name: Grishma Nagarkoti, Student ID: 1928955, Group: C3G2 ";
        final String matina= "Full Name: Matina Skakya, Student ID: 1965488, Group: C3G2 ";
        final String srijay= "Full Name: Srijay Tuladhar , Student ID: 1928946, Group: C3G2 ";
        final String sanish= "Full Name: Sanish Tandukar , Student ID: 1912435, Group: C3G2 ";
        final String sadikshya= "Full Name: Sadikshya Khanal, Student ID: 1276453, Group: C3G2 ";
        final String mohan= "Full Name: Mohan Shrestha, Student ID: 1965432, Group: C3G2 ";
        final String winona= "Full Name: Winona Serchan, Student ID: 1924567, Group: C3G2 ";
        final String dharmajit= "Full Name: Dharmajit Shahi, Student ID: 1928434, Group: C3G2 ";
        final String sairus= "Full Name: Sairus Tandan, Student ID: 1928958, Group: C3G2 ";




        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String search = search_bar.getText().toString();

                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(search);
                databaseReference.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String name = dataSnapshot.child("name").getValue().toString();
//                        String id = dataSnapshot.child("id").getValue().toString();
//                        String group = dataSnapshot.child("group").getValue().toString();


                            if (search.equals("sairus") || search.equals("SAIRUS") || search.equals("Sairus")) {
                            String[] arrSplit = sairus.split(", ");
                            for (int i = 0; i < arrSplit.length; i++) {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }
                        }
                        else if(search.equals("jenisha") || search.equals("JENISHA") || search.equals("Jenisha"))
                        {
                            String[] arrSplit = jenisha.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }

                        }
                        else if(search.equals("grishma") || search.equals("GRISHMA") || search.equals("Grishma"))
                        {
                            String[] arrSplit = grishma.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }
                        else if(search.equals("matina") || search.equals("MATINA") || search.equals("Matina"))
                        {
                            String[] arrSplit = matina.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }
                        }
                        else if(search.equals("sanish") || search.equals("SANISH") || search.equals("Sanish")){
                            String[] arrSplit = sanish.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }
                        else if(search.equals("srijay") || search.equals("SRIJAY") || search.equals("Srijay")){
                            String[] arrSplit = srijay.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }

                        else if(search.equals("mohan") || search.equals("MOHAN") || search.equals("Mohan")){
                            String[] arrSplit = mohan.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }

                        else if(search.equals("dharmajit") || search.equals("DHARMAJIT") || search.equals("Dharmajit")){
                            String[] arrSplit = dharmajit.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }
                        else if(search.equals("winona") || search.equals("WINONA") || search.equals("Winona"))
                        {
                            String[] arrSplit = winona.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }
                        else if(search.equals("sadikshya") || search.equals("SADIKSHYA") || search.equals("Sadikshya"))
                        {
                            String[] arrSplit = sadikshya.split(", ");
                            for (int i=0; i < arrSplit.length; i++)
                            {
                                name.setText(arrSplit[0]);
                                id.setText(arrSplit[1]);
                                group.setText(arrSplit[2]);
                                //System.out.println(arrSplit[i]);
                            }                        }
                        else {
                            name.setText("No Record of that person");
                            id.setText("No Record of that person ");
                            group.setText("No record of that person");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError  databaseError) {

                    }
                });
            }
        });


    }
}