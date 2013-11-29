package com.game;

import com.game.load.IScene;
import com.game.load.impl.Scene;
import com.game.load.impl.User;
import com.game.playmodel.client.IPlayModel;
import com.game.playmodel.client.PlayModelController;
import com.game.playmodel.client.PlayModelControllerFactory;
import com.game.playmodel.client.pvp.PVPModel;

/**
 * Created with IntelliJ IDEA.
 * User: xianliu.wy
 * Date: 13-11-26
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String arg[])throws Exception{
        User user = new User();//建议使用工厂
        IScene scene = new Scene();//同上
        scene.load();
        PlayModelController playModelController = 
        		PlayModelControllerFactory.getPlayModelController();
        playModelController.getPlayModel("pvp").play();
        
    }
}
