package com.game.playmodel.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayModelController {

	private Map<String, IPlayModel> playModelMap = 
			new HashMap<String, IPlayModel>();
	
	public void addPlayModel(String name, IPlayModel model){
		if(playModelMap.containsKey(name)){
			return;
		}
		playModelMap.put(name, model);
	}
	

	public void removePlayModel(String name){
		if(playModelMap.containsKey(name)){
			playModelMap.remove(name);
		}
	}
	
	public IPlayModel getPlayModel(String name){
		if(playModelMap.containsKey(name)){
			return playModelMap.get(name);
		}
		return null;
	}
	
	public Set<String> getPlayModelNames(){
		return this.playModelMap.keySet();
	}
	
}
