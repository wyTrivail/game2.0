package com.game.base.impl;

import com.game.base.IAttackAttribute;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class MagicAttack implements IAttackAttribute {
    @Override
    public float getHit(Integer power, Integer intelligence) {
        return 2*intelligence;
    }
}
