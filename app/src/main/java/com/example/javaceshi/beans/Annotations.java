package com.example.javaceshi.beans;

import androidx.annotation.NonNull;


public class Annotations implements Cloneable {

    public static final String TYPE_RESET = "reset";//清空当前页所有的涂鸦
    public static final String TYPE_LINE = "line";
    public static final String TYPE_UNDO = "undo";//撤销
    public static final String TYPE_REDO = "redo";//恢复
    public static final String TYPE_ERASER = "eraser";//橡皮
    public static final String TYPE_RECT = "rect"; //矩形
    public static final String TYPE_CIRCLE = "circle";
    public static final String TYPE_LIGHT = "light";//激光笔
    public static final String TYPE_TEXT = "text";//文字

    private String color;
    private Float width;
    private Float width2;
    private String id;
    private String type;
    private boolean realtime;
    private String text;
    private String font;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getWidth2() {
        return width2;
    }

    public void setWidth2(Float width2) {
        this.width2 = width2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRealtime() {
        return realtime;
    }

    public void setRealtime(boolean realtime) {
        this.realtime = realtime;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Annotations annotations = null;
        annotations = (Annotations) super.clone();
        return annotations;

    }

    public Annotations copy() {
        try {
            return (Annotations) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Annotations{" +
                "color='" + color + '\'' +
                ", width=" + width +
                ", width2=" + width2 +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", realtime=" + realtime +
                ", text='" + text + '\'' +
                ", font='" + font + '\'' +
                '}';
    }
}
