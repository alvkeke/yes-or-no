package com.alvkeke.tools.yesorno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements RandomCallback{

    private ImageView view;
    private Boolean canRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.img_show);
        view.setBackgroundResource(R.drawable.ic_yes);

        canRun = true;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(canRun);
                if (canRun) {
                    new Thread(new RandomThread(MainActivity.this)).start();
                }
                canRun = false;
//                System.out.println(canRun);
            }
        });

    }

    @Override
    public void inter(final boolean state) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(state){
                    view.setBackgroundResource(R.drawable.ic_yes);
                }else {
                    view.setBackgroundResource(R.drawable.ic_no);
                }
            }
        });

    }

    @Override
    public void done(final boolean state) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(state){
                    view.setBackgroundResource(R.drawable.ic_yes);
                }else {
                    view.setBackgroundResource(R.drawable.ic_no);
                }
            }
        });
        canRun = true;
    }
}
