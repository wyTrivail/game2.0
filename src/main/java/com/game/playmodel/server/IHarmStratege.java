package com.game.playmodel.server;

import com.game.load.IUser;

public interface IHarmStratege {
	
	float getHarm(float basicHarm, IUser user);

}
