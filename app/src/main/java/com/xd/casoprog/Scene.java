package com.xd.casoprog;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by Krow on 28/5/2018.
 */

public interface Scene {
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void receiveTouch(MotionEvent event);
}
