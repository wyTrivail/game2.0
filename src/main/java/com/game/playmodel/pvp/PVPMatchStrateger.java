package com.game.playmodel.pvp;

import java.util.List;

import com.game.load.IUser;

/**
 * PVP匹配算法
 * @author XR
 *
 */
public interface PVPMatchStrateger {
	
	List<List<List<IUser>>> match(List<UserWithDetail> users);

}
