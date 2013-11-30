package com.game.load.impl;

import com.game.base.IUnit;
import com.game.load.IScene;
import com.game.load.IUser;
import com.game.load.UserFactory;


/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class Scene implements IScene{
	private IUnit unit;
	private IUser npc;
	private IUser myUser;
	
	public IUnit getUnit() {
		return unit;
	}
	public void setUnit(IUnit unit) {
		this.unit = unit;
	}
	public IUser getNpc() {
		return npc;
	}
	public void setNpc(IUser npc) {
		this.npc = npc;
	}
	public IUser getMyUser() {
		return myUser;
	}
	public void setMyUser(IUser myUser) {
		this.myUser = myUser;
	}
	
	public final void load() {
        //To change body of implemented methods use File | Settings | File Templates.

        System.out.println("加载时间模块");
    	timeManagement();
        System.out.println("加载操作菜单");
    	manipulationMenu();
        System.out.println("加载世界地图");
    	worldMap();
        System.out.println("加载背景图片");
    	backgroundPicture();
        System.out.println("加载背景音乐");
    	backgroundMusic();
    	allocUnit();
    }
    protected abstract void timeManagement();
    protected abstract void manipulationMenu();
    protected abstract void worldMap();
    protected abstract void backgroundPicture();
    protected abstract void backgroundMusic();
    
    protected void allocUnit(){
        System.out.println("渲染场景");
        System.out.println("阵营："+myUser.getCountry().getName());
        System.out.println("主公:"+myUser.getCountry().getNPCS().get(0).getUserName());
        System.out.println("姓名:"+myUser.getUserName());
        System.out.println("职业:"+myUser.getProfession());

        myUser.getUnit().draw();
        /*npc=UserFactory.creator(3);
    	((User)npc).setUnit(unit);
    	
    	myUser=UserFactory.creator(1);
    	((User)myUser).setUnit(unit); */
    }
}
