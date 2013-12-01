package com.game.playmodel.server;

import com.game.playmodel.client.IPVPModel;

/**
 * PVP模式下的用户
 * @author XR
 *
 */
public interface IPVPUser {

	/**
	 * 用户战力
	 * @return
	 */
	public double getScore();
	
	public void setScore(double score);
	
	/**
	 * 用户PVPModel实例
	 * @return
	 */
	IPVPModel getModel();

	void setModel(IPVPModel model);
}
