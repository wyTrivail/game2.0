package com.game.base.impl;

import com.game.base.IShape;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:43
 * To change this template use File | Settings | File Templates.
 */
public class Rectangle implements IShape {
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    private  float x,y,z;
    @Override
    public void draw() {
        System.out.println("draw Rectangle");
    }
}
