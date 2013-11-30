package com.game.load.impl;

import com.game.base.IUnit;
import com.game.base.impl.BaseModel;
import com.game.base.impl.PhysicsAttack;
import com.game.base.impl.ShortFightUnit;

public class UserWarrior extends User {
	public UserWarrior(){
        IUnit unit = new ShortFightUnit();
        unit.setModel(new BaseModel());
        unit.setAttackAttribute(new PhysicsAttack());
        this.setUnit(unit);
		this.setProfession("战士");
		System.out.println(this.getProfession());
	}

}
