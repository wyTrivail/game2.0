package com.game.playmodel.server;

import com.game.base.IShow;
import com.game.base.impl.NormalShow;
import com.game.load.IUser;

public class FightResultFactory {
	
	private static IHarmStratege normalHarmStratege = new NormalHarmStratege();
	private static IShow normalShow = new NormalShow();
	
	private static IFightResult normalBloodResult = new NormalBloodResult();
	
	static{
		normalBloodResult.setHarmStratege(normalHarmStratege);
		normalBloodResult.setShow(normalShow);
	}
	
	public static IFightResult getFightResult(String type, IUser user, IFightAction action){
		IFightResult r = null;
		if(type.equals("NormalBloodResult")){
			r = normalBloodResult.create(user, action);
		}
		return r;
	}

}
