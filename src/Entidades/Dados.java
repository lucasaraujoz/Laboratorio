package Entidades;

import java.util.ArrayList;

public class Dados {
    private String title;
    private String infos;
    private ArrayList<String> dados;

    public Dados(String title, String info) {
        this.title = title;
        this.infos = info;
        this.dados = new ArrayList<>();
    }

    public String getInfos() {
        return infos;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getDados() {
        return dados;
    }
}
