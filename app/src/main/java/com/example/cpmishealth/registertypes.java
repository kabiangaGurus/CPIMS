package com.example.cpmishealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registertypes extends AppCompatActivity {
 Spinner registertypes;
 EditText fname,idno,phone,presidence;
 Button registerperson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertypes);

        registertypes=findViewById(R.id.typeadmin);
        fname=findViewById(R.id.fname);
        idno=findViewById(R.id.idno);
        phone=findViewById(R.id.phone);
        presidence=findViewById(R.id.presidence);
        registerperson=findViewById(R.id.registerperson);

        final FirebaseFirestore firebaseFirestore;
        final DocumentReference ref;
        firebaseFirestore=FirebaseFirestore.getInstance();
        ref = firebaseFirestore.collection("Admins").document();

        registerperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().toString().equals("")) {
                    Toast.makeText(registertypes.this, "Please type  full names", Toast.LENGTH_SHORT).show();

                }else if(idno.getText().toString().equals("")) {
                    Toast.makeText(registertypes.this, "Please type  IdNo", Toast.LENGTH_SHORT).show();

                }else if(phone.getText().toString().equals("")){
                    Toast.makeText(registertypes.this, "Please type  Phone Number", Toast.LENGTH_SHORT).show();

                }else if(presidence.getText().toString().equals("")) {
                    Toast.makeText(registertypes.this, "Please type place of residence", Toast.LENGTH_SHORT).show();

                }else {

                    ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists())
                            {
                                Toast.makeText(registertypes.this, "Sorry,this user exists", Toast.LENGTH_SHORT).show();
                            } else {
                                Map<String, Object> reg_entry = new HashMap<>();
                                reg_entry.put("fname",fname.getText().toString());
                                reg_entry.put("idno", idno.getText().toString());
                                reg_entry.put("phone", phone.getText().toString());
                                reg_entry.put("presidence", presidence.getText().toString());


//                              String myId = ref.getId();
                                firebaseFirestore.collection("Admins")
                                        .add(reg_entry)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(registertypes.this, " User Successfully registered", Toast.LENGTH_SHORT).show();
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




        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_admin, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        registertypes.setAdapter(adapter);

        registertypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView)parentView.getChildAt(0)).setTextColor(Color.CYAN);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}