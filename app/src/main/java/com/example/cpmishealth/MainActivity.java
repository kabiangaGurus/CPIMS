package com.example.cpmishealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
Button btnsignin;
EditText username,pswrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnsignin = (Button) findViewById(R.id.btnsignin);
        username = (EditText) findViewById(R.id.username);
        pswrd = (EditText) findViewById(R.id.pswrd);

        final FirebaseFirestore firebaseFirestore;
        final DocumentReference db;
        firebaseFirestore = FirebaseFirestore.getInstance();
        db = firebaseFirestore.collection("client").document();

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
            }
        });

//        btnsignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case  R.id.btnsignin:
//                        if (username.getText().toString().equals("")){
//                            Toast.makeText(MainActivity.this, "Please enter valid username", Toast.LENGTH_SHORT).show();
//                        }else  if (pswrd.getText().toString().equals("")) {
//                            Toast.makeText(MainActivity.this, "Please enter correct password",Toast.LENGTH_SHORT).show();
//                        }
//                        db.collection("Admins")
//                                .get()
//                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                        for (QueryDocumentSnapshot doc: task.getResult()) {
//                                            String a1 = username.getText().toString().trim();
//                                            String b1 = pswrd.getText().toString().trim();
//                                            if (username.getText().toString().equals(a1)& pswrd.getText().toString().equals(b1)) {
//
//                                                Intent home = new Intent(MainActivity.this, dashboard.class);
//                                                startActivity(home);
//                                                Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
//                                                break;
//                                            }else {
//                                                Toast.makeText(MainActivity.this, "Cannot login, Incorrect credentials", Toast.LENGTH_SHORT).show();
//                                            }
//
//                                        }
//                                    }
//                                });
//                }
//            }
//        });
    }
}