package com.camila.crud.service;
import com.camila.crud.model.Persona;
import com.camila.crud.persistence.PersonaJpaController;
import java.util.List;
import java.util.Scanner;

public class GestorPersonasImplements extends Persona implements IGestorPersonas {
    PersonaJpaController controller=new PersonaJpaController();
    Scanner in = new Scanner(System.in);


    @Override
    public void CrearPersona() {
        System.out.println("--Crear nuevo usuario--");
        System.out.println("Por favor ingrese los siguientes datos: ");
        System.out.println("Nombre: ");
        String name = in.nextLine();
        System.out.println("Edad: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.println("Genero:¿ M o F ?");
        char gender= in.next().charAt(0);
        in.nextLine();
        System.out.println("Celular: ");
        String cell = in.nextLine();
        Persona nuevaPersona = new Persona(name,age,gender,cell);
        controller.create(nuevaPersona);
        System.out.println(" Usuario creado exitosamente!\n su ID es: " + nuevaPersona.getId());

    }

    @Override
    public void ListarPersonas() {
        System.out.println("-- Usuarios --");
        List<Persona> personas =controller.findPersonas();
        if (personas.isEmpty()){
            System.out.println("No hay personas en la lista");
        }
        else {
            for (Persona perso:personas) {
                System.out.println(perso);
            }
        }

    }
    @Override
    public void Buscar () {
        System.out.println("Ingrese el id a buscar");
        int idBuscar = in.nextInt();
        in.nextLine();
        Persona perso = controller.findPersona(idBuscar);

            if (perso != null ){
                System.out.println("Usuario encontrado: ");
                System.out.println(perso);
        }
            else System.out.println("No se encontro a una persona con ese ID");
    }

    @Override
    public void Eliminar() {
        System.out.println("-- Eliminar usuario --");
        System.out.println("Ingrese el ID de la persona a eliminar");
        int idEliminar= in.nextInt();
        in.nextLine();
        try{
            controller.destroy(idEliminar);
            System.out.println("Se ha eliminado a la persona correctamente");
        }
        catch (Exception e) {
            System.out.println("No se encontro una persona con ese ID" +e.getMessage());
        }

    }

    @Override
    public void ActualizarDatos() {
        System.out.println("--Actualizar datos --");
        System.out.println("Ingrese el ID de la persona a actualizar");
        int idActualizar= in.nextInt();
        in.nextLine();

        Persona perso = controller.findPersona(idActualizar);
        if (perso != null){
            System.out.println("Seleccione el dato a modifcar\n Nombre,Edad,Genero,Celular\n");
            String campo =in.nextLine().toLowerCase();

            switch (campo){

                case "nombre":
                    System.out.println("Ingrese el nuevo nombre");
                    String nuevoNombre = in.nextLine();
                    perso.setName(nuevoNombre);
                    break;

                case "edad":
                    System.out.println("Ingrese la nueva edad");
                    int nuevaEdad =in.nextInt();
                    in.nextLine();
                    perso.setAge(nuevaEdad);
                    break;

                case  "genero" :
                    System.out.println("Ingrese el nuevo genero (M/F)");
                    char nuevoGenero =in.next().charAt(0);
                    in.nextLine();
                    perso.setGenre(nuevoGenero);
                    break;

                case "celular":
                    System.out.println("Ingrese su nuevo numero de celular");
                    String nuevoCelular = in.nextLine();
                    perso.setCell(nuevoCelular);
                    break;

                default:
                    System.out.println("Campo no valido");
                    return;
            }
           controller.edit(perso);
            System.out.println("Los datos se han actualizado correctamente ");

        }
        else {
            System.out.println("No se ha encontrado usuario con ese ID ");
        }

    }
}