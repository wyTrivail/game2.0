package com.game.playmodel.pvp.server;

import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.FlightActionFactory;
import com.game.playmodel.IFightAction;

public class NormalPVPFightProcessForXVX extends AbstractPVPFightProcessForXVX {

	@Override
	protected IFightAction getOneAction() {
		return FlightActionFactory.getFightAction(actionType, src, des);
	}

	public String getType() {
		return "NormalPVPFightProcessForXVX";
	}

}
