package com.game.playmodel.server.pvp;

import com.game.base.impl.FightUnit;
import com.game.load.IUser;

public class EasyUserScoreStrateger implements IUserScoreStrateger {

	public float getScore(IUser user) {
		FightUnit fu = (FightUnit) user.getUnit();
		return fu.getPower() + fu.getIntelligence() + fu.getLife()/5;
	}

}
