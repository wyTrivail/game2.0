package com.game.base;

import com.game.load.IUser;

public interface ISession {
	
	IUser getCurrentUser();
	
	void setCurrentUser(IUser user);
}
