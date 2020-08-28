package com.example.cpmishealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
Button childregister;
EditText username,dob,pob,fname,mname,residence,vulnerability;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       username=findViewById(R.id.username);
        childregister = findViewById(R.id.childregister);
        dob=findViewById(R.id.dob);
        pob=findViewById(R.id.pob);
        fname=findViewById(R.id.fname);
        mname=findViewById(R.id.mname);
        residence=findViewById(R.id.residence);
        vulnerability=findViewById(R.id.vulne);

        final FirebaseFirestore firebaseFirestore;
        final DocumentReference ref;
        firebaseFirestore=FirebaseFirestore.getInstance();
        ref = firebaseFirestore.collection("children").document();

        childregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Please type a your full names", Toast.LENGTH_SHORT).show();

                }else if(dob.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Please type  DOB", Toast.LENGTH_SHORT).show();

                }else if(pob.getText().toString().equals("")){
                    Toast.makeText(register.this, "Please type your POB", Toast.LENGTH_SHORT).show();

                }else if(fname.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Please type your FATHERS NAME", Toast.LENGTH_SHORT).show();

                }else if(mname.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Please type your MOTHERS NAME", Toast.LENGTH_SHORT).show();

                }else if(residence.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Please type your RESIDENCE", Toast.LENGTH_SHORT).show();

                }else if(vulnerability.getText().toString().equals("")){
                    Toast.makeText(register.this, "Please type your VULNERABILITY", Toast.LENGTH_SHORT).show();
                }else {

                    ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists())
                            {
                                Toast.makeText(register.this, "Sorry,this user exists", Toast.LENGTH_SHORT).show();
                            } else {
                                Map<String, Object> reg_entry = new HashMap<>();
                                reg_entry.put("name",username.getText().toString());
                                reg_entry.put("dob", dob.getText().toString());
                                reg_entry.put("pob", pob.getText().toString());
                                reg_entry.put("fname", fname.getText().toString());
                                reg_entry.put("mname", mname.getText().toString());
                                reg_entry.put("residence", residence.getText().toString());

                                reg_entry.put("vulnerability", vulnerability.getText().toString());


//                              String myId = ref.getId();
                                firebaseFirestore.collection("client")
                                        .add(reg_entry)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(register.this, "Child Successfully registered", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("Error", e.getMessage());
                                            }
                                        });
                            }
                        }
                    });
                }
            }
        });
    }
}