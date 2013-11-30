package com.game.base;

import com.game.base.impl.Session;

public class SessionFactory {
	
	private static ISession sessioin = new Session();

	public static ISession getSessioin() {
		return sessioin;
	}

	public static void setSessioin(ISession sessioin) {
		SessionFactory.sessioin = sessioin;
	}

}
