package com.pramudana.sam.navbarlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerPict;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerPict = findViewById(R.id.recyclerPict);
        recyclerPict.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerActivity.CustomAdapter();
        recyclerPict.setAdapter(adapter);
    }
    String[] namePict = {

            "Style with BAPE", "HUF Sea", "HUF Brand", "Mad Gerald", "Slothnauts", "Yeezy"
    };
    int[] pict = {

            R.drawable.bape_style, R.drawable.huf_sea, R.drawable.huf, R.drawable.mad, R.drawable.sloth
            , R.drawable.yeezy
    };

    private class CustomAdapter extends RecyclerView.Adapter<RecyclerActivity.CustomAdapter.MyViewHolder> {
        @Override
        public RecyclerActivity.CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, null);
            return new RecyclerActivity.CustomAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerActivity.CustomAdapter.MyViewHolder holder, final int position) {

            holder.judul.setText(namePict[position]);
            holder.img.setImageResource(pict[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent a1 = new Intent(RecyclerActivity.this, RecyclerDetail.class);
                    a1.putExtra("text", namePict[position]);
                    a1.putExtra("picture", pict[position]);
                    startActivity(a1);

                }
            });
        }

        @Override
        public int getItemCount() {
            return namePict.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView judul;
            ImageView img;

            public MyViewHolder(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
