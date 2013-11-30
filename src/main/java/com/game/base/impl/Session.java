package com.game.base.impl;

import com.game.base.ISession;
import com.game.load.IUser;

/**
 * Created with IntelliJ IDEA.
 * User: wy
 * Date: 13-11-30
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */
public class Session implements ISession {
    public void setUser(IUser user) {
        this.user = user;
    }

    IUser user;
    @Override
    public IUser getCurrentUser() {
        return user;
    }


}
