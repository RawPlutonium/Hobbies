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

public class EditHobby extends AppCompatActivity {
    int hobby_id = getIntent().getIntExtra("HOBBY_ID",0);
    EditText editHobbyName, editHobbyHours;
    Button editHobby, deleteHobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hobby);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editHobbyName = findViewById(R.id.edit_hobby_name);
        editHobbyHours = findViewById(R.id.edit_hobby_hours);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        final Hobby hobby = db.hobbyDao().getHobby(hobby_id);
        editHobby.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.hobbyDao().updateHobby(editHobbyName.getText().toString(),Integer.parseInt(editHobbyHours.getText().toString()), hobby_id);
                        startActivity(new Intent(EditHobby.this, Hobbies.class));
                    }
                }
        );
    }

}
