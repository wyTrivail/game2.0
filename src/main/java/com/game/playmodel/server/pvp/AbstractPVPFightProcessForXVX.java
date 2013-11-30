package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.base.impl.FightUnit;
import com.game.load.IUser;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;
import com.game.playmodel.server.IFightResult;

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
			IFightAction a = this.getOneAction();
			for(IFightResult r : a.getResult()){
				FightUnit fu = (FightUnit) r.getUser().getUnit();
				if(fu.getLife() < 0){
					a.getDes().remove(r.getUser());
				}
			}
			actions.add(a);
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

	/**
	 * 现在应该由谁出现什么样的操作，可系统控制也可玩家控制，看实现
	 * @return
	 */
	protected abstract IFightAction getOneAction();
	
	

}
