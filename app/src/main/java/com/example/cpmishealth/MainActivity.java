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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
Button Login;

    private EditText emailid;
    private EditText pass;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        emailid = findViewById(R.id.txtmail);
        pass = findViewById(R.id.txtpassword);
        Login = findViewById(R.id.btnsignin);


        mAuth = FirebaseAuth.getInstance();





        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser = mAuth.getCurrentUser();
                if (mfirebaseuser != null) {

                    Toast.makeText(MainActivity.this, "Your are now Logged In.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, dashboard.class);

                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please Login.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtmail = emailid.getText().toString();
                String txtpassword = pass.getText().toString();


                if (txtmail.isEmpty()) {

                    emailid.setError("Email is Required");
                    emailid.requestFocus();
                } else if (txtpassword.isEmpty()) {

                    pass.setError("Password is Required");
                    pass.requestFocus();
                } else if ((txtmail.isEmpty() && txtpassword.isEmpty())) {

                    Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (txtmail != null && txtpassword != null) {


                    mAuth.signInWithEmailAndPassword(txtmail, txtpassword).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Error,Please Login Again", Toast.LENGTH_SHORT).show();

                            } else {
                                Intent intoclick = new Intent(MainActivity.this, dashboard.class);
                                startActivity(intoclick);
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuth.signOut();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}