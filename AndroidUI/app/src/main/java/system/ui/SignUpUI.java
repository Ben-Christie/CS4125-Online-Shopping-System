package system.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import UIControls.LoginController;
import UIControls.SignUpController;

public class SignUpUI extends AppCompatActivity {
    EditText editEmail, editPassword, editConfirmPassword;
    Button signUpButton;
    TextView toLogin;
    SignUpController signUpController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_ui);
        signUpController = new SignUpController(SignUpUI.this);
        createObjects();
        signUpButton.setEnabled(false);

        signUpButton.setOnClickListener(view -> {
            signUpController.createAccount(editEmail.getText().toString().trim(),editPassword.getText().toString().trim());
        });
        verifyConfirmPassword();
    }



    /*
    UI side logic that checks if the password and confirmed password are the
    same as you type them
     */
    private void verifyConfirmPassword(){
        editConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editConfirmPassword.getText().toString().isEmpty()){
                    if(editConfirmPassword.getText().toString().equals(editPassword.getText().toString())){
                        signUpButton.setEnabled(true);
                    }else {
                        signUpButton.setEnabled(false);
                    }
                }

            }
        });
    }

    private void createObjects() {
        editEmail = findViewById(R.id.signUpEmail);
        editPassword = findViewById(R.id.signUpPassword);
        editConfirmPassword = findViewById(R.id.signUpConfirmPassword);
        signUpButton = findViewById(R.id.signUpButton);
        toLogin = findViewById(R.id.loginLink);
    }
}