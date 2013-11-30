package com.game.load;

import com.game.load.impl.UserMaster;
import com.game.load.impl.User;
import com.game.load.impl.UserWarrior;



public class UserFactory {
	
	private static int userId = 0;
	
	public static IUser creator(String name,String gender,String work, ICountry country){
		//getClass ����Sample һ���ʹ�ö�̬��װ��װ���ࡣ
		if (work.equals("2")){
            IUser userMaster = new UserMaster();
            userMaster.setUserName(name);
            userMaster.setGender(Integer.getInteger(gender));
            userMaster.setCountry(country);
            userMaster.setId(++userId);
			return userMaster;
        }else if (work.equals("1")){

            IUser userWarrior = new UserWarrior();
            userWarrior.setUserName(name);
            userWarrior.setGender(Integer.getInteger(gender));
            userWarrior.setCountry(country);
            userWarrior.setId(++userId);
			return userWarrior;
        }else{
        	IUser user = new User();
			user.setId(++userId);
			return user;
		}
	}
}
