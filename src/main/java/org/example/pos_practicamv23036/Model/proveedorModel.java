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

    public ArrayList<proveedorModel> getAllproveedor()
    {
        ArrayList<proveedorModel> Lis_proveedores = new ArrayList<proveedorModel>();

        try
        {
            Connection connection = Conexion.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tbl_proveedores");

            while (resultSet.next()){

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
        return  Lis_proveedores;

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
