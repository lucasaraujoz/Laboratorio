package Entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convidado extends Usuario {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date;

    public Convidado(String id, String pass) {
        super(id, pass);
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }
    //System.out.println(dateFormat.format(date));
}
