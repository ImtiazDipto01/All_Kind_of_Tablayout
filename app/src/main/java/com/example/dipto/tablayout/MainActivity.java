package com.example.dipto.tablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button Texttab_btn, texticon_tab, bottom_tab ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Texttab_btn = (Button) findViewById(R.id.texttab) ;
        texticon_tab = (Button) findViewById(R.id.icon_text_tab) ;
        bottom_tab = (Button) findViewById(R.id.bottom_scroll_tab) ;

        Texttab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TablayoutAcitvity.class);
                startActivity(intent);
            }
        });

        texticon_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextandIconTablyout.class);
                startActivity(intent);
            }
        });

        bottom_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BottomScrollTablayout.class);
                startActivity(intent);
            }
        });
    }
}
