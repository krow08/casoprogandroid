package com.xd.casoprog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

public class juego_act extends Activity {

    private ObstacleManager obtacleMan = new ObstacleManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        DisplayMetrics dn = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dn);
        Constants.SCREEN_WIDTH = dn.widthPixels;
        Constants.SCREEN_HEIGHT = dn.heightPixels;

        setContentView(new GamePanel(this));
    }
    public void cambiarMenuActivity(String  puntu){
        Intent myIntent = new Intent(this, pop_act.class);
        myIntent.putExtra("score", puntu);
        startActivity(myIntent);
        System.exit(0);
    }
}
