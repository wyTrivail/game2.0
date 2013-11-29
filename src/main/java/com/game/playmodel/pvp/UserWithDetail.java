package com.game.playmodel.pvp;

import com.game.load.IUser;
import com.game.playmodel.IPlayModel;

public class UserWithDetail implements Scoreable {
	
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

}
