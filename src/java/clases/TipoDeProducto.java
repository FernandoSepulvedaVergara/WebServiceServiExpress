package clases;

public class TipoDeProducto {
    
    private int idTipoDeProducto;
    private String producto;

    public TipoDeProducto(int idTipoDeProducto, String producto) {
        this.idTipoDeProducto = idTipoDeProducto;
        this.producto = producto;
    }

    public TipoDeProducto() {
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdTipoDeProducto() {
        return idTipoDeProducto;
    }

    public void setIdTipoDeProducto(int idTipoDeProducto) {
        this.idTipoDeProducto = idTipoDeProducto;
    }
}
