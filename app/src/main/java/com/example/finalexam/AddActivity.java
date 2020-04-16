package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = FirebaseFirestore.getInstance();
    }

    public void onClickAdd(View view) {
        EditText title_text = findViewById(R.id.Title);
        String title = title_text.getText().toString();

        EditText description_text = findViewById(R.id.Description);
        String description = description_text.getText().toString();

        EditText link_text = findViewById(R.id.Link);
        String link = link_text.getText().toString();

        Map<String, String> data = new HashMap<>();
        data.put("Title", title);
        data.put("Description", description);
        data.put("Link", link);

        db.collection("Movies").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public void onClickMainMenu(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        finish();
        startActivity(intent);
    }
}
