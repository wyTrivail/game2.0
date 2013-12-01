package com.game.base.impl;

import com.game.base.IModel;
import com.game.base.IShape;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class BaseModel implements IModel {
    private String modelName = "model1";

    public IShape getShape() {
        return shape;
    }

    public void setShape(IShape shape) {
        this.shape = shape;
    }

    private IShape shape = new Cylinder();
    private String color = "blue";

    @Override
    public void load() {
        System.out.println("load model:"+ this.modelName);
    }

    @Override
    public void draw() {
        System.out.println("draw model:" + this.modelName);
    }

}
