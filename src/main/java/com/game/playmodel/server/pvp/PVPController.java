package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.client.IPVPModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;
import com.game.playmodel.server.IGroupScoreStratege;
import com.game.playmodel.server.IPVPMatchStratege;
import com.game.playmodel.server.IPVPController;
import com.game.playmodel.server.IUserScoreStratege;
import com.game.playmodel.server.PVPUserAdapter;

public class PVPController implements IPVPController {
	
	private IPVPMatchStratege pVPMatchStrateger;
	
	private IFightProcess process;
	
	private List<PVPUserAdapter> unmatchUsers = 
			new ArrayList<PVPUserAdapter>();
	
	public void addUser(IUser user, IPVPModel model){
    	System.out.println("正在匹配中。。。");
    	PVPUserAdapter us = new PVPUserAdapter();
    	us.setUser(user);
    	us.setModel(model);
    	us.setScore(userScoreStrateger.getScore(user));
    	boolean added = false;
    	for(PVPUserAdapter u : unmatchUsers){
    		if(u.getScore() < us.getScore()){
    			unmatchUsers.add(unmatchUsers.indexOf(u), us);
    		}
    	}
    	if(!added){
			unmatchUsers.add(unmatchUsers.size(), us);
    	}
    	List<List<List<IUser>>> pvpresults = pVPMatchStrateger.match(unmatchUsers, groupScoreStratege);
    	for(List<List<IUser>> result : pvpresults){
    		//分组成功，存用户信息,并通知用户
    		List<PVPUserAdapter> users = new ArrayList<PVPUserAdapter>();
        	for(List<IUser> group : result){
            	for(IUser u : group){
            		//保存用户
            		PVPUserAdapter ud = (PVPUserAdapter)u;
            		users.add(ud);
            		
            		//通知用户匹配成功
            		IPVPModel m = (IPVPModel)ud.getModel();
            		m.updateUsers(result);
            	}
        	}
        	
        	//战斗进行时
    		process.setUsers(result);
    		List<IFightAction> actions = process.getFightProcess();
    		//通知用户战斗结果
        	for(PVPUserAdapter ud : users){
        		IPVPModel m = (IPVPModel)ud.getModel();
        		m.updateActions(actions);
        		m.updateStatus("over");
        	}
    	}
	}

	public void setPVPMatchStrateger(IPVPMatchStratege pVPMatchStrateger) {
		this.pVPMatchStrateger = pVPMatchStrateger;
	}

	public void setProcess(IFightProcess process) {
		this.process = process;
	}

	private IUserScoreStratege userScoreStrateger;
	
	public void setUserScoreStrateger(IUserScoreStratege userScoreStrateger) {
		this.userScoreStrateger = userScoreStrateger;
	}

	public IUserScoreStratege getUserScoreStrateger() {
		return userScoreStrateger;
	}
	
	private IGroupScoreStratege groupScoreStratege;
	
	public void setGroupScoreStrateger(IGroupScoreStratege userScoreStrateger) {
		this.groupScoreStratege = userScoreStrateger;
	}

	public IGroupScoreStratege getGroupScoreStrateger() {
		return groupScoreStratege;
	}
	
	

}
