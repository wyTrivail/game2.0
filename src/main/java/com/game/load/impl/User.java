package com.game.load.impl;

import com.game.base.IUnit;
import com.game.load.ICountry;
import com.game.load.IUser;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:09
 * To change this template use File | Settings | File Templates.
 */
public class User implements IUser {
    private IUnit unit;
	private String profession;//职业
    private Integer gender;
    private String userName = "unnameed";
    private ICountry country;
    public IUnit getUnit() {
		return unit;
	}
	public void setUnit(IUnit unit) {
		this.unit = unit;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

    @Override
    public void setCountry(ICountry country) {
        this.country = country;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


    public String getUserName() {
        return this.userName;
    }
}
