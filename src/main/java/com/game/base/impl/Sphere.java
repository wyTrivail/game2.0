package com.game.base.impl;

import com.game.base.IShape;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:47
 * To change this template use File | Settings | File Templates.
 */
public class Sphere implements IShape {
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    private float radius;
    @Override
    public void draw() {
        System.out.println("draw Sphere");
    }
}
