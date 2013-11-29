package com.game.playmodel.pvp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.load.IUser;

public class PVP5v5Controller {
	
	private PVPMatchStrateger pVPMatchStrateger;
	
	private List<UserWithDetail> unmatchUsers = 
			new ArrayList<UserWithDetail>();
	
	public void addUser(IUser user, 
			UserScoreStrateger strateger, PVP5v5Model model){
    	System.out.print("正在匹配中。。。");
    	UserWithDetail us = new UserWithDetail();
    	us.setUser(user);
    	us.setModel(model);
    	us.setScore(strateger.getScore(user));
    	List<List<List<IUser>>> pvpresults = 
    			pVPMatchStrateger.match(unmatchUsers);
    	for(List<List<IUser>> result : pvpresults){
    		
        	for(List<IUser> group : result){
            	for(IUser u : group){
            		UserWithDetail ud = (UserWithDetail)u;
            		PVP5v5Model m = (PVP5v5Model)ud.getModel();
            		m.setUsers(result);
            		m.setMatched(true);
            	}
        	}
    	}
	}
	
	

}
