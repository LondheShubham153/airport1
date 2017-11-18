package com.coolscrap.hyderabadcustoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText et1,et2;
    Button b1;
    String user,pass,user1,pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1=(EditText)findViewById(R.id.etLogin);
        et2=(EditText)findViewById(R.id.etPassword);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user="1";
                pass="1";

                user1=et1.getText().toString();
                pass1=et2.getText().toString();

                if(user.equals(user1) && pass.equals(pass1) && !user.equals(null) && !user.equals(null)){
                    Intent i =new Intent(login.this,SQLView.class);
                    startActivity(i);
                }
            }
        });
    }
}
