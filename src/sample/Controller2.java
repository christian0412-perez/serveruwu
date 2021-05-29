package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import model.Server;

import java.util.Observable;
import java.util.Observer;

public class Controller2 implements Observer {
    public Controller2(){
        Server s = new Server(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    @FXML
    private TextArea textAreamensajes;

    @FXML
    private TextField textFieldMensaje;

    @FXML
    private Button buttonSend;

    @FXML
    void onSendClicked(MouseEvent event) {

        String mensaje = "yo: "+ this.textFieldMensaje.getText()+"\n";
        this.textAreamensajes.appendText(mensaje);

        Cliente c = new Cliente(6000, mensaje,"192.168.0.19");
        Thread  t = new Thread(c);
        t.start();
    }

    @Override
    public void update(Observable o, Object arg) {

        this.textAreamensajes.appendText((String) arg);
    }
}