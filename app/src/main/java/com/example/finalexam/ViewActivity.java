package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewActivity extends AppCompatActivity {
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        db = FirebaseFirestore.getInstance();

        db.collection("Movies").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<String> data = new ArrayList<>();
                for (QueryDocumentSnapshot my_movies: task.getResult()) {
                    data.add(my_movies.getString("Title"));
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(ViewActivity.this,
                        R.layout.support_simple_spinner_dropdown_item, data);
                ListView listView = findViewById(R.id.view);
                listView.setAdapter(adapter);
            }
        });



//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                List<String> data = new ArrayList<>();
//                for (QueryDocumentSnapshot my_movies: queryDocumentSnapshots) {
//                    data.add(my_movies.getString("Title"));
//                }
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(ViewActivity.this,
//                        R.layout.activity_view, data);
//                ListView listView = findViewById(R.id.view);
//                listView.setAdapter(adapter);
//            }
//        });
    }
}
