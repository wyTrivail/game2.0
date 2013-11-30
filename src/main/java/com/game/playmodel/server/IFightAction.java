package com.game.playmodel.server;

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
	 * 获取操作类型
	 * @return
	 */
	String getType();
	
	/**
	 * 操作主体
	 * @return
	 */
	List<IUser> getSrc();
	
	/**
	 * 操作客体
	 * @return
	 */
	List<IUser> getDes();
	
	/**
	 * 操作类型
	 * @return
	 */
	String getActionType();
	
	/**
	 * 基础伤害类型，如血、防御等
	 * @return
	 */
	String getBaseHurmType();
	
	/**
	 * 基础伤害
	 * @param user
	 * @return
	 */
	float getBaseHurm();

	/**
	 * 动画
	 * @return
	 */
	void setShow(IShow show);
	
	/**
	 * 设置resulttype
	 * @param resultType
	 */
	void setResultType(String resultType);
	
	/**
	 * 获取resulttype
	 * @return
	 */
	String getResultType();
	
	/**
	 * 结果
	 * @return
	 */
	List<IFightResult> getResult();

	/**
	 * 展示动画
	 */
	void show();
	
	/**
	 * 操作的文字描述
	 * @return
	 */
	String strAction();
}
