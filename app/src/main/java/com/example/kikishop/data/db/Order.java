package com.example.kikishop.data.db;

import java.util.ArrayList;

public class Order {
    int id;
    String name;
    String items;
    int value;
    String address;
    String email;
    String status;

    public Order(int id, String name, String items, int value, String address, String email, String status) {
        this.id = id;
        this.name = name;
        this.items = items;
        this.value = value;
        this.address = address;
        this.email = email;
        this.status = status;
    }

    public Order() {

    }

    public ArrayList<Order> fakeData() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Ala", "1,3,5,2", 42, "Polanki 23a, 32-34 Gdańsk", "addres1@gmale.com", "new"));
        orders.add(new Order(2, "Marek", "1,3,5,24", 22, "Polanki 23a, 32-34 Gdańsk", "addre23s1@gmale.com", "new"));
        orders.add(new Order(3, "Daniel", "11,3,5,2", 72, "Polanki 23a, 32-34 Gdańsk", "addasdares1@gmale.com", "processed"));
        orders.add(new Order(3, "Daniel", "11,3,5,2", 72, "Polanki 23a, 32-34 Gdańsk", "addasdares1@gmale.com", "processed"));
        orders.add(new Order(3, "Daniel", "11,3,5,2", 72, "Polanki 23a, 32-34 Gdańsk", "addasdares1@gmale.com", "processed"));
        orders.add(new Order(3, "Daniel", "11,3,5,2", 72, "Polanki 23a, 32-34 Gdańsk", "addasdares1@gmale.com", "processed"));
        orders.add(new Order(3, "Daniel", "11,3,5,2", 72, "Polanki 23a, 32-34 Gdańsk", "addasdares1@gmale.com", "processed"));
        orders.add(new Order(4, "Darek", "1,32,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addhessres1@gmale.com", "finish"));
        orders.add(new Order(4, "Darek", "1,32,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addhessres1@gmale.com", "finish"));
        orders.add(new Order(4, "Darek", "1,32,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addhessres1@gmale.com", "finish"));
        orders.add(new Order(5, "Krzychu", "1,3,5,2", 12, "Polanki 23a, 32-34 Gdańsk", "ahscddres1@gmale.com", "new"));
        orders.add(new Order(5, "Krzychu", "1,3,5,2", 12, "Polanki 23a, 32-34 Gdańsk", "ahscddres1@gmale.com", "new"));
        orders.add(new Order(5, "Krzychu", "1,3,5,2", 12, "Polanki 23a, 32-34 Gdańsk", "ahscddres1@gmale.com", "new"));
        orders.add(new Order(6, "Sowa", "12,3,5,2", 45, "Polanki 23a, 32-34 Gdańsk", "addradaes1@gmale.com", "delivered"));
        orders.add(new Order(7, "Asia", "1,53,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addr4rqes1@gmale.com", "delivered"));
        orders.add(new Order(7, "Asia", "1,53,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addr4rqes1@gmale.com", "delivered"));
        orders.add(new Order(7, "Asia", "1,53,5,2", 22, "Polanki 23a, 32-34 Gdańsk", "addr4rqes1@gmale.com", "delivered"));

        return orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
