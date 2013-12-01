package com.game.playmodel.client;

import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.server.IFightAction;

public interface IPVPModel extends IPlayModel {
	
	/**
	 * 匹配完毕，更新用户，战斗开始
	 * @param users
	 */
	void updateUsers(List<List<IUser>> users);
	
	/**
	 * 发生战斗操作
	 * @param actions
	 */
	void updateActions(List<IFightAction> actions);
	
	/**
	 * 更新模式状态，matching， fighting， over
	 * @param status
	 * @return
	 */
	void updateStatus(String status);
	
	/**
	 * 战斗状态
	 * @return
	 */
	String getStatus();

}
