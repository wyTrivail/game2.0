package com.game.playmodel.client.pvp;

import java.util.List;

import com.game.playmodel.client.IPVPModel;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IPVPController;
import com.game.base.SessionFactory;
import com.game.load.IUser;
/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class PVPModel implements IPVPModel{
	
	private IPVPController controller;
    
    private List<List<IUser>> users = null;
    
    private List<IUser> myGroup; 
    
    private String status;
	
    @Override
    public void play() {
    	status = "matching";
    	IUser user = SessionFactory.getSessioin().getCurrentUser();
    	controller.addUser(user, this);
    	int times = 0;
    	while(times < 5){
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		if(!status.equals("matching")){
    			//展示队员
    			break;
    		}
    		times ++;
    	}
    	if(status.equals("matching")){
        	System.out.println("匹配失败，继续其他模式吧");
    	}else{
    		while(true){
    			if(status.endsWith("over")){
    	    		if(myGroup.size() == 0){
    	    			System.out.println("很遗憾，你输了");
    	    		}else{
    	        		if(this.isLive()){
    	        			System.out.println("恭喜你，你赢了，并且活到了最后，");
    	        		}else{
    	        			System.out.println("恭喜你，你赢了，并且光荣的牺牲了，");
    	        		}
    	    		}
    	    		break;
    			}
        		try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	}
		this.clear();
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
	
	private boolean isLive(){
		for(IUser user : myGroup){
			if(user.getId().equals(SessionFactory.getSessioin().getCurrentUser().getId())){
				return true;
			}
		}
		return false;
	}
	
	private void clear(){
		status = "loading";
		this.myGroup = null;
		this.users = null;
	}

	@Override
	public void updateUsers(List<List<IUser>> users) {
		//分组完毕，进入战斗
		String strResult = "";
		strResult += "匹配成功对战玩家：\n";
		int i = 1;
		for(List<IUser> group : users){
    		strResult += "团队" + i + ":";
			for(IUser u : group){
	    		strResult += u.getUserName() + ",";
			}
    		strResult += "\n";
    		i++;
		}
		this.setUsers(users);
		System.out.print(strResult);
		status = "fighting";
		
	}

	@Override
	public void updateActions(List<IFightAction> actions) {
		for(IFightAction a : actions){
			a.show();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
	}

	@Override
	public void updateStatus(String status) {
		this.status = status;
	}
}
