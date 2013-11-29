package com.game.playmodel.server.pvp;

import com.game.load.IUser;
import com.game.playmodel.client.pvp.PVPModel;

public interface IPVPController {
	
	void addUser(IUser user, PVPModel model);

}
