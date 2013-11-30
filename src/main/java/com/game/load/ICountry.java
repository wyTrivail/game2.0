package com.game.load;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public interface ICountry {
    void setNPCs(List npcs);
    void setBuildingStyle(IBuildingStyle buildingStyle);
    void setName(String name);
    String getName();
    List<IUser> getNPCS();
}
