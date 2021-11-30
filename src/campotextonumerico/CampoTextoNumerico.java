/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotextonumerico;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class CampoTextoNumerico extends TextField {
    
    final static Label label = new Label();
    
    public CampoTextoNumerico() {
        
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoNumerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        final Label euros = new Label("€");
        Button buton = new Button();
        
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }   
         

        
 
        
    } 
    public void replaceText(int start, int end, String text) {
        if (text.matches("[1-9]")) {
            super.replaceText(start, end, text);   
        }
    }
    public void replaceSelection(String text) {
        if (text.matches("[1-9]")) {
            super.replaceSelection(text);
        }
    }
}
