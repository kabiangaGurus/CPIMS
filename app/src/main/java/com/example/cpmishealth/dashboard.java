package com.example.cpmishealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class dashboard extends AppCompatActivity {
    FirebaseFirestore db;
    TextView textDisplay,lowincomeshow,drugaddictsshow,separatedshow;
  TextView defiledtxt;
  Button regchildbtn;
  TextView admregisterusers,admregisterstates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        db = FirebaseFirestore.getInstance();
        textDisplay = findViewById(R.id.defiled);
        lowincomeshow=findViewById(R.id.lowincomeshow);
        drugaddictsshow=findViewById(R.id.drugaddictsshow);
        separatedshow= findViewById(R.id.separatedshow);
        defiledtxt=findViewById(R.id.defiledtxt);
        regchildbtn=findViewById(R.id.regchildbtn);
        admregisterstates=findViewById(R.id.admregisterstates);
        admregisterusers=findViewById(R.id.admregisterusers);

        admregisterusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(dashboard.this,registertypes.class);
                startActivity(intent);
            }
        });

        admregisterstates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this,registerstates.class);
                startActivity(intent);
            }
        });

        regchildbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this,register.class);
                startActivity(intent);
            }
        });

        defiledtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this,defiled.class);
                startActivity(intent);
            }
        });

        DocumentReference docRef = db.collection("cities").document("cities");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append(" ").append(doc.get("defiled"));
                    textDisplay.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append(" ").append(doc.get("lowincome"));
                    lowincomeshow.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append(" ").append(doc.get("drugaddicts"));
                    drugaddictsshow.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append(" ").append(doc.get("separated"));
                    separatedshow.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

    }
}