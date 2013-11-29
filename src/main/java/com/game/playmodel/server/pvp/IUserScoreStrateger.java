package com.game.playmodel.server.pvp;

import com.game.load.IUser;

/**
 * 计算user战斗力的策略
 * @author XR
 *
 */
public interface IUserScoreStrateger {
	
	public double getScore(IUser user);

}
