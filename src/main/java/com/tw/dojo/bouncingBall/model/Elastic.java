package com.tw.dojo.bouncingBall.model;

public class Elastic implements Behaviour {
    public static final int GROWTH_RATE = 2;

    public static final int GROW = 1;
    public static final int SHRINK = -1;
    private int growthDirection;
    protected int radius;

    public Elastic(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    @Override
    public void update(Ball ball) {
        this.radius = ball.radius;
        growthDirection = reverseGrowthDirectionIfNecessary();
        ball.radius = next();
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? Elastic.SHRINK : Elastic.GROW;
    }

    private int next() {
        return radius + (Elastic.GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == Elastic.SHRINK;
    }

    private boolean growing() {
        return growthDirection == Elastic.GROW;
    }

}
