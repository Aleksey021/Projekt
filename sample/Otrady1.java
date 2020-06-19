import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Otrady1 {
    private final StringProperty nameotr;
    private final IntegerProperty ycasniki;
    private final IntegerProperty vosh;

    public Otrady1(String nameotr, Integer ycasniki, Integer vosh) {
        this.nameotr = new SimpleStringProperty(nameotr);
        this.ycasniki = new SimpleIntegerProperty(ycasniki);
        this.vosh = new SimpleIntegerProperty(vosh);
    }


    public String getNameotr() {
        return nameotr.get();
    }

    public Integer getYcasniki() {
        return ycasniki.get();
    }

    public Integer getVosh() {
        return vosh.get();
    }


    public void setNameotr(String value){nameotr.set(value);}

    public void setYcasniki(Integer value){ycasniki.set(value);}

    public void setVosh(Integer value){vosh.set(value);}


    public StringProperty NameotrProperty(){return nameotr;}

    public IntegerProperty YcasnikiProperty(){return ycasniki;}

    public IntegerProperty VoshProperty(){return vosh;}

}
