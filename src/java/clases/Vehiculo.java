
package clases;

public class Vehiculo {
    
    private String patente;
    private int numero_motor;
    private String numero_chasis;
    private int id_tipo_de_vehiculo;
    private String rut;
    private TipoDeVehiculo tipoDeVehiculo;

    public Vehiculo(String patente, int numero_motor, String numero_chasis, int id_tipo_de_vehiculo, String rut) {
        this.patente = patente;
        this.numero_motor = numero_motor;
        this.numero_chasis = numero_chasis;
        this.id_tipo_de_vehiculo = id_tipo_de_vehiculo;
        this.rut = rut;
    }

    public Vehiculo() {
        this.patente = null;
        this.numero_motor = 0;
        this.numero_chasis = null;
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

    public int getNumero_motor() {
        return numero_motor;
    }

    public void setNumero_motor(int numero_motor) {
        this.numero_motor = numero_motor;
    }

    public String getNumero_chasis() {
        return numero_chasis;
    }

    public void setNumero_chasis(String numero_chasis) {
        this.numero_chasis = numero_chasis;
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
}
