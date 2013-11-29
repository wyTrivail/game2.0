package com.game.base.impl;

import com.game.base.IModel;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class BaseModel implements IModel {
    private String modelName;
    private String shape;
    private String color;

    @Override
    public void load() {
        System.out.println("load model:"+ this.modelName);
    }

    @Override
    public void draw() {
        System.out.println("draw model:" + this.modelName);
    }

}
