package dento;

public class Factura {

    //variables
    private int id;
    private String fecha;
    private int idCliente;
    private int idDoctor;
    private int idServicio;

    //constructores
    public Factura() {
    }

    public Factura(int id, String fecha, int idCliente, int idDoctor, int idServicio) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idDoctor = idDoctor;
        this.idServicio = idServicio;
    }
    
    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

}
