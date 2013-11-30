package com.game.playmodel.client.pvp;

import java.util.List;

import com.game.playmodel.client.IPlayModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.pvp.IPVPController;
import com.game.base.SessionFactory;
import com.game.load.IUser;
/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class PVPModel implements IPlayModel{
	
	private IPVPController controller;
    
    private List<List<IUser>> users = null;
    
    private boolean matched = false;
    
    private List<IFightAction> actions;
    
    private List<IUser> myGroup; 
    
    private String strGroups;
	
    @Override
    public void play() {
    	IUser user = SessionFactory.getSessioin().getCurrentUser();
    	controller.addUser(user, this);
    	int times = 0;
    	while(times < 10){
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		if(this.matched){
    			//展示队员
    			System.out.print(this.strGroups);
    			//等待战斗结束
    			while(actions == null){
    	    		try {
    					Thread.sleep(1000);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			for(IFightAction a : actions){
    				a.show();
    			}
    			break;
    		}
    	}
    	if(!this.matched){
        	System.out.println("匹配失败，继续其他模式吧");
    	}else{
    		if(myGroup.size() == 0){
    			System.out.println("很遗憾，你输了");
    		}else{
        		if(this.isLive()){
        			System.out.println("恭喜你，你赢了，并且活到了最后，");
        		}else{
        			System.out.println("恭喜你，你赢了，并且光荣的牺牲了，");
        		}
    		}
    	}
    }

	public IPVPController getController() {
		return controller;
	}

	public void setController(IPVPController controller) {
		this.controller = controller;
	}

	public List<List<IUser>> getUsers() {
		return users;
	}

	public void setUsers(List<List<IUser>> users) {
		for(List<IUser> group : users){
			for(IUser user : group){
				if(user.getId().equals(SessionFactory.getSessioin().getCurrentUser().getId())){
					myGroup = group;
				}
			}
		}
		this.users = users;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public void setActions(List<IFightAction> actions) {
		this.actions = actions;
	}
	
	private boolean isLive(){
		for(IUser user : myGroup){
			if(user.getId().equals(SessionFactory.getSessioin().getCurrentUser().getId())){
				return true;
			}
		}
		return false;
	}

	public String getStrGroups() {
		return strGroups;
	}

	public void setStrGroups(String strGroups) {
		this.strGroups = strGroups;
	}
}
