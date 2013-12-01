package com.game.playmodel.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.game.playmodel.server.pvp.EasyPVP10V10MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyPVP5V5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyUserScoreStrateger;
import com.game.playmodel.server.pvp.NormalFightProcessForXVXVX;
import com.game.playmodel.server.pvp.NormalPVPFightProcessForXVX;
import com.game.playmodel.server.pvp.PVPController;

/**
 * 维护模式控制器的类
 * @author XR
 *
 */
public class PlayControllerFactory {
	
	private static Map<String, IPVPController> playModelMap = 
			new HashMap<String, IPVPController>();
	
	public static void addPlayController(String name, IPVPController model){
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
	
	public static IPVPController getPlayController(String name){
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
		IPVPMatchStratege strategy = EasyPVP5V5MatchStrateger.getEasyPVP5V5MatchStrateger();
		controller1.setPVPMatchStrateger(strategy);
		controller1.setUserScoreStrateger(new EasyUserScoreStrateger());
		//更改战斗出手顺序，改变一下战斗结果
		NormalPVPFightProcessForXVX process = new NormalPVPFightProcessForXVX();
		process.setTurn(1);
		controller1.setProcess(process);
		playModelMap.put("pvp5v5", controller1);
		

		PVPController controller2 = new PVPController();
		strategy = EasyPVP10V10MatchStrateger.getEasyPVP10V10MatchStrateger();
		controller2.setPVPMatchStrateger(strategy);
		controller2.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller2.setProcess(new NormalPVPFightProcessForXVX());
		playModelMap.put("pvp10v10", controller2);
		

		PVPController controller3 = new PVPController();
		strategy = EasyPVP5V5V5MatchStrateger.getEasyPVP5V5V5MatchStrateger();
		controller3.setPVPMatchStrateger(strategy);
		controller3.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller3.setProcess(new NormalFightProcessForXVXVX());
		playModelMap.put("pvp5v5v5", controller3);
		
	}

}
