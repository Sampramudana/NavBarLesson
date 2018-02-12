package com.pramudana.sam.navbarlesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerDetail extends AppCompatActivity {

    ImageView recPict;
    TextView recText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_detail);

        recPict = (ImageView)findViewById(R.id.recPict);
        recText = (TextView)findViewById(R.id.recText);

        recText.setText(getIntent().getStringExtra("text"));
        recPict.setImageResource(getIntent().getIntExtra("picture", 1));
    }
}
