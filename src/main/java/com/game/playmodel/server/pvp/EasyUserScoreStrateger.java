package com.game.playmodel.server.pvp;

import com.game.load.IUser;

public class EasyUserScoreStrateger implements IUserScoreStrateger {

	public double getScore(IUser user) {
		return 100;
	}

}
