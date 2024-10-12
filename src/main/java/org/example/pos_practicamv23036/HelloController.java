package org.example.pos_practicamv23036;

import org.example.pos_practicamv23036.Model.*;
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


        proveedorModel proveedor = new proveedorModel();
        ArrayList<proveedorModel> Data_proveedor = new ArrayList<proveedorModel>();
        Data_proveedor = proveedor.getAllproveedor();

        for (var item : Data_proveedor) {
            System.out.println(item);

        }
    }
}