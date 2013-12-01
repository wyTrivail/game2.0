package com.game.playmodel.server;

import com.game.load.IUser;
import com.game.playmodel.client.IPlayModel;
import com.game.playmodel.server.pvp.IPVPMatchStrateger;

/**
 * 游戏模式控制器
 * @author XR
 *
 */
public interface IPlayController {
	
	void addUser(IUser user, IPlayModel model);
	
	void setPVPMatchStrateger(IPVPMatchStrateger pVPMatchStrateger);

	void setProcess(IFightProcess process);

}
