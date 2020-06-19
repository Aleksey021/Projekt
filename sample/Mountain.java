import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mountain {

    private final StringProperty vershina;
    private final IntegerProperty visota;
    private final StringProperty mestopoloqenie;
    private final StringProperty sistema;

    public Mountain(String vershina, Integer visota, String mestopoloqenie, String sistema) {
        this.vershina = new SimpleStringProperty(vershina);
        this.visota = new SimpleIntegerProperty(visota);
        this.mestopoloqenie = new SimpleStringProperty(mestopoloqenie);
        this.sistema = new SimpleStringProperty(sistema);
    }


    public String getVershina() {
        return vershina.get();
    }

    public Integer getVisota() {
        return visota.get();
    }

    public String getMestopoloqenie() {
        return mestopoloqenie.get();
    }

    public String getSistema() {
        return sistema.get();
    }


    public void setVershina(String value){vershina.set(value);}

    public void setVisota(Integer value){visota.set(value);}

    public void setMestopoloqenie(String value){mestopoloqenie.set(value);}

    public void setSistema(String value){sistema.set(value);}


    public StringProperty VerProperty(){return vershina;}

    public IntegerProperty VisProperty(){return visota;}

    public StringProperty MesProperty(){return mestopoloqenie;}

    public StringProperty GsProperty(){return sistema;}

}