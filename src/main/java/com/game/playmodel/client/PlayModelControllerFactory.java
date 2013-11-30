package com.game.playmodel.client;

import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.server.pvp.EasyPVP5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyUserScoreStrateger;
import com.game.playmodel.server.pvp.NormalPVPFightProcessForXVX;
import com.game.playmodel.server.pvp.PVPController;

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
		c.addPlayModel("pvp5v5", model);
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
