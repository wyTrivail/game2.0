package com.game.playmodel.server.pvp;

import com.game.playmodel.server.FlightActionFactory;
import com.game.playmodel.server.IFightAction;

public class NormalPVPFightProcessForXVX extends AbstractPVPFightProcessForXVX {
	
	int turn = 0;

	@Override
	protected IFightAction getOneAction() {
		if(turn == 0){
			turn = 1;
			return FlightActionFactory.getFightAction(actionType, src, des);
		} else{
			turn = 0;
			return FlightActionFactory.getFightAction(actionType, des, src);
		}
	}

	public String getType() {
		return "NormalPVPFightProcessForXVX";
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

}
