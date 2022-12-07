package org.techtown.androidwithjava;

import static org.techtown.androidwithjava.R.id.editText1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServieAndBrodcastReceiver extends AppCompatActivity {
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servie_and_brodcast_receiver);

       editText = findViewById(editText1);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                Intent intent  =new Intent(getApplicationContext() , MyService.class);
                intent.putExtra("command" , "show");
                intent.putExtra("name" , name);

                startService(intent);
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);

}

    private void processIntent(Intent intent) {
    if (intent != null){
        String command = intent.getStringExtra("command");
        String name  = intent.getStringExtra("name");

        Toast.makeText(this, "command : " + command + ", name : " + name,
                Toast.LENGTH_LONG).show();
    }
    }
}