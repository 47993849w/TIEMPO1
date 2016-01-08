package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 47993849w on 26/11/15.
 */
public class Controller2 {

    public TextField mod;
    public TextField lug;
    public CheckMenuItem horaria;
    public CheckMenuItem diaria;
    public MenuButton menuB;

    public void metodo(ActionEvent actionEvent){

        if (actionEvent.getSource().equals(diaria))
            menuB.setText("Diaria");
        else if (actionEvent.getSource().equals(horaria))
            menuB.setText("Horaria");
    }

    public void gua () throws IOException {
        FileWriter fstream = new FileWriter("src/sample/preferencias");
        BufferedWriter out = new BufferedWriter(fstream);
        Recol recol = new Recol();

        try {
            recol.getA(lug.getText());
            out.write(lug.getText() + "," + menuB.getText());
            out.close();
            Controller.stage.close();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {

            out.write("Barcelona,Horaria");
            out.close();
            lug.setText("INCORRECTO");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
