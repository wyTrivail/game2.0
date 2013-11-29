package com.game.playmodel;

import com.game.load.IUser;

public class NormalHarmStratege implements IHarmStratege {

	/**
	 * 最基本的实现，没有各种抗性等
	 */
	public int getHarm(int basicHarm, IUser user) {
		return basicHarm;
	}

}
