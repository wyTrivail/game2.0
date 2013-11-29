package com.game.playmodel;

import java.util.List;

import com.game.base.IShow;
import com.game.load.IUser;

/**
 * 战斗中执行了什么操作
 * @author XR
 *
 */
public interface IFightAction {
	
	/**
	 * 操作主体
	 * @return
	 */
	List<IUser> getSrc();
	
	/**
	 * 操作类型
	 * @return
	 */
	String getActionType();
	
	/**
	 * 基础伤害
	 * @param user
	 * @return
	 */
	int getBaseHurm();
	
	/**
	 * 结果动画
	 * @return
	 */
	IShow getShow();
}
