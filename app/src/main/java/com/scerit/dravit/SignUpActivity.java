package com.scerit.dravit;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText userEmail,userPassword;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userEmail = (EditText) findViewById(R.id.mailText);
        userPassword = (EditText) findViewById(R.id.passwordText);
        signUpBtn = (Button) findViewById(R.id.signBtn);
        mAuth = FirebaseAuth.getInstance();
        loadingSign = new ProgressDialog(this);




        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                CreateNewAccount(userEmail ,userPassword);
            }

            private void CreateNewAccount(EditText inputEmail , EditText inputPassword)
            {
                // loading sign
                loadingSign.setTitle("Creazione Account");
                loadingSign.setMessage("I nostri cricetini stanno creando l'account...");
                loadingSign.setCanceledOnTouchOutside(true);
                loadingSign.show();
                // create mail and pass
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                //AUTH
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpActivity.this, "Utente creato correttamente", Toast.LENGTH_SHORT).show();
                                loadingSign.dismiss();
                            }
                        });


            }


        });


    }
}


