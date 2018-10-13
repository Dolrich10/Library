/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import Database.Book;
import Database.Database;
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
public class BookForm {
    

Button btnSubmit; 
Label lName;
Label lISBN;
Label lAuthor; 
Label lPubG;
TextField tfName;
TextField tfISBN;
TextField tfAuthor;
TextField tfPubG;
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

    public Label getlISBN() {
        return lISBN;
    }

    public void setlISBN(Label lISBN) {
        this.lISBN = lISBN;
    }

    public Label getlAuthor() {
        return lAuthor;
    }

    public void setlAuthor(Label lAuthor) {
        this.lAuthor = lAuthor;
    }

    public Label getlPubG() {
        return lPubG;
    }

    public void setlPubG(Label lPubG) {
        this.lPubG = lPubG;
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public TextField getTfISBN() {
        return tfISBN;
    }

    public void setTfISBN(TextField tfISBN) {
        this.tfISBN = tfISBN;
    }

    public TextField getTfAuthor() {
        return tfAuthor;
    }

    public void setTfAuthor(TextField tfAuthor) {
        this.tfAuthor = tfAuthor;
    }

    public TextField getTfPubG() {
        return tfPubG;
    }

    public void setTfPubG(TextField tfPubG) {
        this.tfPubG = tfPubG;
    }

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }


  
public BookForm(){
        
        Button btnSubmit = new Button("SUBMIT");
        
        Label lTitle = new Label("BOOK");
        
        Label lName = new Label("BOOK NAME");
        Label lISBN = new Label("ISBN");
        Label lAuthor = new Label("AUTHOR");
        Label lPubG = new Label("PUBLISHER");
        
        TextField tfName = new TextField();
        TextField tfISBN = new TextField();
        TextField tfAuthor = new TextField();
        TextField tfPubG = new TextField();
        
        gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        
        gp.add(lTitle, 0, 0);
        
        gp.add(lName, 0, 1);
        gp.add(tfName, 1, 1);
        gp.add(lISBN, 0, 2);
        gp.add(tfISBN, 1, 2);
        gp.add(lAuthor, 0, 3);
        gp.add(tfAuthor, 1, 3);
        gp.add(lPubG, 0, 4);
        gp.add(tfPubG, 1, 4);
        
        gp.add(btnSubmit, 1, 5);       
        
 
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = tfName.getText();
                    String isbn = tfISBN.getText();
                    String auth = tfAuthor.getText();
                    String pubG = tfPubG.getText();
                    System.out.println(name);
                    System.out.println(isbn);
                    System.out.println(auth);
                    System.out.println(pubG);
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    Book b = new Book(name,isbn,auth,pubG);
                    b.insertBook(con);                    
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

