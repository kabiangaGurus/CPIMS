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

public class registerstates extends AppCompatActivity {
Spinner registerstates,text;
EditText statename,stateregno,location,tel;
Button regstates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerstates);

      registerstates= findViewById(R.id.typestate);
        statename=findViewById(R.id.statename);
        stateregno=findViewById(R.id.stateregno);
        location=findViewById(R.id.location);
        tel = findViewById(R.id.tel);
        regstates=(Button)findViewById(R.id.regstates);



        final FirebaseFirestore firebaseFirestore;
        final DocumentReference ref;
        firebaseFirestore=FirebaseFirestore.getInstance();
        ref = firebaseFirestore.collection("states").document();

        regstates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statename.getText().toString().equals("")) {
                    Toast.makeText(registerstates.this, "Please type states name", Toast.LENGTH_SHORT).show();

                }else if(stateregno.getText().toString().equals("")) {
                    Toast.makeText(registerstates.this, "Please type  state regno", Toast.LENGTH_SHORT).show();

                }else if(location.getText().toString().equals("")){
                    Toast.makeText(registerstates.this, "Please type  state location", Toast.LENGTH_SHORT).show();

                }else if(tel.getText().toString().equals("")) {
                    Toast.makeText(registerstates.this, "Please type state tel", Toast.LENGTH_SHORT).show();

                }else {

                    ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists())
                            {
                                Toast.makeText(registerstates.this, "Sorry,this user exists", Toast.LENGTH_SHORT).show();
                            } else {
                                Map<String, Object> reg_entry = new HashMap<>();
                                reg_entry.put("statename",statename.getText().toString());
                                reg_entry.put("stateregno", stateregno.getText().toString());
                                reg_entry.put("location", location.getText().toString());
                                reg_entry.put("tel", tel.getText().toString());




//                              String myId = ref.getId();
                                firebaseFirestore.collection("states")
                                        .add(reg_entry)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(registerstates.this, "State Successfully registered", Toast.LENGTH_SHORT).show();
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
                R.array.type_state, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        registerstates.setAdapter(adapter);

        registerstates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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