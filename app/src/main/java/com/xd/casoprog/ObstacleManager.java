package com.xd.casoprog;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

import static com.xd.casoprog.MainThread.canvas;

/**
 * Created by Krow on 27/5/2018.
 */

public class ObstacleManager {
    //higher index = lover on screen = higher y value
    private ArrayList<Obstacle> obstacles;
    private int playerGap;
    private int obstacleGag;
    private int obstacleHeight;
    private int color;

    private long startTime;
    private long initTime;

    private int score = 0;
    private int valor = 0;

    public ObstacleManager(int playerGap, int obstacleGag, int obstacleHeight, int color){
        this.playerGap = playerGap;
        this.obstacleGag = obstacleGag;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();
    }
    public ObstacleManager(){

    }

    public boolean playerCollide(RectPlayer player){
        for(Obstacle ob : obstacles){
            if(ob.playerCollide(player))
                return true;
        }
        return false;
    }

    private void populateObstacles(){
        int currY = -5*Constants.SCREEN_HEIGHT/4;
        while(currY < 0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY, playerGap));
            currY += obstacleHeight + obstacleGag;

        }

    }

    public void update(){
        if (startTime < Constants.INIT_TIME)
            startTime=Constants.INIT_TIME;
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/2000.0))*Constants.SCREEN_HEIGHT/(10000.0f);
        for(Obstacle ob : obstacles){
            ob.incrementY(speed * elapsedTime);
        }
        if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGag, playerGap));
            obstacles.remove(obstacles.size() -1);
            score++;
        }
    }

    public void draw(Canvas canvas) {
        for (Obstacle ob : obstacles)
            ob.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        canvas.drawText("" + score, 100, 100, paint);

    }

    public String devolverPuntu(){
        int puntu = 0;

        puntu += score;

        return  ("" + puntu);
    }



}

