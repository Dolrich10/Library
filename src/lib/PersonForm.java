/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import Database.Book;
import Database.Database;
import Database.Person;
import static com.oracle.jrockit.jfr.ContentType.Address;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author dolrich
 */
public class PersonForm {
    
    
    Button btnSubmit; 
    Label lName;
    Label lAddress;
    Label lph; 
    TextField tfName;
    TextField tfaddress;
    TextField tfph;
    GridPane gp; 

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(Button btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public Label getlName() {
        return lName;
    }

    public void setlName(Label lName) {
        this.lName = lName;
    }

    public Label getlAddress() {
        return lAddress;
    }

    public void setlAddress(Label lAddress) {
        this.lAddress = lAddress;
    }

    public Label getLph() {
        return lph;
    }

    public void setLph(Label lph) {
        this.lph = lph;
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public TextField getTfaddress() {
        return tfaddress;
    }

    public void setTfaddress(TextField tfaddress) {
        this.tfaddress = tfaddress;
    }

    public TextField getTfph() {
        return tfph;
    }

    public void setTfph(TextField tfph) {
        this.tfph = tfph;
    }

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }
    
    

    public PersonForm(){
     Button btnSubmit = new Button("SUBMIT");
        
        Label lTitle = new Label("PERSON");
        
        Label lName = new Label("NAME");
        Label laddress = new Label("ADDRESS");
        Label lph = new Label("PH");
  
        
        TextField tfName = new TextField();
        TextField tfaddress = new TextField();
        TextField tfph = new TextField();
       
        
        gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        
        gp.add(lTitle, 0, 0);
        
        gp.add(lName, 0, 1);
        gp.add(tfName, 1, 1);
        gp.add(laddress, 0, 2);
        gp.add(tfaddress, 1, 2);
        gp.add(lph, 0, 3);
        gp.add(tfph, 1, 3);
      
        
        gp.add(btnSubmit, 1, 5);       
        
 
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = tfName.getText();
                    String address = tfaddress.getText();
                    String ph = tfph.getText();
                    System.out.println(name);
                    System.out.println(address);
                    System.out.println(ph);
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    Person p = new Person(name,address,ph);
                    p.insertPerson(con);                    
                    con.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(BookForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BookForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
   
    
}

    

    

