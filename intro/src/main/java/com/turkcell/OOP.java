package com.turkcell;

public class OOP {
    public static void main(String[] args) {
        Car car1 = new Car(); // new Car(); 
        // yeni bir araba nesnesi örneği (instance) üret
        car1.brand = "BMW"; // set işlemi (değer atama)
        car1.model = "X5";
        car1.year = 2020;
        //car1.pricePerDay = -500.0;
        car1.setPricePerDay(-500.0);

        System.out.println(car1.brand); // get işlemi (değer okuma)
        System.out.println(car1.getPricePerDay()); // private olduğu için erişilemez
    }
}
