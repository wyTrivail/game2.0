package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;
import com.game.playmodel.server.IGroupScoreStratege;
import com.game.playmodel.server.IPVPMatchStratege;
import com.game.playmodel.server.PVPUserAdapter;

public class EasyPVP10V10MatchStrateger implements IPVPMatchStratege {
	
	private static EasyPVP10V10MatchStrateger easyPVP10V10MatchStrateger = new EasyPVP10V10MatchStrateger();
			
	private EasyPVP10V10MatchStrateger(){}
	
	public static EasyPVP10V10MatchStrateger getEasyPVP10V10MatchStrateger(){
		return easyPVP10V10MatchStrateger;
	}

	public List<List<List<IUser>>> match(List<PVPUserAdapter> users, IGroupScoreStratege stratege) {
		List<List<List<IUser>>> results = new ArrayList<List<List<IUser>>>();
		while(users.size() >= 20){
			List<List<IUser>> result = new ArrayList<List<IUser>>();
			List<IUser> group1 = new ArrayList<IUser>();
			List<IUser> group2 = new ArrayList<IUser>();
			for(int i = 0; i < 20; i += 2){
				group1.add(users.get(i));
			}
			for(int i = 1; i < 20; i += 2){
				group2.add(users.get(i));
			}
			//从未匹配用户中删除以匹配用户
			for(int i = 0; i < 20; i++){
				users.remove(0);
			}
			result.add(group1);
			result.add(group2);
			results.add(result);
		}
		return results;
	}

}
