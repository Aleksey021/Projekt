import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Poxody1 {
    private final StringProperty otrad;
    private final StringProperty gora;
    private final StringProperty datavos;

    public Poxody1(String otrad, String gora, String datavos) {
        this.otrad = new SimpleStringProperty(otrad);
        this.gora = new SimpleStringProperty(gora);
        this.datavos = new SimpleStringProperty(datavos);
    }


    public String getOtrad() {
        return otrad.get();
    }

    public StringProperty otradProperty() {
        return otrad;
    }

    public void setOtrad(String otrad) {
        this.otrad.set(otrad);
    }

    public String getGora() {
        return gora.get();
    }

    public StringProperty goraProperty() {
        return gora;
    }

    public void setGora(String gora) {
        this.gora.set(gora);
    }

    public String getDatavos() {
        return datavos.get();
    }

    public StringProperty datavosProperty() {
        return datavos;
    }

    public void setDatavos(String datavos) {
        this.datavos.set(datavos);
    }
}
