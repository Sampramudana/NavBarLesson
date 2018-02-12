package com.pramudana.sam.navbarlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDetailActivity extends AppCompatActivity {

    ImageView pict;
    TextView text;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        Intent b2 = getIntent();
        hasil = b2.getStringExtra("Name");
        pict = (ImageView)findViewById(R.id.pict);
        text = (TextView)findViewById(R.id.text);
        text.setText(hasil);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){

            pict.setImageResource(mBundle.getInt("Icon"));
        }
    }
}
