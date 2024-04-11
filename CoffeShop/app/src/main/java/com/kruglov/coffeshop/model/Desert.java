package com.kruglov.coffeshop.model;

public class Desert {
    int id;
    String img;
    String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    String title;
    String opis;
    String color;
    String type;
    String sell;

    public Desert(int id, String img, String price, String title, String opis, String color, String type,String sell) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.title = title;
        this.opis = opis;
        this.color = color;
        this.type = type;
        this.sell = sell;
    }
}
