package com.game.playmodel.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.game.playmodel.server.pvp.EasyPVP10V10MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyUserScoreStrateger;
import com.game.playmodel.server.pvp.IPVPMatchStrateger;
import com.game.playmodel.server.pvp.NormalFightProcessForXVXVX;
import com.game.playmodel.server.pvp.NormalPVPFightProcessForXVX;
import com.game.playmodel.server.pvp.PVPController;

/**
 * 维护模式控制器的类
 * @author XR
 *
 */
public class PlayControllerFactory {
	
	private static Map<String, IPlayController> playModelMap = 
			new HashMap<String, IPlayController>();
	
	public static void addPlayController(String name, IPlayController model){
		if(playModelMap.containsKey(name)){
			return;
		}
		playModelMap.put(name, model);
	}
	

	public static void removePlayController(String name){
		if(playModelMap.containsKey(name)){
			playModelMap.remove(name);
		}
	}
	
	public static IPlayController getPlayController(String name){
		if(playModelMap.containsKey(name)){
			return playModelMap.get(name);
		}
		return null;
	}
	
	public static Set<String> getPlayControllerNames(){
		return PlayControllerFactory.playModelMap.keySet();
	}
	
	static{
		PVPController controller1 = new PVPController();
		IPVPMatchStrateger strategy = new EasyPVP5V5MatchStrateger();
		controller1.setPVPMatchStrateger(strategy);
		strategy.setUserScoreStrateger(new EasyUserScoreStrateger());
		NormalPVPFightProcessForXVX process = new NormalPVPFightProcessForXVX();
		process.setTurn(1);
		controller1.setProcess(process);
		playModelMap.put("pvp5v5", controller1);
		

		PVPController controller2 = new PVPController();
		strategy = new EasyPVP10V10MatchStrateger();
		controller2.setPVPMatchStrateger(strategy);
		strategy.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller2.setProcess(new NormalPVPFightProcessForXVX());
		playModelMap.put("pvp10v10", controller2);
		

		PVPController controller3 = new PVPController();
		strategy = new EasyPVP5V5V5MatchStrateger();
		controller3.setPVPMatchStrateger(strategy);
		strategy.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller3.setProcess(new NormalFightProcessForXVXVX());
		playModelMap.put("pvp5v5v5", controller3);
	}

}
