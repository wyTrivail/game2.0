package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.base.impl.FightUnit;
import com.game.load.IUser;
import com.game.playmodel.server.FlightActionFactory;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.IFightProcess;
import com.game.playmodel.server.IFightResult;

public class NormalFightProcessForXVXVX implements IFightProcess {

	protected List<IUser> group1;
	protected List<IUser> group2;
	protected List<IUser> group3;
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
		if(group1.size() + group2.size() == 0 ||
				group1.size() + group3.size() == 0 ||
				group2.size() + group3.size() == 0 ){
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

	public void setUsers(List<List<IUser>> groups) {
		group1 = groups.get(0);
		group2 = groups.get(1);
		group3 = groups.get(2);
	}
	
	int turn = 0;

	/**
	 * 现在应该由谁出现什么样的操作，可系统控制也可玩家控制，看实现
	 * @return
	 */
	protected IFightAction getOneAction() {
		IFightAction action = null;
		List<IUser> des;
		if(turn == 0){
			turn = 1;
			if(group1.size() == 0){
				return this.getOneAction();
			}
			if(group2.size() < group3.size()){
				des = group3;
			}else{
				des = group2;
			}
			action = FlightActionFactory.getFightAction(actionType, group1, des);
		} else if(turn == 1){
			turn = 2;
			if(group2.size() == 0){
				return this.getOneAction();
			}
			if(group1.size() < group3.size()){
				des = group3;
			}else{
				des = group1;
			}
			action = FlightActionFactory.getFightAction(actionType, group2, des);
		} else{
			turn = 0;
			if(group3.size() == 0){
				return this.getOneAction();
			}
			if(group1.size() < group2.size()){
				des = group2;
			}else{
				des = group1;
			}
			action = FlightActionFactory.getFightAction(actionType, group3, des);
		}
		return action;
	}

	public String getType() {
		return "NormalPVPFightProcessForXVX";
	}

}
