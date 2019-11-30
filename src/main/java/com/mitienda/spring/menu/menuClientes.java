package com.mitienda.spring.menu;

import com.mitienda.spring.controllers.ClienteController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitienda.spring.models.Clientes;

public class menuClientes implements crud {

    List<Clientes> clientesLista = new ArrayList<>();
    ClienteController ctrl = ClienteController.getInstance();
    public static Scanner keyboard = new Scanner(System.in);

    Clientes cli = new Clientes();

    public menuClientes() {

    }

    public static menuClientes menu = new menuClientes();

    public static void mostrarClientes() {

        boolean salida = true;

        int opcion;
        System.out.print("Elige una opcion\n");

        System.out.print("1 para Ver\n");
        System.out.print("2 para Crear\n");
        System.out.print("3 para Borrar\n");
        System.out.print("4 para Modificar\n");
        System.out.print("5 para Volver al menu Principal\n");

        do {

            opcion = Integer.parseInt(keyboard.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido ver");
                    menu.ver();
                    break;
                case 2:
                    System.out.println("Has elegido crear");
                    menu.crear();
                    break;
                case 3:
                    System.out.println("Has elegido Borrar");
                    menu.borrar();
                    break;
                case 4:
                    System.out.println("Has elegido modificar");
                    menu.modificar();
                    break;
                case 5:
                    System.out.println("Has elegido volver al Menu Principal");
                    menuPrincipal.iniciaMenu();
                    break;
                default:
                    break;
            }

        } while (salida);

        System.out.print("Gracias por usar la apliacion");

    }

    @Override
    public void ver() {

        clientesLista = ctrl.list();

        for (int i = 0; i < clientesLista.size(); i++) {

            System.out.println(i + " = " + clientesLista.get(i));

        }
    }

    @Override
    public void modificar() {

        String eleccion;

        System.out.println("Dime la posicion del Cliente que quieres Modificar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);
        ctrl.findById(opcion);
        
        System.out.println("Dime el nombre del nuevo Cliente");
        String nuevoCliNombre = keyboard.nextLine();
        cli.setNombre(nuevoCliNombre);
        System.out.println("Dime el DNI del nuevo Cliente");
        String nuevoCliDNi = keyboard.nextLine();
        cli.setDni(nuevoCliDNi);
        System.out.println("Dime la direccion del nuevo Cliente");
        String nuevoCliDireccion = keyboard.nextLine();
        cli.setDireccion(nuevoCliDireccion);
        System.out.println("Dime el Telefono del nuevo Cliente");
        String nuevoCliTelefonoString = keyboard.nextLine();
        cli.setTelefono(nuevoCliTelefonoString);
        System.out.println("Dime el correo del nuevo Cliente");
        String nuevoCorreo = keyboard.nextLine();
        cli.setEmail(nuevoCorreo);

        ctrl.save(cli);

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la ID del Cliente que quieres Borrar");
        eleccion = keyboard.nextLine();
        Long opcion = Long.parseLong(eleccion);

        ctrl.deleteById(opcion);

    }

    @Override
    public void crear() {

        keyboard.reset();
        System.out.println("Dime el nombre del nuevo Cliente");

        String nuevoCliNombre = keyboard.nextLine();
        cli.setNombre(nuevoCliNombre);
        System.out.println("Dime el DNI del nuevo Cliente");
        String nuevoCliDNi = keyboard.nextLine();
        cli.setDni(nuevoCliDNi);
        System.out.println("Dime la direccion del nuevo Cliente");
        String nuevoCliDireccion = keyboard.nextLine();
        cli.setDireccion(nuevoCliDireccion);
        System.out.println("Dime el Telefono del nuevo Cliente");
        String nuevoCliTelefonoString = keyboard.nextLine();
        cli.setTelefono(nuevoCliTelefonoString);
        System.out.println("Dime el correo del nuevo Cliente");
        String nuevoCorreo = keyboard.nextLine();
        cli.setEmail(nuevoCorreo);

        ctrl.save(cli);
        System.out.println("Se ha insertado el nuevo cliente");

    }
}
