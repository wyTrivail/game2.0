package com.game.load;

import com.game.load.impl.UserMaster;
import com.game.load.impl.User;
import com.game.load.impl.UserWarrior;



public class UserFactory {
	public static IUser creator(int which){
		//getClass 产生Sample 一般可使用动态类装载装入类。
		if (which==1)
			return new UserMaster();
		else if (which==2)
			return new UserWarrior();
		else 
			return new User();
		}
}
