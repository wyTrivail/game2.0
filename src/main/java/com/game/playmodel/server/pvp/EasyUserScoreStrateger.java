package com.game.playmodel.server.pvp;

import com.game.base.impl.FightUnit;
import com.game.load.IUser;
import com.game.playmodel.server.IUserScoreStratege;

public class EasyUserScoreStrateger implements IUserScoreStratege {

	public float getScore(IUser user) {
		FightUnit fu = (FightUnit) user.getUnit();
		return fu.getPower() + fu.getIntelligence() + fu.getLife()/5;
	}

}
