package com.example.daria.keepquiet.adaprer;


public final class Dialog {
    private int id;
    private String image;
    private String name;

    public Dialog(int id, String image, String title) {
        this.id = id;
        this.image = image;
        this.name = title;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNime() {
        return name;
    }
}
