package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;

public class PVPController implements IPVPController {
	
	private IPVPMatchStrateger pVPMatchStrateger;
	
	private IUserScoreStrateger userScoreStrateger;
	
	private IFightProcess process;
	
	private List<UserWithDetail> unmatchUsers = 
			new ArrayList<UserWithDetail>();
	
	public void addUser(IUser user, PVPModel model){
    	System.out.print("正在匹配中。。。");
    	UserWithDetail us = new UserWithDetail();
    	us.setUser(user);
    	us.setModel(model);
    	us.setScore(userScoreStrateger.getScore(user));
    	boolean added = false;
    	for(UserWithDetail u : unmatchUsers){
    		if(u.getScore() < us.getScore()){
    			unmatchUsers.add(unmatchUsers.indexOf(u), us);
    		}
    	}
    	if(!added){
			unmatchUsers.add(unmatchUsers.size(), us);
    	}
    	List<List<List<IUser>>> pvpresults = pVPMatchStrateger.match(unmatchUsers);
    	for(List<List<IUser>> result : pvpresults){
    		process.setUsers(result);
    		List<IFightAction> actions = process.getFightProcess();
        	for(List<IUser> group : result){
            	for(IUser u : group){
            		UserWithDetail ud = (UserWithDetail)u;
            		PVPModel m = (PVPModel)ud.getModel();
            		m.setUsers(result);
            		m.setActions(actions);
            		m.setMatched(true);
            	}
        	}
    	}
	}

	public void setPVPMatchStrateger(IPVPMatchStrateger pVPMatchStrateger) {
		this.pVPMatchStrateger = pVPMatchStrateger;
	}

	public void setUserScoreStrateger(IUserScoreStrateger userScoreStrateger) {
		this.userScoreStrateger = userScoreStrateger;
	}

	public void setProcess(IFightProcess process) {
		this.process = process;
	}
	
	

}
