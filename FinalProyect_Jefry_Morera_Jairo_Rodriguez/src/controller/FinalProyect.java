package controller;

import model.DBConnectionJava;
import view.*;

public class FinalProyect {

    public static void main(String[] args) {

        voterUI myUI = new voterUI(); // Crear una instancia de voterUI
        
        myUI.setVisible(true);
        

        /*DBConnectionJava db = new DBConnectionJava();
        db.getConnection();
        db.disconnect();*/
    }

}
