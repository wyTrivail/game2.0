package com.game.playmodel.pve;

import java.util.ArrayList;
import java.util.List;

import com.game.base.SessionFactory;
import com.game.load.IUser;

public class Boss implements IBoss {
	public Boss(String bname){
		name = bname;
	}
	public String name;

	public IEquipment equip; //装备
	
	public List<IEquipment> eqList = new ArrayList();
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(name + "出场");
		System.out.println();
		System.out.println();
		System.out.println("用户发起了一次普通攻击");
		System.out.println("这是攻击动画");
		System.out.println(name + "损失了50滴血");
		System.out.println("这是滴血动画");
		System.out.println("------");
		if(name.equals("华雄")){
		    System.out.println(name + "来了一个挥刀霹雳斩");
		}else if(name.equals("吕布")){
			System.out.println(name + "来了个赤兔飞脚踢");
		}
		System.out.println("这是攻击动画");
		System.out.println("用户损失了200滴血");
		System.out.println("这是滴血动画");
		System.out.println("------");
		System.out.println("------");
		System.out.println("------");
		System.out.println("很遗憾，你输了");
		System.out.println(name + "Boss的功力可不是吹的哦！");
		
	}

}
