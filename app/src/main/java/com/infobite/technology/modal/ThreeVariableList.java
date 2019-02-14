package com.infobite.technology.modal;

public class ThreeVariableList {
    private int image;
    private String categry;
    private String quotes;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategry() {
        return categry;
    }

    public void setCategry(String categry) {
        this.categry = categry;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public ThreeVariableList(int image, String categry, String quotes) {
        this.image = image;
        this.categry = categry;
        this.quotes = quotes;
    }
}
