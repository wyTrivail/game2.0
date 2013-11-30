package com.game.load.impl;


import com.game.base.IUnit;
import com.game.base.impl.BaseModel;
import com.game.base.impl.Cylinder;
import com.game.base.impl.LongFightUnit;
import com.game.base.impl.MagicAttack;
import com.game.load.IUser;

public class UserMaster extends User {
       public UserMaster(){
           IUnit iUnit = new LongFightUnit();
           iUnit.setModel(new BaseModel());
           iUnit.setAttackAttribute(new MagicAttack());
           this.setUnit(iUnit);
    	   this.setProfession("法师");
    	    System.out.println(this.getProfession());
       }
}
