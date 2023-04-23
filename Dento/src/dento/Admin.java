package dento;

import javax.swing.JOptionPane;

public class Admin {

    //Variables para correr el meno
    boolean salirDelMenu = false;
    String opcion = "";

    // Strings para los menus
    String mensajeMenuPrincipal = "****************************************\n  /// Bienvenido al Menu de Dento ///\n****************************************\n\n1. Clientes \n2. Doctores \n3. Servicios \n4. Facturacion \n5. Salir \n ";
    String mensajeMenuClientes = "\n****************************************\n  /// Menu Clientes Dento ///\n****************************************\n \n1. Agregar un cliente \n2. Eliminar cliente \n3. Visualizar clientes \n4. Eliminar todos los clientes \n5. Buscar cliente \n6. Regresar al menu principal \n ";
    String mensajeMenuDoctor = " \n****************************************\n  /// Menu Doctor Dento ///\n****************************************\n \n1. Agregar un doctor \n2. Eliminar doctor \n3. Visualizar doctor \n4. Eliminar todos los doctores \n5. Buscar doctor \n6. Regresar al menu principal \n ";
    String mensajeMenuServicios = " \n****************************************\n  /// Menu de Servicios Dento ///\n****************************************\n \n1. Agregar el tipo de servicio \n2. Eliminar servicio \n3. Visualizar servicios \n4. Cantidad de servicios agregados \n5. Buscar servicio\n6. Regresar al menu principal \n ";
    String mensajeMenuFactura = " \n****************************************\n  /// Menu de Facturacion Dento ///\n****************************************\n \n1. Nueva Factura \n2. Ver la facturacion de los clientes por ID\n3. Listar Facturas\n4. Borrar Factura\n5. Regresar al menu principal \n ";

    // mensaje de error
    String mensajeDeError = "*** Por favor ingresar solamente números ***";

    // inicio de los objetos
    Cliente clienteLlamar = new Cliente();
    Doctor doctorLlamar = new Doctor();
    static ServicioCola servicioCola = new ServicioCola();
    static FacturaLista facturaLista = new FacturaLista();

    //Precarga
    public void precarga() {
        clienteLlamar.pilaCli.add(
                new Cliente(0, "Antonio", 1234, 1234, "antonio@alvarez", "NA", "Ok"));
        doctorLlamar.pilaDoc.add(
                new Doctor(0, "Anderson", 1234, 1234, "Anderson@Roa"));
        servicioCola.precarga(0, "Servicio", "Descripcion", 100, 0.13);
    }

    // do whiles con switch para correr menu
    public void menu() {

        do {
            opcion = JOptionPane.showInputDialog(mensajeMenuPrincipal);

            switch (opcion) {
                case "1":
                    do {
                        opcion = JOptionPane.showInputDialog(mensajeMenuClientes);

                        switch (opcion) {
                            case "1":
                                clienteLlamar.insertar();
                                break;
                            case "2":
                                clienteLlamar.eliminarUltimo();
                                break;
                            case "3":
                                clienteLlamar.visualizarPila();
                                break;
                            case "4":
                                clienteLlamar.vaciarPila();
                                break;
                            case "5":
                                clienteLlamar.buscarelemento();
                                break;
                            case "6":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, mensajeDeError);
                        }
                    } while (Integer.parseInt(opcion) != 6);
                    break;

                case "2":
                    do {
                        opcion = JOptionPane.showInputDialog(mensajeMenuDoctor);
                        switch (opcion) {
                            case "1":
                                doctorLlamar.insertar();
                                break;
                            case "2":
                                doctorLlamar.eliminarUltimo();
                                break;
                            case "3":
                                doctorLlamar.visualizarPila();
                                break;
                            case "4":
                                doctorLlamar.vaciarPila();
                                break;
                            case "5":
                                doctorLlamar.buscarelemento();
                                break;
                            case "6":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, mensajeDeError);
                        }
                    } while (Integer.parseInt(opcion) != 6);
                    break;

                case "3":
                    do {
                        opcion = JOptionPane.showInputDialog(mensajeMenuServicios);
                        switch (opcion) {
                            case "1":
                                servicioCola.insertar();
                                break;
                            case "2":
                                servicioCola.extraer();
                                break;
                            case "3":
                                servicioCola.imprimir();
                                break;
                            case "4":
                                JOptionPane.showMessageDialog(null, "La cantidad de servicios son: " + servicioCola.cantidad());
                                break;
                            case "5":
                                servicioCola.buscar();
                                break;
                            case "6":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, mensajeDeError);
                        }
                    } while (Integer.parseInt(opcion) != 6);
                    break;
                case "4":
                    do {
                        opcion = JOptionPane.showInputDialog(mensajeMenuFactura);
                        switch (opcion) {
                            case "1":
                                facturaLista.insertar();
                                break;
                            case "2":
                                facturaLista.printFacturaPorID();
                                break;
                            case "3":
                                facturaLista.imprimir();
                                break;
                            case "4":
                                facturaLista.borrar();
                                break;
                            case "5":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, mensajeDeError);
                        }
                    } while (Integer.parseInt(opcion) != 5);
                    break;
                case "5":
                    salirDelMenu = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, mensajeDeError);
            }
        } while (!salirDelMenu);
    }
}
