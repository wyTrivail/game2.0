package com.game.load;

import com.game.load.impl.SceneAthletics;
import com.game.load.impl.SceneDuplicate;
import com.game.load.impl.SceneTown;

public class SceneFactory {
	public static IScene creator(int which){
		//getClass 产生Sample 一般可使用动态类装载装入类。
		if (which==1)
			return new SceneTown();
		else if (which==2)
			return new SceneDuplicate();
		else if(which==3)
			return new SceneAthletics();
		else
			return null;
		}
}
