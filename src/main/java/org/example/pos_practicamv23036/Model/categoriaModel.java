package org.example.pos_practicamv23036.Model;

import org.example.pos_practicamv23036.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class categoriaModel {

    private int idcategoria;
    private String nombrecategoria;

    public categoriaModel() {
    }

    public categoriaModel(int idCategoria, String nombreCategoria) {
        this.idcategoria = idCategoria;
        this.nombrecategoria = nombreCategoria;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public ArrayList<categoriaModel> getAllCategoria() {
        ArrayList<categoriaModel> list_categoria = new ArrayList<categoriaModel>();

        try {
            Connection connection = Conexion.connection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from tbl_categorias");
            while (resultSet.next()) {
                categoriaModel categoriaModel = new categoriaModel();
                categoriaModel.setIdcategoria(resultSet.getInt("idcategoria"));
                categoriaModel.setNombrecategoria(resultSet.getString("nombrecategoria"));

                list_categoria.add(categoriaModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list_categoria;
    }

    public int saveCategoria() {
        Connection connection = Conexion.connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_categorias (nombrecategoria) values (?)");
            preparedStatement.setString(1, this.nombrecategoria);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            int retur = preparedStatement.executeUpdate();
            return retur;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int editCategoria() {
        Connection connection = Conexion.connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE tbl_categorias SET nombrecategoria = ? WHERE idcategoria = ?");
            preparedStatement.setInt(2, this.idcategoria);
            preparedStatement.setString(1, this.nombrecategoria);

            int retorno = preparedStatement.executeUpdate();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int DELATEcategoria() {
        Connection connection = Conexion.connection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE tbl_categorias WHERE idcategoria = ?");
            preparedStatement.setInt(1, this.idcategoria);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public categoriaModel getcategoriaId() {
        Connection connection = Conexion.connection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_categorias WHERE idcategoria =?");
            preparedStatement.setInt(1, this.idcategoria);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new categoriaModel(
                        resultSet.getInt("idcategoria"),
                        resultSet.getString("nombrecategoria")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String toString() {
        return "categoriaModel{" +
                "idcategoria=" + idcategoria +
                ", nombrecategoria='" + nombrecategoria + '\'' +
                '}';
    }
}
