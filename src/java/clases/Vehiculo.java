
package clases;

public class Vehiculo {
    
    private String patente;
    private String marca;
    private String modelo;
    private String año;
    private int id_tipo_de_vehiculo;
    private String rut;
    private TipoDeVehiculo tipoDeVehiculo;

    public Vehiculo(String patente, String marca, String modelo,String año, int id_tipo_de_vehiculo, String rut) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.id_tipo_de_vehiculo = id_tipo_de_vehiculo;
        this.rut = rut;
    }

    public Vehiculo() {
        this.patente = null;
        this.marca = null;
        this.modelo = null;
        this.año = null;
        this.id_tipo_de_vehiculo = 0;
        this.rut = null;
        this.tipoDeVehiculo = null;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    public int getId_tipo_de_vehiculo() {
        return id_tipo_de_vehiculo;
    }

    public void setId_tipo_de_vehiculo(int id_tipo_de_vehiculo) {
        this.id_tipo_de_vehiculo = id_tipo_de_vehiculo;
    }    

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(TipoDeVehiculo tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
