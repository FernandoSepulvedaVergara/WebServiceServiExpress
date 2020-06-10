
package clases;

public class TipoDeServicio {
    
    private int id_servicio;
    private String servicio;

    public TipoDeServicio() {
        this.id_servicio = 0;
        this.servicio = null;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    
}
