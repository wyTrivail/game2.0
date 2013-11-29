package com.game.playmodel.server;

import com.game.base.IShow;
import com.game.base.impl.NormalShow;

public class FightResultFactory {
	
	private static IHarmStratege normalHarmStratege = new NormalHarmStratege();
	private static IShow normalShow = new NormalShow();
	
	public static IFightResult getFightResult(String type){
		IFightResult r = null;
		if(type.equals("NormalBloodResult")){
			r =  new NormalBloodResult();
			r.setHarmStratege(normalHarmStratege);
			r.setShow(normalShow);
		}
		return r;
	}

}
