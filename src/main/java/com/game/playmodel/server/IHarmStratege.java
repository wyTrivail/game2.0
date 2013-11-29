package com.game.playmodel.server;

import com.game.load.IUser;

public interface IHarmStratege {
	
	int getHarm(int basicHarm, IUser user);

}
