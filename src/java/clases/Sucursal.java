
package clases;

public class Sucursal {
    private int id_sucursal;
    private String sucursal;
    private String direccion;

    public Sucursal(int id_sucursal, String sucursal, String direccion) {
        this.id_sucursal = id_sucursal;
        this.sucursal = sucursal;
        this.direccion = direccion;
    }
    
    public Sucursal() {
        this.id_sucursal = 0;
        this.sucursal = null;
        this.direccion = null;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }    
}
