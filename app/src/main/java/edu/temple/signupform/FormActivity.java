package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button saveButton;

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPasswordConfirm;

    TextView errorName;
    TextView errorEmail;
    TextView errorPassword;
    TextView errorPasswordConfirm;

    String name, email, password, passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.saveButton);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = (EditText) findViewById(R.id.editTextPasswordConfirm);

        errorName = (TextView) findViewById(R.id.errorName);
        errorEmail = (TextView) findViewById(R.id.errorEmail);
        errorPassword = (TextView) findViewById(R.id.errorPassword);
        errorPasswordConfirm = (TextView) findViewById(R.id.errorPasswordConfirm);

        errorName.setVisibility(View.GONE);
        errorEmail.setVisibility(View.GONE);
        errorPassword.setVisibility(View.GONE);
        errorPasswordConfirm.setVisibility(View.GONE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = editTextName.getText().toString();

                if (name.equals("")) {
                    errorName.setVisibility(View.VISIBLE);
                } else {
                    errorName.setVisibility(View.GONE);
                }

                email = editTextEmail.getText().toString();

                if (email.equals("")) {
                    errorEmail.setVisibility(View.VISIBLE);
                } else {
                    errorEmail.setVisibility(View.GONE);
                }

                password = editTextPassword.getText().toString();

                if (password.equals("")) {
                    errorPassword.setVisibility(View.VISIBLE);
                } else {
                    errorPassword.setVisibility(View.GONE);
                }

                passwordConfirm = editTextPasswordConfirm.getText().toString();

                if (passwordConfirm.equals("")) {
                    errorPasswordConfirm.setText(R.string.errorEmpty);
                    errorPasswordConfirm.setVisibility(View.VISIBLE);
                } else if (!passwordConfirm.equals(password)) {
                    errorPasswordConfirm.setText(R.string.errorMatch);
                    errorPasswordConfirm.setVisibility(View.VISIBLE);
                } else {
                    errorPasswordConfirm.setVisibility(View.GONE);
                }

                if (!name.equals("") && !email.equals("") && !password.equals("") && password.equals(passwordConfirm)) {
                    Toast.makeText(FormActivity.this, "Welcome " + name + " to the SignUpForm App!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}