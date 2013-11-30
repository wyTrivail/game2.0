package com.game.load.impl;

import com.game.load.IBuildingStyle;
import com.game.load.ICountry;
import com.game.load.ICountryFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
public class WuCountryFactory implements ICountryFactory {
    @Override
    public ICountry createCountry(String name) {
        ICountry country = new Country();
        IBuildingStyle buildingStyle = new BuildingStyle();
        buildingStyle.setColor("黄");
        country.setBuildingStyle(new BuildingStyle());
        List<User> users = new LinkedList<User>();
        User user = new User();
        user.setUserName("孙权");
        users.add(user);
        country.setNPCs(users);
        country.setName("吴国");
        return country;
    }
}
