package clases;

public class OrdenDePedido {
    
    private int idOrdenPedido;
    private int total;
    private String usuarioRut;
    private EstadoDePedido estadoDePedido;

    public OrdenDePedido(int idOrdenPedido, int total, String usuarioRut, EstadoDePedido estadoDePedido) {
        this.idOrdenPedido = idOrdenPedido;
        this.total = total;
        this.usuarioRut = usuarioRut;
        this.estadoDePedido = estadoDePedido;
    }

    public OrdenDePedido() {
        this.idOrdenPedido = 0;
        this.total = 0;
        this.usuarioRut = null;
        this.estadoDePedido = null;
    }

    public int getIdOrdenPedido() {
        return idOrdenPedido;
    }

    public void setIdOrdenPedido(int idOrdenPedido) {
        this.idOrdenPedido = idOrdenPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getUsuarioRut() {
        return usuarioRut;
    }

    public void setUsuarioRut(String usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    public EstadoDePedido getEstadoDePedido() {
        return estadoDePedido;
    }

    public void setEstadoDePedido(EstadoDePedido estadoDePedido) {
        this.estadoDePedido = estadoDePedido;
    }
}
