package com.example.hobbies;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ViewHobby extends AppCompatActivity {
    int hobby_id = getIntent().getIntExtra("HOBBY_ID",0);
    TextView hobbyName, hours;
    Button chart, editHobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hobby);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hobbyName = findViewById(R.id.hobbyName);
        hours = findViewById(R.id.hobbyHours);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        final Hobby hobby = db.hobbyDao().getHobby(hobby_id);
        String hobby_name = hobby.getName();
        int hobby_hours = hobby.getHours();
        hobbyName.setText(hobby_name);
        hours.setText(String.valueOf(hobby_hours));
        chart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ViewHobby.this, Chart.class);
                        intent.putExtra("HOBBY_ID", hobby.getHobby_id());
                        startActivity(intent);
                    }
                }
        );
        editHobby.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ViewHobby.this, EditHobby.class);
                        intent.putExtra("HOBBY_ID", hobby.getHobby_id());
                        startActivity(intent);
                    }
                }
        );
    }

}
