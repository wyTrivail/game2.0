package com.game.base;

import com.game.load.IUser;

public interface ISession {
	
	IUser getCurrentUser();
    void setUser(IUser user);
}
