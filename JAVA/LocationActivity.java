package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {
    String [] occupants = {"Kajiado", "Isinya","Kisaju","Kitengela","Bisil","Namanga"};

    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    Button CurrentLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        autoCompleteTxt = findViewById(R.id.autoCompleteTextView);

        CurrentLocation = findViewById(R.id.current_location);
        CurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlacesActivity.class);
                startActivity(intent);
            }
        });

        adapterItems = new ArrayAdapter<String>(this, R.layout.occupants_list,occupants);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String occupant = adapterView.getItemAtPosition(i).toString();
                if (occupant == "Kajiado"){
                    Intent intent = new Intent(getApplicationContext(), Kajiado.class);
                    startActivity(intent);
                    finish();
                }else if (occupant == "Isinya"){
                    Intent intent = new Intent(getApplicationContext(), Isinya.class);
                    startActivity(intent);
                    finish();
                } else if (occupant == "Kitengela") {
                    Intent intent = new Intent(getApplicationContext(), KitengelaMap.class);
                    startActivity(intent);
                    finish();
                }else if (occupant == "Bisil"){
                    Intent intent = new Intent(getApplicationContext(), Bisil.class);
                    startActivity(intent);
                    finish();
                } else if (occupant == "Kisaju") {
                    Intent intent = new Intent(getApplicationContext(), Kisaju.class);
                    startActivity(intent);
                    finish();
                } else if (occupant == "Namanga") {
                    Intent intent = new Intent(getApplicationContext(), Namanga.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(getApplicationContext(), "Enter Occupation", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}