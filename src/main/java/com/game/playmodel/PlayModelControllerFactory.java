package com.game.playmodel;

import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.pvp.client.PVPModel;
import com.game.playmodel.pvp.server.EasyPVP5V5MatchStrateger;
import com.game.playmodel.pvp.server.EasyUserScoreStrateger;
import com.game.playmodel.pvp.server.NormalPVPFightProcessForXVX;
import com.game.playmodel.pvp.server.PVPController;

public class PlayModelControllerFactory {
	
	private static PlayModelController c = new PlayModelController();
	
	static{
		c.addPlayModel("pve", new PVEModel());
		PVPModel model = new PVPModel();
		PVPController controller = new PVPController();
		controller.setPVPMatchStrateger(new EasyPVP5V5MatchStrateger());
		controller.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller.setProcess(new NormalPVPFightProcessForXVX());
		model.setController(controller);
		c.addPlayModel("pvp5v5", new PVPModel());
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
