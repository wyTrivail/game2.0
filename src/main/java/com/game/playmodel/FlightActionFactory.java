package com.game.playmodel;

import java.util.List;

import com.game.base.IShow;
import com.game.base.impl.NormalShow;
import com.game.load.IUser;

public class FlightActionFactory {
	

	private static IShow normalShow = new NormalShow();

	public static IFightAction getFightAction(String type, List<IUser> src, List<IUser> des){
		IFightAction r = null;
		if(type.equals("NormalFightAction")){
			r =  new NormalFightAction(src, des);
			r.setShow(normalShow);
		}
		return r;
	}
	
}
