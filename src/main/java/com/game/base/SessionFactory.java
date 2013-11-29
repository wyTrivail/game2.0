package com.game.base;

public class SessionFactory {
	
	private static ISession sessioin;

	public static ISession getSessioin() {
		return sessioin;
	}

	public static void setSessioin(ISession sessioin) {
		SessionFactory.sessioin = sessioin;
	}

}
