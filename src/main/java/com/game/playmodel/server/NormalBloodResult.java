package com.game.playmodel.server;

import com.game.base.IShow;
import com.game.load.IUser;

public class NormalBloodResult implements IFightResult {

	private IUser user;
	private IShow show;
	private IFightAction action;
	private IHarmStratege harmStratege;
	
	public String getType() {
		return "NormalBloodResult";
	}

	public String getStrResult() {
		return user.getUserName() + "损失了" + getHarm() + "滴血";
	}

	public IShow getShow() {
		return show;
	}

	public void setShow(IShow show) {
		this.show = show;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

	public void show() {
		show.show();
	}

	public IFightAction getAction() {
		return action;
	}

	public void setAction(IFightAction action) {
		this.action = action;
	}
	
	public IHarmStratege getHarmStratege() {
		return harmStratege;
	}

	public void setHarmStratege(IHarmStratege harmStratege) {
		this.harmStratege = harmStratege;
	}

	private int getHarm(){
		return harmStratege.getHarm(this.action.getBaseHurm(), this.getUser());
	}

}
