package kenson.example.com.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Attempts to launch an activity within our own app
        final Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), secondActivity.class);
                startIntent.putExtra("kenson.example.com.quicklauncher.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });
        //Attempt to launch activity outside our app
        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google =  "http://www.yahoo.com";
                Uri webadress = Uri.parse(google);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webadress);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoGoogle);
                }
        }

        });
    }
}
