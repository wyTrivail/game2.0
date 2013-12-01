package com.game.playmodel.server.pvp;

import java.util.List;

import com.game.load.IUser;

/**
 * PVP匹配算法
 * @author XR
 *
 */
public interface IPVPMatchStrateger {
	
	/**
	 * 用户战力算法
	 * @param userScoreStrateger
	 */
	void setUserScoreStrateger(IUserScoreStrateger userScoreStrateger);
	
	IUserScoreStrateger getUserScoreStrateger();
	
	List<List<List<IUser>>> match(List<PVPUserAdapter> unmatchUsers);

}
