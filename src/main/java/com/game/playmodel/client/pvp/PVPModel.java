package com.game.playmodel.client.pvp;

import java.util.List;

import com.game.playmodel.client.IPlayModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;
import com.game.playmodel.server.pvp.IPVPController;
import com.game.playmodel.server.pvp.IUserScoreStrateger;
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
	
    @Override
    public void play() {
    	IUser user = SessionFactory.getSessioin().getCurrentUser();
    	controller.addUser(user, this);
    	int times = 0;
    	while(times < 10){
    		Thread.sleep(5000);
    		if(this.matched){
    			for(IFightAction a : actions){
    				a.show();
    			}
    		}
    	}
    	System.out.println("匹配失败，继续其他模式吧");
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
		this.users = users;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public void setActions(List<IFightAction> actions) {
		this.actions = actions;
	}
}
