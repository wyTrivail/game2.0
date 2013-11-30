package com.game.playmodel.client;

import com.game.load.ICountry;
import com.game.load.IUser;
import com.game.load.UserFactory;
import com.game.load.impl.UserMaster;
import com.game.load.impl.WeiCountryFactory;
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
		
		//初始化化controller用户
		for(int i = 0; i < 9; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
	        controller.addUser(user, model);
		}
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
