package org.zerock.server;

import org.zerock.server.service.FoodService;
import org.zerock.server.ui.FoodServer;
import org.zerock.server.ui.FoodWebServer;

//서버의 메인
public class Main {
    //bad code
    public static void main(String[] args) throws Exception{

        FoodService foodService = new FoodService();
        FoodWebServer foodServer = new FoodWebServer(foodService);

        foodServer.doRun();


    }
}
