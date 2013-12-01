package com.game.playmodel.client;

import java.util.Set;

import com.game.load.IUser;
import com.game.load.UserFactory;
import com.game.load.impl.WeiCountryFactory;
import com.game.playmodel.client.pvp.NullPVPModel;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.client.pvp.TestPVPModel;
import com.game.playmodel.server.PlayControllerFactory;

/**
 * 维护PlayModel的类
 * @author XR
 *
 */
public class PlayModelFactory {


	private static PVPModel model = new PVPModel();
	private static NullPVPModel nullModel = new NullPVPModel();
	
	public static IPlayModel getPlayModel(String name){
		if(PlayControllerFactory.getPlayController(name) == null){
			return nullModel;
		}
		model.setController(PlayControllerFactory.getPlayController(name));
		return model;
	}
	
	public static Set<String> getPlayModelNames(){
		return PlayControllerFactory.getPlayControllerNames();
	}
	
	static{
		//初始化化5v5用户
		TestPVPModel model1 = new TestPVPModel();
		for(int i = 0; i < 9; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp5v5").addUser(user, model1);
		}
		
		//初始化化10v10用户
		for(int i = 0; i < 19; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp10v10").addUser(user, model1);
		}
		
		//初始化化5v5v5用户
		for(int i = 0; i < 14; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp5v5v5").addUser(user, model1);
		}
	}
	
}
