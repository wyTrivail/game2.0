package com.game.playmodel.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.game.load.IUser;
import com.game.load.UserFactory;
import com.game.load.impl.WeiCountryFactory;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.server.PlayControllerFactory;

/**
 * 维护PlayModel的类
 * @author XR
 *
 */
public class PlayModelFactory {

	private static Map<String, IPlayModel> playModelMap = 
			new HashMap<String, IPlayModel>();
	
	public static void addPlayModel(String name, IPlayModel model){
		if(playModelMap.containsKey(name)){
			return;
		}
		playModelMap.put(name, model);
	}
	

	public static void removePlayModel(String name){
		if(playModelMap.containsKey(name)){
			playModelMap.remove(name);
		}
	}
	
	public static IPlayModel getPlayModel(String name){
		if(playModelMap.containsKey(name)){
			return playModelMap.get(name);
		}
		return null;
	}
	
	public static Set<String> getPlayModelNames(){
		return playModelMap.keySet();
	}
	
	static{
		PlayModelFactory.addPlayModel("pve", new PVEModel());
		
		PVPModel model1 = new PVPModel();
		model1.setController(PlayControllerFactory.getPlayController("pvp5v5"));
		PlayModelFactory.addPlayModel("pvp5v5", model1);

		PVPModel model2 = new PVPModel();
		model2.setController(PlayControllerFactory.getPlayController("pvp10v10"));
		PlayModelFactory.addPlayModel("pvp10v10", model2);
		
		PVPModel model3 = new PVPModel();
		model3.setController(PlayControllerFactory.getPlayController("pvp5v5v5"));
		PlayModelFactory.addPlayModel("pvp5v5v5", model3);

		//初始化化5v5用户
		for(int i = 0; i < 9; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp5v5").addUser(user, model1);
		}
		
		//初始化化10v10用户
		for(int i = 0; i < 19; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp10v10").addUser(user, model2);
		}
		
		//初始化化5v5v5用户
		for(int i = 0; i < 14; i++){
			IUser user = UserFactory.creator("用户" + i, "1", "1", new WeiCountryFactory().createCountry("wei"));
			PlayControllerFactory.getPlayController("pvp5v5v5").addUser(user, model3);
		}
	}
	
}
