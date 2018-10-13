/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author dolrich
 */
public class Lib extends Application{

    /**
     * @param args the command line arguments
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        BookForm bf = new BookForm();
        GridPane gp = bf.getGp();
        PersonForm pf = new PersonForm();
        GridPane g = pf.getGp();
        TabPane tp = new TabPane();
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        tab1.setText("BOOK");
        tab2.setText("PERSON");
        tp.getTabs().add(tab1);
        tp.getTabs().add(tab2);
        tab1.setContent(gp);
        tab2.setContent(g);
        Scene s = new Scene(tp,300,500);
        tp.setTabClosingPolicy(UNAVAILABLE);
        primaryStage.setScene(s);
        primaryStage.show();
       
    }
    public static void main(String[] args) {
        launch(args);
    }
}
