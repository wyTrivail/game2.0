package com.game.playmodel.client;

import com.game.load.IUser;
import com.game.load.impl.User;
import com.game.playmodel.client.pvp.PVPModel;
import com.game.playmodel.pve.PVEModel;
import com.game.playmodel.server.FlightActionFactory;
import com.game.playmodel.server.IFightAction;
import com.game.playmodel.server.pvp.EasyPVP5V5MatchStrateger;
import com.game.playmodel.server.pvp.EasyUserScoreStrateger;
import com.game.playmodel.server.pvp.NormalPVPFightProcessForXVX;
import com.game.playmodel.server.pvp.PVPController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayModelControllerFactory {
	
	private static PlayModelController c = new PlayModelController();
	
	static{
		c.addPlayModel("pve", new PVEModel());
		PVPModel model = new PVPModel();
		PVPController controller = new PVPController();
		controller.setPVPMatchStrateger(new EasyPVP5V5MatchStrateger());
		controller.setUserScoreStrateger(new EasyUserScoreStrateger());
		controller.setProcess(new NormalPVPFightProcessForXVX());
		model.setController(controller);
        List<IFightAction> actionList = new ArrayList<IFightAction>();
        List<IUser> users = new LinkedList<IUser>();
        users.add(new User());
        List<IUser> otherUsers = new LinkedList<IUser>();
        otherUsers.add(new User());
        actionList.add(FlightActionFactory.getFightAction("NormalFightAction",users, otherUsers ));
        model.setActions(actionList);
        model.setMatched(true);
		c.addPlayModel("pvp5v5", model);
	}
	
	public static PlayModelController getPlayModelController(){
		return c;
	}

}
