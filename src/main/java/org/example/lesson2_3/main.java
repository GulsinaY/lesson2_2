package org.example.lesson2_3;

public static void main(String[] args) {

    Park kashkadan = new Park("Кашкадан");
    Park garipova = new Park("Гарипова");
    Park neftyanikov = new Park("Нефтяников");

    kashkadan.addAttraction("катер", "10:00-20:00", 150.0);
    kashkadan.addAttraction("катамаран", "09:00-19:00", 200.0);
    kashkadan.addAttraction("горка", "11:00-21:00", 100.0);

    garipova.addAttraction("поезд", "10:00-18:00", 80.0);
    garipova.addAttraction("батут", "09:00-20:00", 50.0);
    garipova.addAttraction("карусель", "10:00-19:00", 70.0);

    neftyanikov.addAttraction("канаты", "10:00-22:00", 120.0);
    neftyanikov.addAttraction("тир", "11:00-23:00", 40.0);
    neftyanikov.addAttraction("карусель", "10:00-20:00", 90.0);

    kashkadan.displayAttractions();
    garipova.displayAttractions();
    neftyanikov.displayAttractions();
}