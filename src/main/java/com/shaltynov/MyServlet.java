package com.shaltynov;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyServlet extends HttpServlet {

    private int gameStep;
    ResponseCreator responseCreator = new ResponseCreator();

    public void init() throws ServletException {
        gameStep = 0;
        System.out.println("Servlet initialized");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject json = new JSONObject();
        String buttonOneText = "Play";
        String buttonTwoText = "No";
        json.put("header", "Welcome to the quest!");
        json.put("button1", "" + buttonOneText + "");
        json.put("button2", "" + buttonTwoText + "");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(responseCreator.createJSONResponse(request).toString());
        out.flush();
    }
}

