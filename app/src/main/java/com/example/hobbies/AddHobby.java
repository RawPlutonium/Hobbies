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
import android.widget.EditText;

public class AddHobby extends AppCompatActivity {
    Button addHobby;
    EditText hobbyName, hobbyHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hobby);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addHobby = findViewById(R.id.addHobby);
        hobbyName = findViewById(R.id.hobby_name);
        hobbyHours = findViewById(R.id.hobby_hours);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        addHobby.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.hobbyDao().insertAll(new Hobby(hobbyName.getText().toString(),Integer.parseInt(hobbyHours.getText().toString())));
                        startActivity(new Intent(AddHobby.this, Hobbies.class));
                    }
                }
        );
    }

}
