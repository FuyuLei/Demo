package com.example.user.listviewdemo.SQLite;

public class Item {
    private int id;
    private String datetime;
    private int money;
    private String item;



    public Item(){

    }

    public Item(int id, String datetime, String item, int money) {
        this.id = id;
        this.datetime = datetime;
        this.item = item;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
