package com.example.cpmishealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class defiled extends AppCompatActivity {
  TextView getdefiled;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defiled);

        getdefiled=findViewById(R.id.getdefiled);
        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("defiled").document("d1");
        DocumentReference docRef1 = db.collection("defiled").document("d1");
        DocumentReference docRef2 = db.collection("defiled").document("d1");
        DocumentReference docRef3 = db.collection("defiled").document("d1");
        DocumentReference docRef4= db.collection("defiled").document("d1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("").append(doc.get("name"));
                    fields.append(" ").append(doc.get("dob"));
                    fields.append("").append(doc.get("pob"));
                    fields.append(" ").append(doc.get("father"));
                    getdefiled.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        docRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name").append(doc.get("name"));
                    fields.append("D.o.B ").append(doc.get("dob"));
                    fields.append("P.o.B ").append(doc.get("pob"));
                    fields.append("Father ").append(doc.get("father"));
                    getdefiled.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name").append(doc.get("name"));
                    fields.append("D.o.B ").append(doc.get("dob"));
                    fields.append("P.o.B ").append(doc.get("pob"));
                    fields.append("Father ").append(doc.get("father"));
                    getdefiled.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name").append(doc.get("name"));
                    fields.append("D.o.B ").append(doc.get("dob"));
                    fields.append("P.o.B ").append(doc.get("pob"));
                    fields.append("Father ").append(doc.get("father"));
                    getdefiled.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name").append(doc.get("name"));
                    fields.append("D.o.B ").append(doc.get("dob"));
                    fields.append("P.o.B ").append(doc.get("pob"));
                    fields.append("Father ").append(doc.get("father"));
                    getdefiled.setText(fields.toString());
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