package com.game;

import com.game.base.SessionFactory;
import com.game.load.IScene;
import com.game.load.IUser;
import com.game.base.ISession;
import com.game.load.*;
import com.game.load.impl.*;
import com.game.playmodel.client.PlayModelFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static ICountryFactory countryFactory;
    public static void main(String arg[])throws Exception{
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
        PlayModelFactory.getPlayModel("pvp5v5").play();
        PlayModelFactory.getPlayModel("pvp10v10").play();
        PlayModelFactory.getPlayModel("pvp5v5v5").play();
        /*System.out.println("请选择游戏模式");
        System.out.println("1.pvp; 2.pve");

        String gameModel = bufferedReader.readLine();
        if(gameModel.equals("1")){//pvp
            System.out.println("已进入竞技场，请输入竞技人数：");
            PlayModelController playModelController =
                    PlayModelControllerFactory.getPlayModelController();
            playModelController.getPlayModel("pvp5v5").play();
        }else{//pve

        } */

    }
}
