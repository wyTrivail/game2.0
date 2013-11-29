package com.game.playmodel;

import com.game.base.IShow;
import com.game.load.IUser;

/**
 * 战斗的结果，可以是一招的结果，也可以是一场战斗的结果
 * 但主体只有一个
 * @author XR
 *
 */
public interface IFightResult {

	/**
	 * 结果的主体
	 * @return
	 */
	IUser getUser();
	
	/**
	 * 返回结果类型，如掉血、减防等等
	 * @return
	 */
	String getType();
	
	/**
	 * 战斗结果的文字信息
	 * @return
	 */
	String getStrResult();
	
	/**
	 * 结果动画
	 * @return
	 */
	void setShow(IShow show);
	
	/**
	 * 展示动画
	 */
	void show();
	
	/**
	 * 获取操作
	 * @return
	 */
	IFightAction getAction();
	
	/**
	 * 设置操作
	 * @param action
	 * @return
	 */
	void setAction(IFightAction action);
	
	/**
	 * 设置伤害计算策略
	 * @param harmStratege
	 */
	void setHarmStratege(IHarmStratege harmStratege);

}
