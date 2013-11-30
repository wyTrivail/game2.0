package com.game.base;

import com.game.load.IUser;

public class Session implements ISession {
	
	private IUser user;

	public IUser getCurrentUser() {
		return user;
	}

	public void setCurrentUser(IUser user) {
		this.user = user;
	}

}
