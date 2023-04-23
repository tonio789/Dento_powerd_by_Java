package dento;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ServicioCola {
    
    //variables
    public static ServicioColaNodo raiz, fondo;
    Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");

    //constructor
    public ServicioCola() {
        raiz = null;
        fondo = null;
    }

    public void precarga(int id, String servicio, String descripcion, double costo, double tax) {
        ServicioColaNodo nuevo;
        nuevo = new ServicioColaNodo();
        Servicio elemento = new Servicio(id, servicio, descripcion, costo, tax);

        nuevo.info = elemento;
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }
    
    //inserta nuevo servicio
    public void insertar() {
        ServicioColaNodo nuevo;
        nuevo = new ServicioColaNodo();

        int id = 0;
        try {
            id = returnService(cantidad() - 1).getId() + 1;
        } catch (Exception e) {
            id = 0;
        }

        String servicio = JOptionPane.showInputDialog("Ingrese el Servicio: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la Descripcion: ");

        //logica para solo poner numeros
        String costo = "";
        do {
            costo = JOptionPane.showInputDialog("Ingrese el Costo: ");

            if (p.matcher(costo).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }

        } while (p.matcher(costo).find());

        //logica para solo poner numeros
        String impuesto = "";
        do {
            impuesto = JOptionPane.showInputDialog("Ingrese el Impuesto ej->(0.13) : ");
            if (p.matcher(impuesto).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }
        } while (p.matcher(impuesto).find());

        Servicio elemento = new Servicio(id, servicio, descripcion, Double.parseDouble(costo), Double.parseDouble(impuesto));

        nuevo.info = elemento;
        nuevo.sig = null;

        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    //boolean de vacia
    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    // devuelve un servicio por id de servicio
    public Servicio returnService(int idServ) {

        ServicioColaNodo reco = raiz;
        for (int i = 0; i < cantidad(); i++) {
            if (idServ == i) {
                return reco.info;
            } else {
                reco = reco.sig;
            }
        }
        return null;
    }

    // busca por nombre de servicio
    public void buscar() {
        ServicioColaNodo reco = raiz;

        String elemento = JOptionPane.showInputDialog("Ingrese el servicio que desea buscar:");

        String mensaje = "Servicios";

        for (int i = 0; i < cantidad(); i++) {
            if (reco.info.getServicio().toLowerCase().contains(elemento.toLowerCase())) {
                mensaje = mensaje + "\n " + reco.info.getId() + " - " + reco.info.getServicio();
                reco = reco.sig;
            } else {
                reco = reco.sig;
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // saca el primer elemento
    public Servicio extraer() {
        if (!vacia()) {
            Servicio informacion = raiz.info;
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else {
            return null;
        }
    }

    // imprime toda la lista
    public void imprimir() {

        ServicioColaNodo reco = raiz;

        String mensaje = "Listado de todos los elementos de la cola\n";
        while (reco != null) {
            int id = reco.info.getId();
            String Serv = reco.info.getServicio();
            String Desc = reco.info.getDescripcion();
            double Cost = reco.info.getCosto();
            double Impu = reco.info.getImpuesto();

            mensaje = mensaje + "\nID: " + id + " - Servicio: " + Serv + " - Descripcion: " + Desc + " - Costo: " + Cost + " - Impuesto: " + Impu;
            reco = reco.sig;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // retorna un entero de cantidad
    public int cantidad() {
        int cant = 0;
        ServicioColaNodo reco = raiz;
        while (reco != null) {
            cant++;
            reco = reco.sig;
        }
        return cant;
    }

}
