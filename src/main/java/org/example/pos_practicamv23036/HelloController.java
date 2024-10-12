package org.example.pos_practicamv23036;

import org.example.pos_practicamv23036.Model.categoriaModel;
import org.example.pos_practicamv23036.conexion.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected  void initialize()
    {
        categoriaModel categoria = new categoriaModel();
        ArrayList<categoriaModel> data_categoria = new ArrayList<categoriaModel>();
        data_categoria = categoria.getAllCategoria();

        for (categoriaModel item_categoria : data_categoria) {
            System.out.println(item_categoria);

        }

        categoria.setNombrecategoria("Teclado TGB");
     //   int i = categoria.saveCategoria();
      //  System.out.println(i);
    }
}