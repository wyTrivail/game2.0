package com.game.load.impl;

import com.game.load.IBuildingStyle;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class BuildingStyle  implements IBuildingStyle{
    private String color="red";

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
