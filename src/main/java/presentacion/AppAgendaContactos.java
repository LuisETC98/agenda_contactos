package presentacion;

import DAO.ContactoDAO;
import dominio.Contacto;
import validacion.Validaciones;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppAgendaContactos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactoDAO dao = new ContactoDAO();
        System.out.println("***¡Bienvenido al programa!***");
        boolean salir = false;

        while(!salir){
            try{
                System.out.println("""
               --Menú de Agenda de Contactos--
                1.Listar contactos
                2.Agregar contacto
                3.Modificar contacto
                4.Eliminar contacto
                5.Salir
                Elije una opción del menú ingresando su número: """);
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1 -> {
                        List<Contacto> lista = dao.obtenerContactos();
                        lista.forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = sc.nextLine();

                        // Inicializamos las variables para que el compilador esté tranquilo
                        String email = "";
                        boolean esValido = false;

                        do {
                            System.out.print("Email: ");
                            email = sc.nextLine();

                            esValido = Validaciones.emailValidacion(email);

                            if (!esValido) {
                                System.out.println("Error: Formato de email inválido (debe contener '@').");
                            }
                        } while (!esValido);

                        dao.insertarContacto(new Contacto(nombre, telefono, email));
                    }
                    case 3 -> {
                        System.out.print("ID del contacto a modificar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Nuevo teléfono: ");
                        String telefono = sc.nextLine();
                        System.out.print("Nuevo email: ");
                        String email = sc.nextLine();
                        dao.actualizarContacto(new Contacto(id, nombre, telefono, email));
                    }
                    case 4 -> {
                        System.out.print("ID del contacto a eliminar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        dao.eliminarContacto(new Contacto(id));

                    }
                    case 5 -> {
                        System.out.println("Saliendo del programa...hasta pronto.");
                        salir = true;
                    }
                    default ->
                            System.out.println("Número incorrecto. Vuelve a intentarlo.");
                    }
            }catch(InputMismatchException e){
                System.out.println("Ingresa un número del menú.");
                sc.nextLine();
            }catch (NumberFormatException e) {
                // Agregamos este catch para proteger los parseInt de los casos 3 y 4
                System.out.println("Error: El ID debe ser un número válido.");
            }

        }
       sc.close();
    }
}
