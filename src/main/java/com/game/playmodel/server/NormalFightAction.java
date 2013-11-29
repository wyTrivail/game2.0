package com.game.playmodel.server;

import java.util.List;

import com.game.base.IShow;
import com.game.load.IUser;

/**
 * 普通攻击
 * @author XR
 *
 */
public class NormalFightAction implements IFightAction {

	List<IUser> src;
	List<IUser> des;
	IShow show;
	String resultType = "NormalBloodResult";
	String type = "NormalFightAction";
	List<IFightResult> result;
	
	public NormalFightAction(List<IUser> src, List<IUser> des){
		this.src = src; 
		this.des = des;
		IFightResult r = FightResultFactory.getFightResult(getResultType());
		r.setAction(this);
		result.add(r);
	}

	
	public int getBaseHurm() {
		return 100;
	}

	public List<IFightResult> getResult() {
		return result;
	}

	public List<IUser> getSrc() {
		return src;
	}

	public void setSrc(List<IUser> src) {
		this.src = src;
	}

	public List<IUser> getDes() {
		return des;
	}

	public void setDes(List<IUser> des) {
		this.des = des;
	}

	public String getActionType() {
		return "normal attact";
	}

	public String getBaseHurmType() {
		return "blood";
	}

	public IShow getShow() {
		return show;
	}

	public void setShow(IShow show) {
		this.show = show;
	}

	public String getResultType() {
		return resultType;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setResultType(String resultType) {
		this.resultType = resultType;
	}


	public void show() {
		show.show();
		for(IFightResult r : result){
			r.show();
			System.out.println(r.getStrResult());
		}
	}

}
