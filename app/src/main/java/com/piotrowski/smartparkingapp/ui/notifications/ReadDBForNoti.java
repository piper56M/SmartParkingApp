package com.piotrowski.smartparkingapp.ui.notifications;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.piotrowski.smartparkingapp.R;
import com.piotrowski.smartparkingapp.ui.dashboard.ReadDB;

public class ReadDBForNoti {
    FirebaseDatabase firebaseDB;
    DatabaseReference dbRef1, dbRef2, dbRef3, dbRef4, dbRef5, dbRef6, dbRef7;
    String s;
    boolean s1, s2, s3, s4, s5, s6, s7, switched;
    NotificationCompat.Builder builder;
    NotificationManager notificationManager;
    Context c;
    Switch notiSwitch;

    public void start(Switch notiSwitch, NotificationCompat.Builder builder, NotificationManager notificationManager, Context c) {
        switched = false;
        this.notiSwitch = notiSwitch;
        firebaseDB = FirebaseDatabase.getInstance();
        this.builder = builder;
        this.notificationManager = notificationManager;
        //references to individual values in res layout files
        dbRef1 = firebaseDB.getReference("1");
        dbRef2 = firebaseDB.getReference("2");
        dbRef3 = firebaseDB.getReference("3");
        dbRef4 = firebaseDB.getReference("4");
        dbRef5 = firebaseDB.getReference("5");
        dbRef6 = firebaseDB.getReference("6");
        dbRef7 = firebaseDB.getReference("7");

        this.c = c;
        //binding textview variables with textview elements in xml files
        createNoti();
        updatedData();
        setBundle();

    }

    public void createNoti() {
        notiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    switched = true;
                } else {
                    switched = false;
                    cancelNotification(0);
                }
            }
        });
    }

    public void cancelNotification(int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) c.getSystemService(ns);
        nMgr.cancel(notifyId);
    }

    public String setBundle() {
        String s = "";
        if (s1) {
            s += "1 is opened!\n";
        }
        if (s2) {
            s += "2 is opened!\n";
        }
        if (s3) {
            s += "3 is opened!\n";
        }
        if (s4) {
            s += "4 is opened!\n";
        }
        if (s5) {
            s += "5 is opened!\n";
        }
        if (s6) {
            s += "6 is opened!\n";
        }
        if (s7) {
            s += "7 is opened!\n";
        }
        if (!s1 && !s2 && !s2 && !s3 && !s4 && !s5 && !s6 && !s7) {
            s+= "no spots open...";
        }
        return s;

    }

    public void updatedData(){
        //space01
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long value1 = snapshot.getValue(Long.class);
                if (value1 == 0) {
                    s1 = true;
                } else {
                    s1 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        //for Space 02
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space02 = snapshot.getValue(Long.class);
                if (Space02 == 0) {
                    s2 = true;
                } else {
                    s2 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space 03
        dbRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space03= snapshot.getValue(Long.class);
                if (Space03 == 0) {
                    s3 = true;
                } else {
                    s3 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space04
        dbRef4.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space04 = snapshot.getValue(Long.class);
                if (Space04 == 0) {
                    s4 = true;
                } else {
                    s4 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//
//        //for space05
        dbRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space05 = snapshot.getValue(Long.class);
                if (Space05 == 0) {
                    s5 = true;
                } else {
                    s5 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDB.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
//
//        //for space06
        dbRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space06 = snapshot.getValue(Long.class);

                if (Space06 == 0) {
                    s6 = true;
                } else {
                    s6 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDBForNoti.this, "Failed to get data.", Toast.LENGTH_SHORT).show();

            }
        });

        //for space 07
        dbRef7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long Space07 = snapshot.getValue(Long.class);
                if (Space07 == 0) {
                    s7 = true;
                } else {
                    s7 = false;
                }
                if (switched) {
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(setBundle()).setBigContentTitle("Open spots:"));
                    notificationManager.notify(0, builder.build());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ReadDBForNoti.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
