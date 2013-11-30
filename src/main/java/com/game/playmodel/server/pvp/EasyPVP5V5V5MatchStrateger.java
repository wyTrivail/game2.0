package com.game.playmodel.server.pvp;

import java.util.ArrayList;
import java.util.List;

import com.game.load.IUser;

/**
 * 战力匹配战法最简单实现
 * @author XR
 *
 */
public class EasyPVP5V5V5MatchStrateger implements IPVPMatchStrateger {

	public List<List<List<IUser>>> match(List<UserWithDetail> users) {
		List<List<List<IUser>>> results = new ArrayList<List<List<IUser>>>();
		while(users.size() >= 15){
			List<List<IUser>> result = new ArrayList<List<IUser>>();
			List<IUser> group1 = new ArrayList<IUser>();
			List<IUser> group2 = new ArrayList<IUser>();
			List<IUser> group3 = new ArrayList<IUser>();
			for(int i = 0; i < 15; i += 3){
				group1.add(users.get(i));
			}
			for(int i = 1; i < 15; i += 3){
				group2.add(users.get(i));
			}
			for(int i = 2; i < 15; i += 3){
				group3.add(users.get(i));
			}
			//从未匹配用户中删除以匹配用户
			for(int i = 0; i < 15; i++){
				users.remove(0);
			}
			result.add(group1);
			result.add(group2);
			result.add(group3);
			results.add(result);
		}
		return results;
	}

}
