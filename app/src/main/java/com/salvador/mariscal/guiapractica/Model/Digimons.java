package com.salvador.mariscal.guiapractica.Model;

public class Digimons {

    private String name;
    private String img;
    private String lvl;

    public Digimons() {
    }

    public Digimons(String name, String img, String lvl) {
        this.name = name;
        this.img = img;
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
}
