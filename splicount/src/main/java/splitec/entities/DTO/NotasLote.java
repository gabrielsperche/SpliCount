package splitec.entities.DTO;

import dev.morphia.annotations.Entity;

@Entity("NotasLote")
public class NotasLote {

    private String data;

    public NotasLote(String data) {
        this.data = data;
    }

    public NotasLote() {
    }

    public String getData() {
        return data;
    }
}
