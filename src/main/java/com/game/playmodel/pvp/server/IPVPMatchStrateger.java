package com.game.playmodel.pvp.server;

import java.util.List;

import com.game.load.IUser;

/**
 * PVP匹配算法
 * @author XR
 *
 */
public interface IPVPMatchStrateger {
	
	List<List<List<IUser>>> match(List<UserWithDetail> unmatchUsers);

}
