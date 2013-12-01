package com.game.playmodel.server;

import com.game.load.IUser;
import com.game.playmodel.client.IPVPModel;

/**
 * 游戏模式控制器
 * @author XR
 *
 */
public interface IPVPController {
	
	/**
	 * 将用户添加进该模式中
	 * @param user
	 * @param model
	 */
	void addUser(IUser user, IPVPModel model);
	
	/**
	 * 战力分析算法
	 * @param userScoreStrateger
	 */
	void setUserScoreStrateger(IUserScoreStratege userScoreStrateger);
	IUserScoreStratege getUserScoreStrateger();
	
	/**
	 * 用户普配算法
	 * @param pVPMatchStrateger
	 */
	void setPVPMatchStrateger(IPVPMatchStratege pVPMatchStrateger);

	/**
	 * 战斗流程引擎
	 * @param process
	 */
	void setProcess(IFightProcess process);

}
