package aca.Datos;

import aca.Dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static aca.conexion.Conexion.conectar;

public class EstudianteDAO {

    public ArrayList<Estudiante> listarEstudiantes() {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Connection conexion = conectar();
        String accion = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            PreparedStatement ps = conexion.prepareStatement(accion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Estudiante estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiantes.add(estudiante);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                conexion.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return estudiantes;
    }

    public static void main(String[] args) {

        EstudianteDAO estudianteDAO = new EstudianteDAO();
        ArrayList<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        System.out.println("Listado De Estudiantes");
        estudiantes.forEach(System.out::println);


    }
}
