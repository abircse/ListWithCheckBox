package com.coxtunes.listviewcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SubCategory> SubCategorylist = new ArrayList<SubCategory>();
    ListView list;
    SubCategoryAdapter adapter;
    Button checkItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        checkItems = findViewById(R.id.button);

        checkItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Checked items: ";

                for (int i = 0; i < list.getCount(); i++) {
                    v = list.getChildAt(i);

                    CheckBox cb = v.findViewById(R.id.checkbox);
                    if (cb.isChecked()) {

                        TextView tv = v.findViewById(R.id.title);
                        tv.getText();
                        result += tv.getText() + ", ";
                    }
                }

                //Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                // try to intent
                Intent a = new Intent(getApplicationContext(), Details.class);
                a.putExtra("data",result);
                startActivity(a);

            }
        });

    }

    private void populateListView() {

        SubCategorylist.add(new SubCategory("Cleaning Service",false));
        SubCategorylist.add(new SubCategory("Sofa Cleaning",false));
        SubCategorylist.add(new SubCategory("Furniture Cleaning",false));

        adapter = new SubCategoryAdapter(this, R.layout.custom_layout, SubCategorylist);
        list = findViewById(R.id.list_view);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CheckBox cb = view.findViewById(R.id.checkbox);
                cb.setChecked(!cb.isChecked());
            }
        });

    }
}
