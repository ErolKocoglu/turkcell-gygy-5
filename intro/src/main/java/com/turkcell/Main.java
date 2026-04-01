package com.turkcell;

// Entrypoint
public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Merhaba Turkcell, Java'ya hoş geldiniz!");

        // Programlama konseptleri

        // Scope Kavramı => {} kapsama alanı

        // Değişkenler (Variables)
        // Kodun akışında değer tutan isimli veriler.

        System.out.println(10);
        int X = 15; // Değişken tanımlandı. X ismine bir değer atandı.
        // Tanımlandıktan itibaren değişebilir, erişilebilir.
        System.out.println(X);
        X=20;
        System.out.println(X);

        // Değişken tipleri => int, double, boolean, char, String
        String name = "Halit";
        String age = "25";
        boolean isStudent = true;
        char grade = 'A';
    }
    
} // Main classının kapsama alanı (sınır)
