package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        getSupportActionBar().hide();

        Intent myItent =  getIntent();
        ImageView imageView = findViewById(R.id.hinh);
        TextView textView1 = findViewById(R.id.txTen);
        TextView textView2 = findViewById(R.id.txSdt);
        textView1.setText(myItent.getStringExtra("Ten"));
        textView2.setText(myItent.getStringExtra("Sdt"));
        imageView.setImageResource(myItent.getIntExtra("Hinh",1));

    }

}
