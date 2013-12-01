package com.game.playmodel.client.pvp;

import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.client.IPVPModel;
import com.game.playmodel.server.IFightAction;

public class NullPVPModel implements IPVPModel {

	@Override
	public void play() {
		System.out.println("空模式，继续游戏吧");

	}

	@Override
	public void updateUsers(List<List<IUser>> users) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateActions(List<IFightAction> actions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStatus(String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
