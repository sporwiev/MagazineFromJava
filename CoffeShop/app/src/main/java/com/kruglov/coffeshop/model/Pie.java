package com.kruglov.coffeshop.model;

public class Pie {
    int id;
    String img;
    String color;
    String nachinka;
    String opis;
    String title;

    public void setNachinka(String nachinka) {
        this.nachinka = nachinka;
    }
    public String getNachinka(String nachinka){
        return nachinka;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    String sell;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Pie(int id, String img, String color, String nachinka, String opis, String title, String price,String sell) {
        this.id = id;
        this.img = img;
        this.color = color;
        this.nachinka = nachinka;
        this.opis = opis;
        this.title = title;
        this.price = price;
        this.sell = sell;
    }

    String price;
}
