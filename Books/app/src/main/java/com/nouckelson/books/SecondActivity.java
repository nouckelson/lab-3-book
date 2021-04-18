package com.nouckelson.books;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText author_id,name_id,icon_id;
    Button add_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Add book");

        author_id=findViewById(R.id.author_id);
        name_id=findViewById(R.id.name_id);
        icon_id=findViewById(R.id.icon_id);
        add_book=findViewById(R.id.add_book);
        add_book.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_book:
                this.addBook();
                break;
        }
    }

    private void addBook(){
        Model book=new Model();
        book.setAuthor(author_id.getText().toString());
        book.setName(name_id.getText().toString());
        if(icon_id.getText().toString().equals("mask")){
            book.setLogo(R.drawable.mask);
        }
        if(icon_id.getText().toString().equals("head")){
            book.setLogo(R.drawable.head);
        }
        if(icon_id.getText().toString().equals("love")){
            book.setLogo(R.drawable.love);
        }

        Intent intent=getIntent();
        ArrayList<Model> holder=(ArrayList<Model>)intent.getSerializableExtra("LIST");
        holder.add(book);
        Bundle bundle = new Bundle();
        bundle.putSerializable("LIST",(Serializable)holder);
        Intent inten=new Intent(this,MainActivity.class);
        inten.putExtras(bundle);
        inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(inten);
    }
}

































