package com.game.playmodel.server.pvp;

import com.game.base.IUnit;
import com.game.load.ICountry;
import com.game.load.IUser;
import com.game.playmodel.client.IPlayModel;

public class UserWithDetail implements IUser, IScoreable {
	
	private IUser user;
	
	private double score;
	
	private IPlayModel model;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

	public IPlayModel getModel() {
		return model;
	}

	public void setModel(IPlayModel model) {
		this.model = model;
	}

	public String getUserName() {
		return user.getUserName();
	}

    @Override
    public void setGender(Integer gender) {
        user.setGender(gender);
    }

    @Override
    public void setProfession(String profession) {
        user.setProfession(profession);
    }

    @Override
    public void setCountry(ICountry country) {
        user.setCountry(country);
    }

    @Override
    public void setUserName(String userName) {
        user.setUserName(userName);
    }

    @Override
    public void setUnit(IUnit unit) {
        user.setUnit(unit);
    }

    @Override
    public IUnit getUnit() {
        return user.getUnit();
    }

    @Override
    public ICountry getCountry() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProfession() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
