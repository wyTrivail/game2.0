package com.game.playmodel.server.pvp;

import com.game.playmodel.server.FlightActionFactory;
import com.game.playmodel.server.IFightAction;

public class NormalPVPFightProcessForXVX extends AbstractPVPFightProcessForXVX {

	@Override
	protected IFightAction getOneAction() {
		return FlightActionFactory.getFightAction(actionType, src, des);
	}

	public String getType() {
		return "NormalPVPFightProcessForXVX";
	}

}
