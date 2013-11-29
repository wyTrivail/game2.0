package com.game.base.impl;

import com.game.base.IShape;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class Cylinder implements IShape {
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    private float radius;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    private float height;
    @Override
    public void draw() {
         System.out.println("draw Cylinder");
    }
}
