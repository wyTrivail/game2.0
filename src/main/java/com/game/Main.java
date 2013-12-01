package com.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.game.base.ISession;
import com.game.base.SessionFactory;
import com.game.load.ICountry;
import com.game.load.ICountryFactory;
import com.game.load.IScene;
import com.game.load.IUser;
import com.game.load.SceneFactory;
import com.game.load.UserFactory;
import com.game.load.impl.SuCountryFactory;
import com.game.load.impl.WeiCountryFactory;
import com.game.load.impl.WuCountryFactory;
import com.game.playmodel.client.PlayModelController;
import com.game.playmodel.client.PlayModelControllerFactory;
import com.game.playmodel.pve.Boss;
import com.game.playmodel.pve.DecorateBJTK;
import com.game.playmodel.pve.DecorateCD;
import com.game.playmodel.pve.DecorateCTM;
import com.game.playmodel.pve.DecorateXBM;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static ICountryFactory countryFactory;
    static Map<String,String> map = new HashMap<String, String>();
    public static void main(String arg[])throws Exception{
        map.put("1","pvp5v5");
        map.put("2", "pvp5v5v5");
        map.put("3", "pvp10v10");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("欢迎进入三国无双online");
        System.out.println("请设定人物职业：");
        System.out.println("1.战士； 2.法师");

        String work = bufferedReader.readLine();
        System.out.println("请设定人物性别");
        System.out.println("1.男； 2.女");

        String gender = bufferedReader.readLine();

        System.out.println("1.魏国； 2.吴国； 3.蜀国");


        String countryName = bufferedReader.readLine();//阵营
        ICountry country = null;
        if(countryName.equals("1")){
            countryFactory = new WeiCountryFactory();
            country = countryFactory.createCountry("wei");
        } else if(countryName.equals("2")){
            countryFactory = new WuCountryFactory();
            country = countryFactory.createCountry("wu");
        } else if(countryName.equals("3")){
            countryFactory = new SuCountryFactory();
            country = countryFactory.createCountry("su");
        }

        System.out.println("请为自己起个大名吧英雄！");

        String name = bufferedReader.readLine();
        System.out.println("正在进入场景");
        IUser user = UserFactory.creator(name, gender,work, country);
        ISession session = SessionFactory.getSessioin();
        session.setCurrentUser(user);
        IScene scene = SceneFactory.creator(1);
        scene.load();
        System.out.println("欢迎进入我方阵营！");

        while(true){
        System.out.println("请选择游戏模式");
        System.out.println("1.pvp; 2.pve");

        String gameModel = bufferedReader.readLine();
        if(gameModel.equals("1")){//pvp
            System.out.println("请选择竞技场：");
            System.out.println("1.5v5; 2.5v5v5; 3.10v10");
            String num = bufferedReader.readLine();


            PlayModelController playModelController =
                    PlayModelControllerFactory.getPlayModelController();
            playModelController.getPlayModel(map.get(num)).play();
        }else{//pve
        	System.out.println("请选择boss：");
            System.out.println("1.华雄; 2.吕布");
            String num = bufferedReader.readLine();
            if(num.equals("1")){
            	Boss boss = new Boss("华雄");
            	
            	
            	boss.eqList.add(new DecorateCD(null));
            	boss.eqList.add(new DecorateXBM(null));
            	if(boss.eqList.size() != 0){
            		for(int i=0; i<boss.eqList.size(); i++)
            			boss.eqList.get(i).quip();
            	}
            	boss.play();
            }else if(num.equals("2")){
            	Boss boss = new Boss("吕布");
            	
            	boss.eqList.add(new DecorateCTM(null));
            	boss.eqList.add(new DecorateBJTK(null));
            	if(boss.eqList.size() != 0){
            		for(int i=0; i<boss.eqList.size(); i++)
            			boss.eqList.get(i).quip();
            	}
            	boss.play();
            } 
        }
       }

    }
}
