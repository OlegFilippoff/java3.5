package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product{

    private String model;

    public Smartphone() {};

    public Smartphone(int id, String name, int price, String model) {
    super(id, name, price);
    this.model = model;
    }

    public Smartphone(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "model='" + model + '\'' +
                '}';
    }
}






