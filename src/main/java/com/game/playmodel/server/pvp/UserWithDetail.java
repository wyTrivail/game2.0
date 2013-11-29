package com.game.playmodel.server.pvp;

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

}
