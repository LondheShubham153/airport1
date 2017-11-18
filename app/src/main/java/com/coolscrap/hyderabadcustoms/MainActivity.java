package com.coolscrap.hyderabadcustoms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button b1;
    String fName, view, obj, rating;
    String date;
    ImageButton ib;
    EditText name;
    EditText flno;
    EditText pass;
    EditText comments;
    ImageButton angry;
    ImageButton satisfied;
    ImageButton happy;
    ImageButton toDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner mr = (Spinner) findViewById(R.id.mister);
        final Spinner country = (Spinner) findViewById(R.id.country);
        Button button = (Button) findViewById(R.id.subm);
        new SpannableString("HAPPY TO HELP YOU");
        name = (EditText) findViewById(R.id.editText1);
        flno = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.editText3);
        comments = (EditText) findViewById(R.id.editText6);
        angry = (ImageButton) findViewById(R.id.angry);
        satisfied = (ImageButton) findViewById(R.id.satis);
        happy = (ImageButton) findViewById(R.id.happy);
        toDb = (ImageButton) findViewById(R.id.toDb);
b1=(Button)findViewById(R.id.subm);

toDb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i =new Intent(MainActivity.this,login.class);
        startActivity(i);
    }
});
        happy.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                rating = "NEUTRAL";
                angry.setImageResource(R.drawable.s3);
                happy.setImageResource(R.drawable.hapfaded);
                satisfied.setImageResource(R.drawable.n2);
                Toast.makeText(MainActivity.this, rating, 0).show();
                return;
            }

        });

        satisfied.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                rating = "NEUTRAL";
                angry.setImageResource(R.drawable.s3);
                happy.setImageResource(R.drawable.hap);
                satisfied.setImageResource(R.drawable.n2faded);
                Toast.makeText(MainActivity.this, rating, 0).show();
                return;
            }

        });

        angry.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                rating = "SAD";
                satisfied.setImageResource(R.drawable.n2);
                happy.setImageResource(R.drawable.hap);
                angry.setImageResource(R.drawable.s3faded);
                Toast.makeText(MainActivity.this, rating, 0).show();
                return;
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s2 = name.getText().toString().toUpperCase();
                obj = flno.getText().toString().toUpperCase();
                String s = pass.getText().toString().toUpperCase();
                String s1 = comments.getText().toString().toUpperCase();
                String s3 = DateFormat.getDateTimeInstance().format(new Date());
                date = s3;
                    if (s2.equals("") || ((String) (obj)).equals("")  || rating.equals("")) {
                        Toast.makeText(MainActivity.this, "Please fill the required fields", 0).show();
                        return;
                    } else {
                        fName = (new StringBuilder()).append(s2).toString();
                        Toast.makeText(MainActivity.this, (new StringBuilder()).append("Hello ").append(fName).append("\n").append("From ").append(view).append("\nFight ").append(((String) (obj))).append("\nHolding ").append(s).append("\nYou were ").append(rating).append("\n").toString(), 1).show();
                        FeedbackDatabase o;
                        o = new FeedbackDatabase(MainActivity.this);
                        o.open();
                        o.createEntry(fName, obj, view, s, rating, s1, date);
                        o.close();
                        name.setText("");
                        flno.setText("");
                        pass.setText("");
                        comments.setText("");
                        Intent i = new Intent(MainActivity.this, Thankyou.class);
                        startActivity(i);
                        return;
                    }
                }

        });
    }
}
