package com.example.hobbies;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;

import java.util.List;

public class Hobbies extends AppCompatActivity {
    RecyclerView recyclerView;
    HobbyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerViewHobbies);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<Hobby> hobbies = db.hobbyDao().getAllHobbies();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HobbyAdapter(hobbies);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(
                new HobbyAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Hobby hobby) {
                        Intent intent = new Intent(Hobbies.this, ViewHobby.class);
                        intent.putExtra("HOBBY_ID", hobby.getHobby_id());
                        startActivity(intent);
                    }
                }
        );
    }
}
