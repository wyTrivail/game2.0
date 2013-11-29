package com.game.playmodel.pvp.server;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.IFightAction;
import com.game.playmodel.IFightProcess;

public abstract class AbstractPVPFightProcessForXVX implements IFightProcess {

	protected List<IUser> src;
	protected List<IUser> des;
	protected String actionType = "NormalFightAction";

	/**
	 * 简单实现，采取回合制吧
	 */
	public List<IFightAction> getFightProcess() {
		List<IFightAction> actions = new ArrayList<IFightAction>();
		while(!this.isOver()){
			actions.add(this.getOneAction());
		}
		return actions;
	}
	
	/**
	 * 判断游戏是否结束
	 * @return
	 */
	private boolean isOver(){
		if(src.size() == 0 || des.size() == 0){
			return true;
		}
		return false;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	protected abstract IFightAction getOneAction();

	public void setSrc(List<IUser> src) {
		this.src = src;
	}

	public void setDes(List<IUser> des) {
		this.des = des;
	}

	public void setUsers(List<List<IUser>> groups) {
		src = groups.get(0);
		des = groups.get(1);
	}
	
	

}
