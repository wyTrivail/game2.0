package com.game.load.impl;


import com.game.base.IUnit;
import com.game.base.impl.LongFightUnit;
import com.game.base.impl.MagicAttack;
import com.game.load.IUser;

public class UserMaster extends User {
       public UserMaster(){
           IUnit iUnit = new LongFightUnit();
           iUnit.setAttackAttribute(new MagicAttack());
           this.setUnit(iUnit);
    	   this.setProfession("MASTER");
    	    System.out.println(this.getProfession());
       }
}
