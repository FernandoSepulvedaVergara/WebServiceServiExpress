package clases;

public class Region {
    private int idRegion;
    private String region;

    public Region(int idRegion, String region) {
        this.idRegion = idRegion;
        this.region = region;
    }

    public Region() {
        this.idRegion = 0;
        this.region = null;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
