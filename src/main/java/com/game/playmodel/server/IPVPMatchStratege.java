package com.game.playmodel.server;

import java.util.List;

import com.game.load.IUser;

/**
 * PVP匹配算法
 * @author XR
 *
 */
public interface IPVPMatchStratege {
	
	List<List<List<IUser>>> match(List<PVPUserAdapter> unmatchUsers, IGroupScoreStratege stratege);

}
