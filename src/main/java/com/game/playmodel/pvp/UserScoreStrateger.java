package com.game.playmodel.pvp;

import com.game.load.IUser;

/**
 * 计算user战斗力的策略
 * @author XR
 *
 */
public interface UserScoreStrateger {
	
	public double getScore(IUser user);

}
