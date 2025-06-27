package com.camila.crud;
import com.camila.crud.model.Persona;
import com.camila.crud.persistence.PersonaJpaController;
import com.camila.crud.service.GestorPersonasImplements;
import com.camila.crud.service.IGestorPersonas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IGestorPersonas gestor = new GestorPersonasImplements();
        Scanner in = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("\n -- MENU DE GESTION -- ");
            System.out.println("1. Crear nuevo usuario ");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Listar todos los usuarios");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = in.nextLine();

            switch (opcion) {
                case "1": gestor.CrearPersona();
                    break;
                case "2": gestor.Buscar();
                    break;
                case "3": gestor.Eliminar();
                    break;
                case "4": gestor.ActualizarDatos();
                    break;
                case "5": gestor.ListarPersonas();
                    break;
                case "0":
                    System.out.println("Hasta pronto! ");
                    break;
                default:
                    System.out.println("Opcion no valida, intenta nuevamente ");
                    break;
            }
        }
        while (!opcion.equals("0"));

    }
}
