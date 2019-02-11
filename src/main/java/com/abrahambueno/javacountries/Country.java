package com.abrahambueno.javacountries;

public class Country {
    private String name;
    private long population;
    private long area; // km^2
    private int age;

    public Country(String name, long population, long area, int age) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
