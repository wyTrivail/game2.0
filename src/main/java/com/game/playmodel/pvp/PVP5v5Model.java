package com.game.playmodel.pvp;

import java.util.List;

import com.game.playmodel.IPlayModel;
import com.game.base.SessionFactory;
import com.game.load.IUser;
/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class PVP5v5Model implements IPlayModel{
	
	private PVP5v5Controller controller;
	
	private UserScoreStrateger strateger;
    
    private List<List<IUser>> users = null;
    
    private boolean matched = false;
	
    @Override
    public void play() {
    	IUser user = SessionFactory.getSessioin().getCurrentUser();
    	controller.addUser(user, strateger, this);
    	int times = 0;
    	while(times < 10){
    		Thread.sleep(5000);
    		if(this.matched){
    			
    		}
    	}
    }

	public PVP5v5Controller getController() {
		return controller;
	}

	public void setController(PVP5v5Controller controller) {
		this.controller = controller;
	}

	public List<List<IUser>> getUsers() {
		return users;
	}

	public void setUsers(List<List<IUser>> users) {
		this.users = users;
	}

	public boolean getMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}
}
