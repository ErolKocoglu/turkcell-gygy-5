package com.turkcell;

// Car isminde bir type oluşturmak.
public class Car 
{
    // GERÇEK HAYATTAKİ HER ŞEYİ DEĞİL, 
    // PROGRAMDA İHTİYACIMIZ OLAN ŞEYLERİ MODELLEMEK İSTİYORUZ.

    public String brand;
    public String model;
    public int year;
    // public -> Her noktadan erişilebilir alan.


    // ENCAPSULATION (KAPSÜLLEME)
    private Double pricePerDay;

    // setter method
    public void setPricePerDay(Double pricePerDay) {
        // this => sınıfın kendisi
        if(pricePerDay < 0)
        {
            System.out.println("Fiyat negatif olamaz. 0'a eşitleniyor..");
            pricePerDay = 0.0;
        }
        this.pricePerDay = pricePerDay;
    }
    // getter method
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
