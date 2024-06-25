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

    public boolean buscarPorIdEstudiante(Estudiante estudiante) {

        Connection conexion = conectar();
        String accion = "SELECT * FROM estudiante WHERE id_estudiante = ?";


        try {
            PreparedStatement ps = conexion.prepareStatement(accion);
            ps.setInt(1, estudiante.getIdEstudiante());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setCorreo(rs.getString("correo"));
                return true;
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
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {

        Connection conexion = conectar();
        String accion = "INSERT INTO estudiante(nombre,apellido,telefono,correo) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(accion);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getCorreo());
            ps.execute();
            return true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                conexion.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante) {

        Connection conexion = conectar();
        String accion = "UPDATE estudiante SET nombre=?, apellido=?, telefono=?, correo=? WHERE id_estudiante=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(accion);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getCorreo());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                conexion.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {

        Connection conexion = conectar();
        String accion = "DELETE FROM estudiante WHERE id_estudiante = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(accion);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                conexion.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {

        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Estudiante estudianteEliminado = new Estudiante(5);
        boolean eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminado);

        if (eliminado) {

            System.out.println("Estudiante eliminado");

        } else {

            System.out.println("Estudiante no eliminado");
        }




/*        Estudiante estudianteModificado = new Estudiante(2,"Manuela", "Correa ","1234567","sapos@gmail.com" );
        boolean modificado = estudianteDAO.modificarEstudiante(estudianteModificado);

        if (modificado) {

            System.out.println("Estudiante Modificado Exitosamente");

        } else {

            System.out.println("Estudiante No Modificado");
        }*/


/*        Estudiante nuevoEstudiante = new Estudiante("Alejandro", "Correa", "3006662695", "alejoariascorrea@gmail.com");
        boolean agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);

        if (agregado) {

            System.out.println("Estudiante Agregado Correctamente " + nuevoEstudiante);

        } else {
            System.out.println("Estudiante No Agregado");
        }*/
        ArrayList<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        System.out.println("Listado De Estudiantes");
        estudiantes.forEach(System.out::println);

/*        Estudiante estudiante = new Estudiante(1);
        boolean encontrado = estudianteDAO.buscarPorIdEstudiante(estudiante);

        if (encontrado) {

            System.out.println("Estudiante encontrado " + estudiante);

        } else {

            System.out.println("Estudiante No Encontrado");
        }*/


    }
}
