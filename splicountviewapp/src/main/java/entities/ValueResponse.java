package entities;

public class ValueResponse {

    private double value;
    private boolean sucess;

    public ValueResponse(double value, boolean sucess) {
        this.value = value;
        this.sucess = sucess;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
