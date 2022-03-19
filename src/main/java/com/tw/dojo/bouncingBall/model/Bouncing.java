package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class Bouncing implements Behaviour {

    private int direction;
    protected int y;
    protected int radius;
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;
    public Bouncing(int direction) {
        this.direction = direction;
    }

    @Override
    public void update(Ball ball) {
        this.y = ball.y;
        direction = reverseDirectionIfNecessary();
        ball.y = move();
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? Bouncing.UP : Bouncing.DOWN;
    }

    private int move() {
        return y + (Bouncing.MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == Bouncing.DOWN;
    }

    private boolean movingUp() {
        return direction == Bouncing.UP;
    }

}
