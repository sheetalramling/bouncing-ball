package com.tw.dojo.bouncingBall.model;

import java.awt.*;

public class Ball {
    protected static final int DEFAULT_RADIUS = 40;
    protected int x;
    protected int y;
    protected int radius;
    private Behaviour[] behaviours;

    public Ball(int x, int y, int radius, Behaviour behaviour) {
        this(x, y, radius);
        this.behaviours = new Behaviour[]{behaviour};
    }

    public Ball(int x, int y, Behaviour behaviour) {
        this(x, y);
        this.behaviours = new Behaviour[]{behaviour};
    }

    public Ball(int x, int y, Behaviour[] behaviours) {
        this(x, y);
        this.behaviours = behaviours;
    }

    protected Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    protected Ball(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    public void update() {
        for (Behaviour behaviour :
                this.behaviours) {
            behaviour.update(this);
        }

    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

}
