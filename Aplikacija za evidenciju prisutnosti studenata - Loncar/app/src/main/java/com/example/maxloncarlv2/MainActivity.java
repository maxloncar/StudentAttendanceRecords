package com.example.maxloncarlv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recyclerView;
    private NameAdapter adapter;

    EditText etName;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecylcerData();
        initializeUI();
    }

    private void initializeUI(){
        this.etName = (EditText) findViewById(R.id.etName);
        this.btnAdd = (Button) findViewById(R.id.btnAdd);
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NameAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecylcerData() {
        List<String> data = new ArrayList<>();
        data.add("Ana");
        data.add("Marko");
        data.add("Pero");

        adapter.setNameList(data);
    }

    public void addCell(View view){
        String name = String.valueOf(etName.getText());
        if (name.matches("")){
            Toast.makeText(this, "You didn't enter a name", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.addNewCell(name, adapter.getItemCount());
        }
    }

    public void onCrossClick(int position){
        adapter.removeCell(position);
    }

}
