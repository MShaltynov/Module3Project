package com.shaltynov;

import org.json.simple.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ResponseCreator {
    GameTextCreator gameTextCreator;
    boolean pressButton1 = false;
    boolean pressButton2 = false;
    String userName;
    private int gameNumber = 1;
    int gameStep;
    Map<String, Integer> userSession = new HashMap<>();

    public JSONObject createJSONResponse(HttpServletRequest request) {
        gameTextCreator = new GameTextCreator();
        gameTextCreator.setButton1state(request.getParameter("buttonOneState"));
        gameTextCreator.setButton2State(request.getParameter("buttonTwoState"));
        if (request.getParameter("textInputValue") != null) {
            userName = (request.getParameter("textInputValue"));
            if(!userSession.containsKey(userName)){
                gameNumber=1;
            }
        }
        userSession.put(userName, gameNumber);
        buttonConditionHandler();
        JSONObject json = new JSONObject();
        json.put("header", gameTextCreator.getHeaderText(gameStep));
        json.put("step", gameStep);
        json.put("userName", userName);
        json.put("gameNumber", userSession.get(userName));
        json.put("button1", gameTextCreator.getButton1text(gameStep));
        json.put("button2", gameTextCreator.getButton2text(gameStep));
        json.put("button1Visibility", gameTextCreator.getButton1Visibility());
        json.put("button2Visibility", gameTextCreator.getButton2Visibility());
        json.put("textInputVisibility", gameTextCreator.getTextInputVisibility());
        json.put("labelTextVisibility", gameTextCreator.getLabelTextVisibility());

        if (gameStep >= 4) {
            gameStep = 0;
            ++gameNumber;
            userSession.put(userName, gameNumber);
        }
        return json;
    }

    void buttonConditionHandler() {
        if (gameTextCreator.getButton1state().equals("1")) {
            ++gameStep;
            sceneGenerator();
            pressButton1 = true;
            gameTextCreator.setButton1state("0");

        }
        if (gameTextCreator.getButton2state().equals("1")) {
            gameStep += 10;
            pressButton2 = true;
            sceneGenerator();
            gameTextCreator.setButton2State("0");

        }
    }

    void sceneGenerator() {
        if (gameStep > 0 && gameStep <= 3) {
            changeScene1();
        } else if (gameStep > 3) {
            changeScene2();
        } else {
            changeScene0();
        }
    }

    public void changeScene0() {
        gameTextCreator.setLabelTextVisibility("1");
        gameTextCreator.setTextInputVisibility("1");
        gameTextCreator.setButton1Visibility("1");
        gameTextCreator.setButton2Visibility("0");
    }

    public void changeScene1() {
        gameTextCreator.setLabelTextVisibility("0");
        gameTextCreator.setTextInputVisibility("0");
        gameTextCreator.setButton1Visibility("1");
        gameTextCreator.setButton2Visibility("1");
    }

    public void changeScene2() {
        gameTextCreator.setLabelTextVisibility("0");
        gameTextCreator.setTextInputVisibility("0");
        gameTextCreator.setButton1Visibility("1");
        gameTextCreator.setButton2Visibility("0");
    }
}
