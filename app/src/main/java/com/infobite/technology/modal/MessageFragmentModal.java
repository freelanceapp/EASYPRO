package com.infobite.technology.modal;

public class MessageFragmentModal {

    private int image;
    private String name;
    private String datetime;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public MessageFragmentModal(int image, String name, String datetime) {
        this.image = image;
        this.name = name;
        this.datetime = datetime;
    }
}
