package com.example.assignmet_aditi_singh;

import java.io.Serializable;

public class Dimension implements Serializable {
    private double height;
    private double width;
    private double depth;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
