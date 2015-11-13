package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.text.Element;
import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Controller {
    @FXML
    public TextField introDias;
    public TextField introCiudad;

    public ListView listaTiempo;
    //http://java-buddy.blogspot.com.es/2013/05/implement-javafx-listview-for-custom.html
    List<Parametres> myList;


    private void prepareMyList(){
        String ciudad = introCiudad.getText();
        int dias = Integer.parseInt(introCiudad.getText());
        myList = new ArrayList<>();
        myList.add(new Parametres(ciudad, dias));
    }

    public void refresh(ActionEvent actionEvent) {
        prepareMyList();

    }
}
