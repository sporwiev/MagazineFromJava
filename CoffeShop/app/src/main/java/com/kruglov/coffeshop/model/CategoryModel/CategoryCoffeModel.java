package com.kruglov.coffeshop.model.CategoryModel;

public class CategoryCoffeModel {
    int id;
    String img;
    String title;
    String color;
    String price;
    String opis;
    String milk;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }



    public CategoryCoffeModel(int id, String img, String title, String color, String price, String opis, String milk, String adds, String sell) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.color = color;
        this.price = price;
        this.opis = opis;
        this.milk = milk;
        this.adds = adds;
        this.sell = sell;
    }

    String adds;

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    String sell;
}
