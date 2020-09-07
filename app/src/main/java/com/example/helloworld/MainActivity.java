package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyModelView model;
//    private ListView lvNumbers;
    private ArrayAdapter arrayAdapter;
    private ArrayList<String> arrayList;
//    private TextView tvCounter;
//    private int count;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);


        model = new ViewModelProvider(this).get(MyModelView.class);
//      count = 0;
//        tvCounter= findViewById(R.id.tv_counter);
//        lvNumbers = findViewById(R.id.lv_numbers);

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList
        );
        binding.lvNumbers.setAdapter(arrayAdapter);
        binding.lvNumbers.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            String data = arrayList.get(i);
            intent.putExtra("data", data);
            startActivity(intent);
        });
        binding.lvNumbers.setOnItemLongClickListener((adapterView, view, i, l) -> {

            arrayList.remove(i);
            arrayAdapter.notifyDataSetChanged();

            return false;
        });
        model.getNumber().observe(this, integer -> binding.tvCounter.setText("" + integer));
        model.getArrayList().observe(this,strings -> {
            arrayList.clear();
            arrayList.addAll(strings);
            arrayAdapter.notifyDataSetChanged();
        });
    }

    public void clickOnCounterButton(View v){
//        count++;
////        arrayList.add("" + count);
////        arrayAdapter.notifyDataSetChanged();
        model.increaseNumber();
        model.arrayListNumber();
    }
}