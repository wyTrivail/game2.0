package com.game.load;

import com.game.base.IUnit;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:08
 * To change this template use File | Settings | File Templates.
 */
public interface IUser {
        String getUserName();
        void setGender(Integer gender);
        void setProfession(String profession);
        void setCountry(ICountry country);
    void setUserName(String userName);
    void setUnit(IUnit unit);
    IUnit getUnit();
}
