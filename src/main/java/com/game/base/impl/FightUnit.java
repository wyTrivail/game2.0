package com.game.base.impl;

import com.game.base.IAttackAttribute;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:55
 * To change this template use File | Settings | File Templates.
 */
public class FightUnit extends BaseUnit {
    private Integer power;
    private Integer intelligence;
    private IAttackAttribute attackAttribute;
    private float life = 100.0f;
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public IAttackAttribute getAttackAttribute() {
        return attackAttribute;
    }

    public void setAttackAttribute(IAttackAttribute attackAttribute) {
        this.attackAttribute = attackAttribute;
    }

    @Override
    public float getLife() {
        return this.life;
    }

    @Override
    public void setLife(float life) {
        this.life = life;
    }
}
