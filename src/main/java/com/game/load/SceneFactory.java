package com.game.load;

import com.game.base.SessionFactory;
import com.game.load.impl.SceneAthletics;
import com.game.load.impl.SceneDuplicate;
import com.game.load.impl.SceneTown;

public class SceneFactory {
	public static IScene creator(int which){
		//getClass ����Sample һ���ʹ�ö�̬��װ��װ���ࡣ
		if (which==1){
            SceneTown sceneTown = new SceneTown();
            sceneTown.setMyUser(SessionFactory.getSessioin().getCurrentUser());
			return new SceneTown();
        }else if (which==2)
			return new SceneDuplicate();
		else if(which==3)
			return new SceneAthletics();
		else
			return null;
		}
}
