package com.game.playmodel.server;

import java.util.List;

import com.game.load.IUser;

/**
 * 根据对战双方获取战斗过程的接口
 * @author XR
 *
 */
public interface IFightProcess {
	
	void setUsers(List<List<IUser>> groups);
	
	List<IFightAction> getFightProcess();
	
	String getType();

}
