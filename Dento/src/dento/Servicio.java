package dento;

public class Servicio {
    
    //variables
    private int id;
    private String servicio;
    private String descripcion;
    private double costo;
    private double impuesto;

    //constructores
    public Servicio() {
    }

    public Servicio(int id, String servicio, String descripcion, double costo, double impuesto) {
        this.id = id;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.costo = costo;
        this.impuesto = impuesto;
    }
    
    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    
    
    
}
