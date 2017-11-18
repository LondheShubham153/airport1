package com.coolscrap.hyderabadcustoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    public Button bt1;
    public TextView tvData,sa,ha,ang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        tvData = (TextView) findViewById(R.id.textViewc);
        bt1 = (Button) findViewById(R.id.reset);
        sa=(TextView)findViewById(R.id.ang);
                ang=(TextView)findViewById(R.id.neu);
                ha=(TextView)findViewById(R.id.sat);
         final FeedbackDatabase info = new FeedbackDatabase(this);
        info.open();
        String s = info.getData();
        int s1= info.getAngry();
        int s2= info.getHappy();
        int s3= info.getSatisfied();
        tvData.setText(s);
       /* ang.setText(s1);
        ang.setText(s3);
        ha.setText(s2);
        */bt1.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                info.resetData();
                Intent i = new Intent(DetailView.this,login.class);
                finish();
                startActivity(i);
                return;
            }

        });
    }
}
