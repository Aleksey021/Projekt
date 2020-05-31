public class Mountain {
    private String vershina;
    private int visota;
    private String mestopoloqenie;
    private String sistema;

    public Mountain(String vershina, int visota, String mestopoloqenie, String sistema) {
        this.vershina = vershina;
        this.visota = visota;
        this.mestopoloqenie = mestopoloqenie;
        this.sistema = sistema;
    }

    public Mountain() {

    }

    public String getVershina() {
        return vershina;
    }

    public void setVershina(String vershina) {
        this.vershina = vershina;
    }

    public int getVisota() {
        return visota;
    }

    public void setVisota(int visota) {
        this.visota = visota;
    }

    public String getMestopoloqenie() {
        return mestopoloqenie;
    }

    public void setMestopoloqenie(String mestopoloqenie) {
        this.mestopoloqenie = mestopoloqenie;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
}
