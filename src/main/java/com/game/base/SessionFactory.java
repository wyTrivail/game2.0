package com.game.base;

public class SessionFactory {
	
	private static ISession session;
	
	static{
		session = new Session();
	}

	public static ISession getSessioin() {
		return session;
	}

	public static void setSessioin(ISession sessioin) {
		SessionFactory.session = sessioin;
	}

}
