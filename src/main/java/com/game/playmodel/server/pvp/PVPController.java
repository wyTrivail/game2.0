package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.client.IPlayModel;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;
import com.game.playmodel.server.IPlayController;

public class PVPController implements IPlayController {
	
	private IPVPMatchStrateger pVPMatchStrateger;
	
	private IFightProcess process;
	
	private List<PVPUserAdapter> unmatchUsers = 
			new ArrayList<PVPUserAdapter>();
	
	public void addUser(IUser user, IPlayModel model){
    	System.out.println("正在匹配中。。。");
    	PVPUserAdapter us = new PVPUserAdapter();
    	us.setUser(user);
    	us.setModel(model);
    	us.setScore(pVPMatchStrateger.getUserScoreStrateger().getScore(user));
    	boolean added = false;
    	for(PVPUserAdapter u : unmatchUsers){
    		if(u.getScore() < us.getScore()){
    			unmatchUsers.add(unmatchUsers.indexOf(u), us);
    		}
    	}
    	if(!added){
			unmatchUsers.add(unmatchUsers.size(), us);
    	}
    	List<List<List<IUser>>> pvpresults = pVPMatchStrateger.match(unmatchUsers);
    	for(List<List<IUser>> result : pvpresults){
    		//分组完毕，进入战斗
    		String strResult = "";
    		strResult += "匹配成功对战玩家：\n";
			int i = 1;
			for(List<IUser> group : result){
	    		strResult += "团队" + i + ":";
				for(IUser u : group){
		    		strResult += u.getUserName() + ",";
				}
	    		strResult += "\n";
	    		i++;
			}
        	for(List<IUser> group : result){
            	for(IUser u : group){
            		PVPUserAdapter ud = (PVPUserAdapter)u;
            		PVPModel m = (PVPModel)ud.getModel();
            		m.setUsers(result);
            		m.setStrGroups(strResult);
            		m.setMatched(true);
            	}
        	}
        	//战斗进行时
    		process.setUsers(result);
    		List<IFightAction> actions = process.getFightProcess();
        	for(List<IUser> group : result){
            	for(IUser u : group){
            		PVPUserAdapter ud = (PVPUserAdapter)u;
            		PVPModel m = (PVPModel)ud.getModel();
            		m.setActions(actions);
            	}
        	}
    	}
	}

	public void setPVPMatchStrateger(IPVPMatchStrateger pVPMatchStrateger) {
		this.pVPMatchStrateger = pVPMatchStrateger;
	}

	public void setProcess(IFightProcess process) {
		this.process = process;
	}
	
	

}
