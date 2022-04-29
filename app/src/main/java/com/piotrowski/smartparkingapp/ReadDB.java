package com.piotrowski.smartparkingapp;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

//0 - space available
//1 - space taken

public class ReadDB extends AppCompatActivity {

    FirebaseDatabase firebaseDB;
    DatabaseReference dbRef1, dbRef2, dbRef3, dbRef4, dbRef5, dbRef6, dbRef7;
   // TextView retrieveData, retrieveData2, retrieveData3, retrieveData4, retrieveData5, retrieveData6, retrieveData7;
    TextView retrieveData;
    ImageView check1, check2, check3, check4, check5, check6, check7;
    ImageView x1, x2, x3, x4, x5, x6, x7;
    private static final String TAG = "Something";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        firebaseDB = FirebaseDatabase.getInstance();

        //references to individual values in res layout files
        dbRef1 = firebaseDB.getReference("1");
        dbRef2 = firebaseDB.getReference("2");
        dbRef3 = firebaseDB.getReference("3");
        dbRef4 = firebaseDB.getReference("4");
        dbRef5 = firebaseDB.getReference("5");
        dbRef6 = firebaseDB.getReference("6");
        dbRef7 = firebaseDB.getReference("7");

        //binding textview variables with textview elements in xml files
        retrieveData = findViewById(R.id.SpaceState);
       /* retrieveData2 = findViewById(R.id.NSpace02);
        retrieveData3 = findViewById(R.id.NSpace03);
        retrieveData4 = findViewById(R.id.NSpace04);
        retrieveData5 = findViewById(R.id.NSpace05);
        retrieveData6 = findViewById(R.id.NSpace06);
        retrieveData7 = findViewById(R.id.NSpace07);*/

            updatedData();


    }

    public void updatedData(){



        //space01
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value1 = snapshot.getValue(String.class);
                StringBuilder str1 = new StringBuilder("Parking Space 01: ");
                str1.append(value1);
                Log.d(TAG, "Value is: " + value1);
                retrieveData.setText(str1);

               /* int s1 = Integer.parseInt(Space01);


                if(s1 == 0){
                    check1.setVisibility(View.INVISIBLE);
                }

                if(s1 == 1){
                    x1.setVisibility(View.INVISIBLE);
                }*/


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        //for Space 02
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space02 = snapshot.getValue(String.class);
                StringBuilder str2 = new StringBuilder("Parking Space 02: ");
                str2.append(Space02);
                //  retrieveData2.setText(Space02);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        //for space 03
        dbRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space03 = snapshot.getValue(String.class);
                StringBuilder str3 = new StringBuilder("Parking Space 03: ");
                str3.append(Space03);
                //   retrieveData3.setText(str3);

                int s3 = Integer.parseInt(Space03);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        //for space04
        dbRef4.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space04 = snapshot.getValue(String.class);
                StringBuilder str4 = new StringBuilder("Parking Space 04: ");
                str4.append(Space04);
                //   retrieveData4.setText(str4);

                int s4 = Integer.parseInt(Space04);

                if(s4 == 1){
                    check4.setVisibility(View.GONE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });


        //for space05
        dbRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space05 = snapshot.getValue(String.class);
                StringBuilder str5 = new StringBuilder("Parking Space 05: ");
                str5.append(Space05);
                //   retrieveData5.setText(str5);

                int s5 = Integer.parseInt(Space05);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        //for space06
        dbRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space06 = snapshot.getValue(String.class);
                StringBuilder str6 = new StringBuilder("Parking Space 06: ");
                str6.append(Space06);
                //      retrieveData6.setText(str6);

                int s6 = Integer.parseInt(Space06);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();

            }
        });

        //for space 07
        dbRef7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Space07 = snapshot.getValue(String.class);
                StringBuilder str7 = new StringBuilder("Parking Space 07: ");
                str7.append(Space07);
                //      retrieveData7.setText(str7);

                int s7 = Integer.parseInt(Space07);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }



    }





