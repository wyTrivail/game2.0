package com.game.playmodel;

import java.util.List;

import com.game.load.IUser;

/**
 * 某一步战斗，谁对谁干了什么，结果如何
 * 一步只能执行一个操作，但不限主客体数量，如合体大招、群攻技能是允许的
 * @author XR
 *
 */
public interface IFightStep {
	
	/**
	 * 结果的主体
	 * @return
	 */
	List<IUser> getFrom();
	
	/**
	 * 结果的受体
	 * @return
	 */
	List<IUser> getTo();
	
	/**
	 * 战斗操作
	 * @return
	 */
	IFightAction getFightAction();
	
	/**
	 * 战斗结果
	 * @return
	 */
	List<IFightResult> getFightResult();

}
