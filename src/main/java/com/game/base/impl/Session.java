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

    IUser user;
    public void setCurrentUser(IUser user) {
        this.user = user;
    }
    public IUser getCurrentUser() {
        return user;
    }


}
