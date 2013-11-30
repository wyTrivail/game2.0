package com.game.load.impl;

import com.game.base.IUnit;
import com.game.base.impl.PhysicsAttack;
import com.game.base.impl.ShortFightUnit;

public class UserWarrior extends User {
	public UserWarrior(){
        IUnit unit = new ShortFightUnit();
        unit.setAttackAttribute(new PhysicsAttack());
        this.setUnit(unit);
		this.setProfession("WARRIOR");
		System.out.println(this.getProfession());
	}

}
