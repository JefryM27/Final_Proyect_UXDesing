package controller;

import model.DBConnectionJava;
import view.*;

public class FinalProyect {

    public static void main(String[] args) {

        loginGeneral myUI = new loginGeneral(); // Crear una instancia de voterUI
        
        myUI.setVisible(true);
        

        /*DBConnectionJava db = new DBConnectionJava();
        db.getConnection();
        db.disconnect();*/
    }

}
