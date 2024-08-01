package aca.Vista;

import aca.Datos.EstudianteDAO;
import aca.Dominio.Estudiante;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Scanner leer = new Scanner(System.in);
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    int idEstudiante;
    boolean confirmacion;
    String nombre, apellido, telefono, correo;

    public void menuPrincipal() {

        int opc;

        System.out.println("""
                *** Menu Principal ***
                1).Mostrar Estudiantes
                2).Agregar Estudiante
                3).Buscar Estudiante
                4).Modificar Estudiante
                5).Eliminar Estudiante
                6).Salir
                """);
        System.out.print("Ingrese Una Opcion: ");
        opc = leer.nextInt();
        leer.nextLine();
        System.out.println(" ");

        switch (opc) {
            case 1:
                menuMostrarEstudiantes(estudiantes);
                System.out.println(" ");
                menuPrincipal();
                break;

            case 2:
                menuAgregarEstudiante();
                System.out.println(" ");
                menuPrincipal();
                break;

            case 3:
                menuBuscarEstudiante();
                System.out.println(" ");
                menuPrincipal();
                break;

            case 4:
                menuModificarEstudiante();
                System.out.println(" ");
                menuPrincipal();
                break;

            case 5:
                menuEliminarEstudiante();
                System.out.println(" ");
                menuPrincipal();
                break;

            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Opcion No Valida");
                System.out.println(" ");
                menuPrincipal();
        }
    }

    public void menuMostrarEstudiantes(ArrayList<Estudiante> estudiantes) {

        estudiantes = estudianteDAO.listarEstudiantes();
        System.out.println("*** Listado De Estudiantes ***");
        System.out.println(" ");
        estudiantes.forEach(System.out::println);
    }

    public void menuAgregarEstudiante() {

        System.out.print("Ingrese Nombre: ");
        nombre = leer.nextLine();
        System.out.print("Ingrese Apellido: ");
        apellido = leer.nextLine();
        System.out.print("Ingrese Telefono: ");
        telefono = leer.nextLine();
        System.out.print("Ingrese Correo: ");
        correo = leer.nextLine();

        Estudiante estudianteNuevo = new Estudiante(nombre, apellido, telefono, correo);
        confirmacion = estudianteDAO.agregarEstudiante(estudianteNuevo);

        if (confirmacion) {

            System.out.println("Estudiante Agregado Correctamente");

        } else {

            System.out.println("Estudiante No Agregado");
        }
    }

    public void menuBuscarEstudiante() {

        System.out.print("Ingrese El ID: ");
        idEstudiante = leer.nextInt();

        Estudiante estudianteBuscado = new Estudiante(idEstudiante);
        confirmacion = estudianteDAO.buscarPorIdEstudiante(estudianteBuscado);

        if (confirmacion) {

            System.out.println("Estudiante Encontrado" + estudianteBuscado);

        } else {

            System.out.println("Estudiante No Encontrado");
        }
    }

    public void menuModificarEstudiante() {

        boolean existe;

        System.out.print("Ingrese El ID: ");
        idEstudiante = leer.nextInt();
        leer.nextLine();

        Estudiante existente = new Estudiante(idEstudiante);
        existe = estudianteDAO.buscarPorIdEstudiante(existente);

        System.out.println(" ");

        if (existe) {

            System.out.println("Estudiante En La Base, Ingrese Sus Datos");

            System.out.print("Ingrese Nombre: ");
            nombre = leer.nextLine();
            System.out.print("Ingrese Apellido: ");
            apellido = leer.nextLine();
            System.out.print("Ingrese Telefono: ");
            telefono = leer.nextLine();
            System.out.print("Ingrese Correo: ");
            correo = leer.nextLine();

            Estudiante estudianteModificado = new Estudiante(idEstudiante, nombre, apellido, telefono, correo);
            confirmacion = estudianteDAO.modificarEstudiante(estudianteModificado);

            if (confirmacion) {

                System.out.println("Estudiante Modificado Correctamente");

            } else {

                System.out.println("Estudiante No Modificado");
            }

        } else {

            System.out.println("El Estudiante No Existe");
        }
    }

    public void menuEliminarEstudiante() {

        boolean existe;

        System.out.print("Ingrese El ID: ");
        idEstudiante = leer.nextInt();

        Estudiante estudianteEliminado = new Estudiante(idEstudiante);
        existe = estudianteDAO.buscarPorIdEstudiante(estudianteEliminado);

        if (existe) {

            confirmacion = estudianteDAO.eliminarEstudiante(estudianteEliminado);

            if (confirmacion) {

                System.out.println("Estudiante Eliminado Correctamente");

            } else {

                System.out.println("Estudiante No Eliminado");
            }

        } else {

            System.out.println("El Estudiante No Existe");
        }
    }
}
