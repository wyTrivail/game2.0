package com.game.playmodel.server;

import java.util.List;

import com.game.load.IUser;

public interface IGroupScoreStratege {
	
	public float getScore(List<IUser> user);

}
