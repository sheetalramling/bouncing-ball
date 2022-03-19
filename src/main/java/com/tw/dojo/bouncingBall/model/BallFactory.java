package com.tw.dojo.bouncingBall.model;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(500, 100, Bouncing.DOWN, Ball.DEFAULT_RADIUS, Elastic.SHRINK) //--> Let's make a new ball!
        };
    }

    private static Ball bouncingElasticBall(int centerX, int centerY, int direction, int radius, int resize) {
        Behaviour[] behaviours = new Behaviour[]{new Bouncing(direction),
                new Elastic(direction)};
        return new Ball(centerX, centerY, behaviours);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        Behaviour behaviour = new Bouncing(direction);
        return new Ball(centerX, centerY, behaviour);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        Behaviour behaviour = new Elastic(direction);
        return new Ball(centerX, centerY, radius, behaviour);
    }
}
