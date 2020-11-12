package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvPeople;
    ArrayList<People> arrayPeople;
    PeopleAdapter adapter;
    String ten;
    String sdt;
    int hinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        AnhXa();
        adapter = new PeopleAdapter(this,R.layout.line_info,arrayPeople);
        lvPeople.setAdapter(adapter);
        registerForContextMenu(lvPeople);
        lvPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                People pp = (People) arrayPeople.get(i);
                //Toast.makeText(MainActivity.this, pp.getSdt(), Toast.LENGTH_SHORT).show();*/
                Intent myIntent=new Intent(MainActivity.this, ChildActivity.class);
                myIntent.putExtra("Ten",pp.getTen());
                myIntent.putExtra("Sdt",pp.getSdt());
                myIntent.putExtra("Hinh",pp.getHinh());
                startActivity(myIntent);
            }
        });
    }

    private void AnhXa(){
        lvPeople =(ListView) findViewById(R.id.lv);

        arrayPeople = new ArrayList<>();
        arrayPeople.add(new People("Trương Công Lỉnh","0382043755",R.drawable.bi));
        arrayPeople.add(new People("Kim Jenie","09762611354",R.drawable.jennie));
        arrayPeople.add(new People("Trương Công Lỉnh","0382043755",R.drawable.bi));
        arrayPeople.add(new People("Kim Jenie","09762611354",R.drawable.jennie));
        arrayPeople.add(new People("Trương Công Lỉnh","0382043755",R.drawable.bi));
        arrayPeople.add(new People("Kim Jenie","09762611354",R.drawable.jennie));
        arrayPeople.add(new People("Trương Công Lỉnh","0382043755",R.drawable.bi));
        arrayPeople.add(new People("Kim Jenie","09762611354",R.drawable.jennie));
        arrayPeople.add(new People("Trương Công Lỉnh","0382043755",R.drawable.bi));
        arrayPeople.add(new People("Kim Jenie","09762611354",R.drawable.jennie));


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=info.position;
        int id = item.getItemId();
        People sg=arrayPeople.get(pos);
        switch(id)
        {

            case R.id.ct_xoa:
                showDe(sg);

                break;

        }

        return super.onContextItemSelected(item);
    }
    public void showDe(final People name)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Bạn có muốn xóa không");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayPeople.remove(name);
                adapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


}