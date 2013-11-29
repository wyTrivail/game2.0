package com.game.playmodel;

import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.pvp.PVP5v5Model;

public class PlayModelControllerFactory {
	
	private static PlayModelController c = new PlayModelController();
	
	static{
		c.addPlayModel("pve", new PVEModel());
		c.addPlayModel("pvp", new PVP5v5Model());
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
