package com.game.playmodel.client;

import com.game.load.IUser;
import com.game.load.UserFactory;
import com.game.load.impl.WeiCountryFactory;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.server.pvp.EasyPVP10V10MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyUserScoreStrateger;
import com.game.playmodel.server.pvp.NormalFightProcessForXVXVX;
import com.game.playmodel.server.pvp.NormalPVPFightProcessForXVX;
import com.game.playmodel.server.pvp.PVPController;

public class PlayModelControllerFactory {
	
	private static PlayModelController c = new PlayModelController();
	
	static{
		
		
		c.addPlayModel("pve", new PVEModel());
		PVPModel model1 = new PVPModel();
		PVPController controller1 = new PVPController();
		controller1.setPVPMatchStrateger(new EasyPVP5V5MatchStrateger());
		controller1.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller1.setProcess(new NormalPVPFightProcessForXVX());
		model1.setController(controller1);
		c.addPlayModel("pvp5v5", model1);

		PVPModel model2 = new PVPModel();
		PVPController controller2 = new PVPController();
		controller2.setPVPMatchStrateger(new EasyPVP10V10MatchStrateger());
		controller2.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller2.setProcess(new NormalPVPFightProcessForXVX());
		model2.setController(controller2);
		c.addPlayModel("pvp10v10", model2);
		
		PVPModel model3 = new PVPModel();
		PVPController controller3 = new PVPController();
		controller3.setPVPMatchStrateger(new EasyPVP5V5V5MatchStrateger());
		controller3.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller3.setProcess(new NormalFightProcessForXVXVX());
		model3.setController(controller3);
		c.addPlayModel("pvp5v5v5", model3);

		//初始化化5v5用户
		for(int i = 0; i < 9; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			controller1.addUser(user, model1);
		}
		
		//初始化化10v10用户
		for(int i = 0; i < 19; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			controller2.addUser(user, model2);
		}
		
		//初始化化5v5v5用户
		for(int i = 0; i < 14; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			controller3.addUser(user, model3);
		}
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
