package dento;

import java.util.Stack;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Doctor {

    //variables de cliente
    int id;
    String Nombres;
    int Cedula;
    int Telefono;
    String Correo;

    // parametro pattern para saber si estoy insertando solo numeros
    Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");

    // constructores
    public Doctor() {
    }

    public Doctor(int id, String Nombres, int Cedula, int Telefono, String Correo) {
        this.id = id;
        this.Nombres = Nombres;
        this.Cedula = Cedula;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public static Stack<Doctor> pilaDoc = new Stack<>();

    public void insertar() {
        int id = 0;
        try {
            id = pilaDoc.get(pilaDoc.size() - 1).getId() + 1;
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

        Doctor elemento = new Doctor(id, nom, Integer.parseInt(ced), Integer.parseInt(tel), corr);
        pilaDoc.push(elemento);

    }

    //eliminar
    public void eliminarUltimo() {
        if (pilaDoc.empty() != true) {
            pilaDoc.pop();
        }
    }

    //ver toda la pila
    public void visualizarPila() {
        String mensaje = "\nHay " + pilaDoc.size() + " doctores registrados.\n";

        for (int i = 0; i < pilaDoc.size(); i++) {
            int id = pilaDoc.get(i).getId();
            String nomb = pilaDoc.get(i).getNombres();
            int cedu = pilaDoc.get(i).getCedula();
            int tel = pilaDoc.get(i).getTelefono();
            String corr = pilaDoc.get(i).getCorreo();

            mensaje = mensaje + "\nID:" + id + " - Nombre: " + nomb + " - Cedula: " + cedu + " - Telefono: " + tel + " - Correo: " + corr;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // busca elemento por nombre
    public void buscarelemento() {

        String elemento = JOptionPane.showInputDialog("Ingrese el nombre del doctor: ");
        String resultado = "Resultados:";
        for (int i = 0; i < pilaDoc.size(); i++) {
            if (pilaDoc.get(i).getNombres().toLowerCase().contains(elemento.toLowerCase())) {
                resultado = resultado + "\n" + pilaDoc.get(i).getId() + " - " + pilaDoc.get(i).getNombres();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    //vaciar
    public void vaciarPila(){
        while(!pilaDoc.empty()){
            pilaDoc.pop();
        }
    }
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

}
