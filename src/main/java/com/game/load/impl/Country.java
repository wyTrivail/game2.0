package com.game.load.impl;

import com.game.load.IBuildingStyle;
import com.game.load.ICountry;
import com.game.load.IUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
public class Country implements ICountry{
    private IBuildingStyle buildingStyle;
    private List<IUser> user;
    private String name;

    @Override
    public void setNPCs(List npcs) {
        this.user = npcs;
    }

    @Override
    public void setBuildingStyle(IBuildingStyle buildingStyle) {
         this.buildingStyle = buildingStyle;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<IUser> getNPCS() {
        return this.user;
    }
}
