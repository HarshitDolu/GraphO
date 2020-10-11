package com.example.grapho.Models;

public class algoModel {
    int pic;
    String text;

    public algoModel(int pic,String text) {
        this.text=text;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
