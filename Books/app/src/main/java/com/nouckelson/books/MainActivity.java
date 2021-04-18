package com.nouckelson.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    myAdapter adapter;
    ArrayList<Model> holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
           holder=new ArrayList<>();
        if(intent.getSerializableExtra("LIST")==null){
            holder=this.dataqueue();
        }else{
            holder=(ArrayList<Model>)intent.getSerializableExtra("LIST");
        }
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Liste books");
        rcv=(RecyclerView) findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));


        adapter=new myAdapter(holder,getApplicationContext());
        rcv.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcv.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("LIST",(Serializable) holder);
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public ArrayList<Model> dataqueue() {
        ArrayList<Model> holder = new ArrayList<>();

        //book1
        Model book1 = new Model();
        book1.setName("First ");
        book1.setAuthor("Author");
        book1.setLogo(R.drawable.head);
        holder.add(book1);
        //
        // book2
        Model book2 = new Model();
        book2.setName("second-2 ");
        book2.setAuthor("Author-2");
        book2.setLogo(R.drawable.love);
        holder.add(book2);
        //
        return  holder;
    }
}



























