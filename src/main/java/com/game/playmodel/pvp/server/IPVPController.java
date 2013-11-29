package com.game.playmodel.pvp.server;

import com.game.load.IUser;
import com.game.playmodel.pvp.client.PVPModel;

public interface IPVPController {
	
	void addUser(IUser user, PVPModel model);

}
