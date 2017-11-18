package com.coolscrap.hyderabadcustoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SQLView extends AppCompatActivity {
    public Button b1;
    public TextView tvAngry;
    public TextView tvData;
    public TextView tvEnjoyed;
    public TextView tvHappy;
    public TextView tvSad;
    public TextView tvSatisfied;
    public TextView tva;
    public TextView tvh;
    public TextView tvn;
    public TextView tvs;
    public TextView tvsat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);


                tvAngry = (TextView)findViewById(R.id.textView4);
                tvSatisfied = (TextView)findViewById(R.id.textView5);
                tvHappy = (TextView)findViewById(R.id.textView6);
                tvData = (TextView)findViewById(0x7f0d0080);
                tva = (TextView)findViewById(0x7f0d0097);
                tvn = (TextView)findViewById(0x7f0d0099);
                tvsat = (TextView)findViewById(0x7f0d009b);
                FeedbackDatabase bundle = new FeedbackDatabase(this);
                bundle.open();
                String s = bundle.getComments();
                bundle.getAngry();
                int i = bundle.getSad();
                int j = bundle.getSatisfied();
                bundle.getHappy();
                int k = bundle.getEnjoyed();
                bundle.close();
                tvAngry.setText("\tSAD            \t\t\t\t");
                tvSatisfied.setText("\tNEUTRAL  \t\t\t\t");
                tvHappy.setText("\tHAPPY       \t\t\t\t");
                tvData.setText(s);
                b1 = (Button)findViewById(R.id.btDetail);
                b1.setOnClickListener(new android.view.View.OnClickListener() {

                    public void onClick(View view)
                    {       Intent i = new Intent(SQLView.this,DetailView.class);
                        finish();
                        startActivity(i);
                        return;
                    }


                });
            }

        }

