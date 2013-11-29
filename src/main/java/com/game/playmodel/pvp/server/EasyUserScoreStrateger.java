package com.game.playmodel.pvp.server;

import com.game.load.IUser;

public class EasyUserScoreStrateger implements IUserScoreStrateger {

	public double getScore(IUser user) {
		return 100;
	}

}
