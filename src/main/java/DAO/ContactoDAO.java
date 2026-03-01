package DAO;

import datos.Conexion;
import dominio.Contacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    //Métodos para utilizar objetos de clase Contacto
    public List<Contacto> obtenerContactos(){ //Método para listar registros
        List<Contacto> contactos = new ArrayList<>();
        String consulta = "SELECT id, nombre, telefono, email FROM contactos";
        try(    //try with resources
                Connection conexion = Conexion.obtenerConexion();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(consulta);
                ){
            while(rs.next()){
                Contacto contacto = new Contacto(
                     rs.getInt("id"),
                     rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                contactos.add(contacto);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión a base de datos: " + e.getMessage());
        }
        return contactos;
    }

    public void insertarContacto(Contacto contacto){ //Método para  ingresar registros
        String sql = "INSERT INTO contactos(nombre, telefono, email) VALUES(?,?,?)";
            try(
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ){
                ps.setString(1,contacto.getNombre());
                ps.setString(2, contacto.getTelefono());
                ps.setString(3, contacto.getEmail());
                ps.executeUpdate();
                System.out.println("Contacto agregado exitosamente.");
            } catch (Exception e) {
                System.out.println("Error al insertar registro: " + e.getMessage());
        }
    }
    public void actualizarContacto(Contacto contacto){ //Método para actualizar registros
        String sql = "UPDATE contactos SET nombre = ?, telefono = ?, email = ? WHERE id = ?";
        try(
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setString(1,contacto.getNombre());
            ps.setString(2, contacto.getTelefono());
            ps.setString(3, contacto.getEmail());
            ps.setInt(4, contacto.getId());
            int registros = ps.executeUpdate();
            if(registros > 0){
                System.out.println("Contacto actualizado correctamente.");
            }else{
                System.out.println("Contacto no actualizado: ID no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Excepción al actualizar contacto: " + e.getMessage());
        }
    }
    public void eliminarContacto(Contacto contacto){ //Método para actualizar registros
        String sql = "DELETE FROM contactos WHERE id = ?";
        try(
                Connection conexion = Conexion.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setInt(1, contacto.getId());
            int registros = ps.executeUpdate();
            if(registros > 0){
                System.out.println("Contacto eliminado correctamente.");
            }else{
                System.out.println("Contacto no eliminado: ID no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Excepción al eliminar contacto: " + e.getMessage());
        }
    }
}
