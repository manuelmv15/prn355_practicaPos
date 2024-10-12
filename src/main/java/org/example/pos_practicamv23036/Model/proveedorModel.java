package org.example.pos_practicamv23036.Model;

import org.example.pos_practicamv23036.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class proveedorModel {

    int idporveedror;
    String nombreproveedor;
    String telefono;
    String correo;

    public proveedorModel() {
    }

    public proveedorModel(int idporveedror, String nombreproveedor, String telefono, String correo) {
        this.idporveedror = idporveedror;
        this.nombreproveedor = nombreproveedor;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdporveedror() {
        return idporveedror;
    }

    public void setIdporveedror(int idporveedror) {
        this.idporveedror = idporveedror;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<proveedorModel> getAllproveedor() {
        ArrayList<proveedorModel> Lis_proveedores = new ArrayList<proveedorModel>();

        try {
            Connection connection = Conexion.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tbl_proveedores");

            while (resultSet.next()) {

                proveedorModel proveedor = new proveedorModel();
                proveedor.setIdporveedror(resultSet.getInt("idproveedor"));
                proveedor.setNombreproveedor(resultSet.getString("nombreproveedor"));
                proveedor.setTelefono(resultSet.getString("telefono"));
                proveedor.setCorreo(resultSet.getString("correo"));

                Lis_proveedores.add(proveedor);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Lis_proveedores;

    }

    public int saveProveedor() {
        try {
            Connection connection = Conexion.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbl_proveedores (nombreproveedor,telefono,correo)  values (?,?,?);");
            preparedStatement.setString(1, this.nombreproveedor);
            preparedStatement.setString(2, this.telefono);
            preparedStatement.setString(3, this.correo);

            int retur = preparedStatement.executeUpdate();
            return retur;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int editProveedor() {
        try {
            Connection connection = Conexion.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tbl_proveedores SET nombreproveedor = ? , telefono = ?, correo = ? WHERE idproveedor =?;");
            preparedStatement.setString(1, this.nombreproveedor);
            preparedStatement.setString(2, this.telefono);
            preparedStatement.setString(3, this.correo);
            preparedStatement.setInt(4, this.idporveedror);

            int into = preparedStatement.executeUpdate();
            return into;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int DELATEproveedor() {
        try {
            Connection connection = Conexion.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELATE tbl_proveedores WHRE idporveedror =?");

            preparedStatement.setInt(1, this.idporveedror);


            int into = preparedStatement.executeUpdate();
            return into;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "proveedorModel{" +
                "idporveedror=" + idporveedror +
                ", nombreproveedor='" + nombreproveedor + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
