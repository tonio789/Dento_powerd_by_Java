package dento;

import java.util.Stack;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Cliente {

    //variables de cliente
    int id;
    String nombre;
    int cedula;
    int telefono;
    String correo;
    String alergias;
    String estadoDental;

    // parametro pattern para saber si estoy insertando solo numeros
    Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");

    // constructores
    public Cliente() {
    }

    public Cliente(int id, String nombre, int cedula, int telefono, String correo, String alergias, String estadoDental) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.alergias = alergias;
        this.estadoDental = estadoDental;
    }

    //Inicio de pila
    public static Stack<Cliente> pilaCli = new Stack<>();

    // insertar
    public void insertar() {
        int id = 0;
        try {
            id = pilaCli.get(pilaCli.size() - 1).getId() + 1;
        } catch (Exception e) {
            id = 0;
        }

        String nom = JOptionPane.showInputDialog("Ingrese el Nombre: ");

        //logica para solo poner numeros
        String ced = "";
        do {
            ced = JOptionPane.showInputDialog("Ingrese la Cedula: ");

            if (p.matcher(ced).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }

        } while (p.matcher(ced).find());

        //logica para solo poner numeros
        String tel = "";
        do {
            tel = JOptionPane.showInputDialog("Ingrese el Numero de Telefono: ");

            if (p.matcher(tel).find()) {
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
            }

        } while (p.matcher(tel).find());

        String corr = JOptionPane.showInputDialog("Ingrese el Correo: ");
        String aler = JOptionPane.showInputDialog("Ingrese las Alergias: ");
        String estad = JOptionPane.showInputDialog("Ingrese el Estado Dental: ");

        Cliente elemento = new Cliente(id, nom, Integer.parseInt(ced), Integer.parseInt(tel), corr, aler, estad);

        pilaCli.push(elemento);

    }

    //eliminar
    public void eliminarUltimo() {
        if (pilaCli.empty() != true) {
            pilaCli.pop();
        }
    }
    
    //vaciar
    public void vaciarPila(){
        while(!pilaCli.empty()){
            pilaCli.pop();
        }
    }

    //ver toda la pila
    public void visualizarPila() {

        String mensaje = "\nHay " + pilaCli.size() + " clientes registrados.\n";
        for (int i = 0; i < pilaCli.size(); i++) {
            int id = pilaCli.get(i).getId();
            String nomb = pilaCli.get(i).getNombre();
            int cedu = pilaCli.get(i).getCedula();
            int tel = pilaCli.get(i).getTelefono();
            String corr = pilaCli.get(i).getCorreo();
            String aler = pilaCli.get(i).getAlergias();
            String esta = pilaCli.get(i).getEstadoDental();

            mensaje = mensaje + "\n ID:" + id + " - Nombre: " + nomb + " - Cedula: " + cedu + " - Telefono: " + tel + " - Correo: " + corr + " - Alergia: " + aler + " - Estado: " + esta;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // busca elemento por nombre
    public void buscarelemento() {

        String elemento = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
        String resultado = "Resultados:";
        for (int i = 0; i < pilaCli.size(); i++) {
            if (pilaCli.get(i).getNombre().toLowerCase().contains(elemento.toLowerCase())) {
                resultado = resultado + "\n" + pilaCli.get(i).getId() + " - " + pilaCli.get(i).getNombre();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEstadoDental() {
        return estadoDental;
    }

    public void setEstadoDental(String estadoDental) {
        this.estadoDental = estadoDental;
    }

}
