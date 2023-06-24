package com.example.roomlibrary;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "collection")
public class Expense {
    @PrimaryKey(autoGenerate = true)
        private int id;

    @ColumnInfo(name = "title")
    private String name;

    @ColumnInfo(name = "price")
    private String price;

    Expense(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Ignore
    Expense(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
