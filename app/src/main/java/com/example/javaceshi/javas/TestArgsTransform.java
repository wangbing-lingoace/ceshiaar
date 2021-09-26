package com.example.javaceshi.javas;

import com.example.javaceshi.beans.Annotations;

public class TestArgsTransform {
    public static void main(String[] args) {
        aaa(new Annotations());
    }

    private static void ceshsi(int a, int b) {
        System.out.println("i:" + a + " j:" + b);
        swap(a, b);
        System.out.println("i:" + a + " j:" + b);
    }

    public static void swap(int a, int b) {
        a = a + 10;
        b = b + 10;
        System.out.println("a:" + a + " b:" + b);
    }

    private static void aaa(Annotations annotations) {
        System.out.println("anno:" + annotations.toString());
        ccc(annotations);
        System.out.println("after:" + annotations.toString());
    }

    private static void ccc(Annotations annotations) {
        annotations.setText("al;jkdf;lkajfj;lkaksjdflas;jdflsafdjsadjkf");
        System.out.println("annocccccc:" + annotations.toString());
    }
}
