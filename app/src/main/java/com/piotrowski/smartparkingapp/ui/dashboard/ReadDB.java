package com.piotrowski.smartparkingapp.ui.dashboard;

import android.annotation.SuppressLint;
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
import com.piotrowski.smartparkingapp.R;

//0 - space available
//1 - space taken

public class ReadDB extends AppCompatActivity {

    FirebaseDatabase firebaseDB;
    DatabaseReference dbRef1, dbRef2, dbRef3, dbRef4, dbRef5, dbRef6, dbRef7;
    TextView retrieveData, retrieveData2, retrieveData3, retrieveData4, retrieveData5, retrieveData6, retrieveData7;
    ImageView s1O, s1C, s2O, s2C, s3O, s3C, s4O, s4C, s5O, s5C, s6O, s6C, s7O, s7C;
    private static final String TAG = "Something";


    public void start(
                      ImageView s1O, ImageView s2O, ImageView s3O,
                      ImageView s4O, ImageView s5O, ImageView s6O,
                      ImageView s7O) {

//        retrieveData=r1;
//        retrieveData2 = r2;
//        retrieveData3 = r3;
//        retrieveData4 = r4;
//        retrieveData5 = r5;
//        retrieveData6 = r6;
//        retrieveData7 = r7;

        this.s1O = s1O;
        this.s2O = s2O;
        this.s3O = s3O;
        this.s4O = s4O;
        this.s5O = s5O;
        this.s6O = s6O;
        this.s7O = s7O;
//        removePrints();
        firebaseDB = FirebaseDatabase.getInstance();

        //references to individual values in res layout files
        dbRef1 = firebaseDB.getReference("1");
        dbRef2 = firebaseDB.getReference("2");
        dbRef3 = firebaseDB.getReference("3");
        dbRef4 = firebaseDB.getReference("4");
        dbRef5 = firebaseDB.getReference("5");
        dbRef6 = firebaseDB.getReference("6");
        dbRef7 = firebaseDB.getReference("7");

//        retrieveData.setText("Parking Space 01: " + dbRef1.getKey());
//        retrieveData2.setText("Parking Space 02: " + dbRef2.getKey());
//        retrieveData3.setText("Parking Space 03: " + dbRef3.getKey());
//        retrieveData4.setText("Parking Space 04: " + dbRef4.getKey());
//        retrieveData5.setText("Parking Space 05: " + dbRef5.getKey());
//        retrieveData6.setText("Parking Space 06: " + dbRef6.getKey());
//        retrieveData7.setText("Parking Space 07: " + dbRef7.getKey());

        //binding textview variables with textview elements in xml files

        updatedData();

    }

    public void removePrints() {
        retrieveData.setVisibility(View.INVISIBLE);
        retrieveData2.setVisibility(View.INVISIBLE);
        retrieveData3.setVisibility(View.INVISIBLE);
        retrieveData4.setVisibility(View.INVISIBLE);
        retrieveData5.setVisibility(View.INVISIBLE);
        retrieveData6.setVisibility(View.INVISIBLE);
        retrieveData7.setVisibility(View.INVISIBLE);
    }

    public void updatedData(){
        //space01
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long value1 = snapshot.getValue(Long.class);
                StringBuilder str1 = new StringBuilder("Parking Space 01: ");
                System.out.println(value1);
                str1.append(value1);
                System.out.println(str1);
                Log.d(TAG, "Value is: " + value1);
//                retrieveData.setText(str1);
                if (value1 == 0) {
                    s1O.setImageResource(R.drawable.spot_opened);
                } else {
                    s1O.setImageResource(R.drawable.spot_closed);
                }
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
                Long Space02 = snapshot.getValue(Long.class);
                StringBuilder str2 = new StringBuilder("Parking Space 02: ");
                str2.append(Space02);
//                retrieveData2.setText(str2);
                if (Space02 == 0) {
                    s2O.setImageResource(R.drawable.spot_opened);
                } else {
                    s2O.setImageResource(R.drawable.spot_closed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space 03
        dbRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space03= snapshot.getValue(Long.class);
                StringBuilder str3 = new StringBuilder("Parking Space 03: ");
                str3.append(Space03);
//                retrieveData3.setText(str3);
                int s3 = Integer.parseInt(String.valueOf(Space03));
                if (Space03 == 0) {
                    s3O.setImageResource(R.drawable.spot_opened);
                } else {
                    s2O.setImageResource(R.drawable.spot_closed);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space04
        dbRef4.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space04 = snapshot.getValue(Long.class);
                StringBuilder str4 = new StringBuilder("Parking Space 04: ");
                str4.append(Space04);
//                   retrieveData4.setText(str4);

                int s4 = Integer.parseInt(String.valueOf(Space04));
                if (Space04 == 0) {
                    s4O.setImageResource(R.drawable.spot_opened);
                } else {
                    s4O.setImageResource(R.drawable.spot_closed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//
//        //for space05
        dbRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space05 = snapshot.getValue(Long.class);
                StringBuilder str5 = new StringBuilder("Parking Space 05: ");
                str5.append(Space05);
//                   retrieveData5.setText(str5);

                int s5 = Integer.parseInt(String.valueOf(Space05));
                if (Space05 == 0) {
                    s5O.setImageResource(R.drawable.spot_opened);
                } else {
                    s5O.setImageResource(R.drawable.spot_closed);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space06
        dbRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space06 = snapshot.getValue(Long.class);
                StringBuilder str6 = new StringBuilder("Parking Space 06: ");
                str6.append(Space06);
//                      retrieveData6.setText(str6);

                int s6 = Integer.parseInt(String.valueOf(Space06));

                if (Space06 == 0) {
                    s6O.setImageResource(R.drawable.spot_opened);
                } else {
                    s6O.setImageResource(R.drawable.spot_closed);
                }

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
                Long Space07 = snapshot.getValue(Long.class);
                StringBuilder str7 = new StringBuilder("Parking Space 07: ");
                str7.append(Space07);
//                      retrieveData7.setText(str7);

                int s7 = Integer.parseInt(String.valueOf(Space07));

                if (Space07 == 0) {
                    s7O.setImageResource(R.drawable.spot_opened);
                } else {
                    s7O.setImageResource(R.drawable.spot_closed);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }



    }





