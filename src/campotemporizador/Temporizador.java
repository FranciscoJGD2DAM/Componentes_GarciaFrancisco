/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotemporizador;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class Temporizador extends AnchorPane {

    @FXML
    private Label temporizador;

    private IntegerProperty segundos = new SimpleIntegerProperty();
    
    public Temporizador(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
        fxmlLoader.load(); // Carga una jerarquía de objetos desde un documento XML
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
    public void setTime(Integer s){
        temporizador.setText(s.toString());
        segundos.set(s);
    }
    public void iniciarContador(){
        KeyValue tiempo = new KeyValue(segundos, 0);
        
        EventHandler onFinished =new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                fireEvent(arg0);
            }
        };
        
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(0);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10000),onFinished, tiempo));
        timeline.play();
        
        temporizador.textProperty().bind(segundos.asString());
    }
    
    
    
}
