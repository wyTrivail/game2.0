package com.game.playmodel.server;

import java.util.List;

import com.game.base.IShow;
import com.game.base.impl.NormalShow;
import com.game.load.IUser;

public class FlightActionFactory {
	

	private static IShow normalShow = new NormalShow();
	private static IFightAction normalFightAction = new NormalFightAction();
	
	
	static{
		normalFightAction.setShow(normalShow);
	}

	public static IFightAction getFightAction(String type, List<IUser> src, List<IUser> des){
		IFightAction r = null;
		if(type.equals("NormalFightAction")){
			r = normalFightAction.create(src, des);
		}
		return r;
	}
	
}
