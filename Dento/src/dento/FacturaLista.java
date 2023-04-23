package dento;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FacturaLista {

    //variables
    private FacturaListaNodo raiz, fondo;
    Admin admin = new Admin();

    //constructores
    Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");

    public FacturaLista() {
        raiz = null;
    }

    //insertar
    void insertar() {

        int id = 0;
        try {
            id = returnFactura(cantidad() - 1).getId() + 1;
        } catch (Exception e) {
            id = 0;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha: ");

        Cliente cliente = new Cliente();

        //logica para solo poner numeros
        String idCliente = "";
        do {
            cliente.buscarelemento();
            idCliente = JOptionPane.showInputDialog("Ingrese el ID del Cliente: ");

            if (p.matcher(idCliente).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(idCliente).find());

        Doctor doctor = new Doctor();

        //logica para solo poner numeros
        String idDoctor = "";
        do {
            doctor.buscarelemento();
            idDoctor = JOptionPane.showInputDialog("Ingrese el ID del Doctor: ");

            if (p.matcher(idDoctor).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(idDoctor).find());

        //logica para solo poner numeros
        String idServicio = "";
        do {
            admin.servicioCola.buscar();

            idServicio = JOptionPane.showInputDialog("Ingrese el ID del Servicio: ");

            if (p.matcher(idServicio).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(idServicio).find());

        FacturaListaNodo nuevo = new FacturaListaNodo();
        nuevo.info = new Factura(id, fecha, Integer.parseInt(idCliente), Integer.parseInt(idDoctor), Integer.parseInt(idServicio));
        nuevo.sig = null;

        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }

        Servicio servicio = admin.servicioCola.returnService(Integer.parseInt(idServicio));

        printFactura(fecha, Integer.parseInt(idCliente), Integer.parseInt(idDoctor), servicio);

    }

    //imprime facturas
    public void printFactura(String fecha, int idCliente, int idDoctor, Servicio servicio) {

        Cliente cliente = new Cliente();
        Doctor doctor = new Doctor();

        String nomCli = cliente.pilaCli.get(idCliente).getNombre();
        int cedulaCli = cliente.pilaCli.get(idCliente).cedula;
        String emailCli = cliente.pilaCli.get(idCliente).correo;

        String nomDoc = doctor.pilaDoc.get(idDoctor).getNombres();
        String emailDoc = doctor.pilaDoc.get(idDoctor).getNombres();

        String serv = servicio.getServicio();
        double costServ = servicio.getCosto();
        double impuestoServ = servicio.getImpuesto();

        JOptionPane.showMessageDialog(null, " \n "
                + fecha + "   Factura Dento" + "\n La mejor clinica"
                + "\n "
                + "\nNombre: " + nomCli + " Cedula: " + cedulaCli + " Correo: " + emailCli
                + "\n\nDoctor: " + nomDoc + " Correo: " + emailDoc
                + "\n\n "
                + "\n\nServicio: " + serv
                + "\n\nCosto...................... " + costServ
                + "\nImpuesto................... " + (impuestoServ * 100) + "%"
                + "\n\n\nTotal.................... " + (costServ * (1 + impuestoServ))
        );
    }

    // imprime por id de factura
    public void printFacturaPorID() {

        //logica para solo poner numeros
        String idFactura = "";
        do {
            idFactura = JOptionPane.showInputDialog("Ingrese el numero de factura: ");

            if (p.matcher(idFactura).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(idFactura).find());

        Factura fact = returnFactura(Integer.parseInt(idFactura));

        int idCliente = fact.getIdCliente();
        int idDoctor = fact.getIdDoctor();
        int idServicio = fact.getIdServicio();
        String fecha = fact.getFecha();

        Servicio servicio = admin.servicioCola.returnService(idServicio);

        printFactura(fecha, idCliente, idDoctor, servicio);

    }

    //retorna un objeto factura por id de factura
    public Factura returnFactura(int idFactura) {
        for (int i = 0; i <= cantidad(); i++) {
            if (idFactura == i) {
                return raiz.info;
            } else {
                raiz = raiz.sig;
            }
        }
        return null;
    }

    //borra la factura que uno le indique
    public void borrar() {
        //logica para solo poner numeros
        String posString = "";
        do {
            imprimir();
            posString = JOptionPane.showInputDialog("Ingrese la posicion de la factura que desea borrar: ");
            if (p.matcher(posString).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(posString).find());

        int pos = Integer.parseInt(posString);

        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
            } else {
                FacturaListaNodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                FacturaListaNodo prox = reco.sig;
                reco.sig = prox.sig;
            }
        }
    }

    //retorna un entero de cantidad
    public int cantidad() {
        int cant = 0;
        FacturaListaNodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    // retorna un boolean de vacio
    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    // imprime toda la lista
    public void imprimir() {

        Cliente cliente = new Cliente();
        Doctor doctor = new Doctor();
        String mensaje = "Facturas: ";
        for (int i = 0; i < cantidad(); i++) {
            int idCliente = returnFactura(i).getIdCliente();
            int idDoctor = returnFactura(i).getIdDoctor();
            String fecha = returnFactura(i).getFecha();

            String nomCli = cliente.pilaCli.get(idCliente).getNombre();
            int cedulaCli = cliente.pilaCli.get(idCliente).cedula;
            String emailCli = cliente.pilaCli.get(idCliente).correo;

            String nomDoc = doctor.pilaDoc.get(idDoctor).getNombres();
            String emailDoc = doctor.pilaDoc.get(idDoctor).getNombres();

            Servicio ser = admin.servicioCola.returnService(i);

            String serv = ser.getServicio();
            double costServ = ser.getCosto();
            double impuestoServ = ser.getImpuesto();

            mensaje = mensaje + "Fecha: " + fecha + " Cliente : " + nomCli + " ID Cliente: " + cedulaCli + " Correo Cliente: " + emailCli
                    + "Doctor: " + nomDoc + " Correo Doctor: " + emailDoc + "Servicio: " + serv
                    + "Costo: " + costServ + "Impuesto: " + (impuestoServ * 100) + "%" + "Total: " + (costServ * (1 + impuestoServ));
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
