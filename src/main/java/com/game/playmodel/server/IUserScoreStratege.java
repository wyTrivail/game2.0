package com.game.playmodel.server;

import com.game.load.IUser;

/**
 * 计算user战斗力的策略
 * @author XR
 *
 */
public interface IUserScoreStratege {
	
	public float getScore(IUser user);

}
