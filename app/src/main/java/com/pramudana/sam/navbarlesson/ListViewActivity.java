package com.pramudana.sam.navbarlesson;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    ListView list;
    String[] dataName = {

            "Panda Abstract", "Panda Astronauts", "Panda with Bubble", "C.O.P Panda with Donut", "C.O.P Panda with Lollipop"
            , "BAPE Style", "Bear Camouflage"
    };
    int[] pictList = {

            R.drawable.panda, R.drawable.panstronauts, R.drawable.bubble, R.drawable.donut, R.drawable.lollipop, R.drawable.bape
            , R.drawable.bear
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = (ListView)findViewById(R.id.listview);
        ListAdapter myAdapter = new ListAdapter(ListViewActivity.this, dataName, pictList);
        list.setAdapter(myAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent a1 = new Intent(ListViewActivity.this, ListDetailActivity.class);
                a1.putExtra("Name", dataName[i]);
                a1.putExtra("Icon", pictList[i]);
                startActivity(a1);
            }
        });
    }
}
