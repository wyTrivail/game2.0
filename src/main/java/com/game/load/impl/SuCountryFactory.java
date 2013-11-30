package com.game.load.impl;

import com.game.base.IUnit;
import com.game.base.impl.FightUnit;
import com.game.load.ICountry;
import com.game.load.ICountryFactory;
import com.game.load.IUser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */
public class SuCountryFactory implements ICountryFactory{
    static IUser user = new User();
    static {
        user.setUserName("刘备");
        IUnit unit = new FightUnit();
        user.setUnit(unit);
    }
    @Override
    public ICountry createCountry(String name) {
         ICountry country = new Country();
         country.setBuildingStyle(new BuildingStyle());
         List<IUser>  users = new LinkedList<IUser>();
         users.add(user);
         country.setNPCs(users);
        country.setName("蜀国");
         return country;
    }
}
