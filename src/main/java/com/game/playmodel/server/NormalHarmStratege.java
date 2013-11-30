package com.game.playmodel.server;

import com.game.load.IUser;

public class NormalHarmStratege implements IHarmStratege {

	/**
	 * 最基本的实现，没有各种抗性等
	 */
	public float getHarm(float basicHarm, IUser user) {
		return basicHarm;
	}

}
