package com.rainhard.prac.pojo;

import java.util.List;

public class Inventory {
    private int inventory_id;
    private String name;
    private String type;
    private List<String> tags;
    private long purchased_at;
    private Placement placement;

    public Inventory(){}

    public Inventory(int inventory_id, String name, String type, List<String> tags, long purchased_at, Placement placement) {
        this.inventory_id = inventory_id;
        this.name = name;
        this.type = type;
        this.tags = tags;
        this.purchased_at = purchased_at;
        this.placement = placement;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public long getPurchased_at() {
        return purchased_at;
    }

    public void setPurchased_at(long purchased_at) {
        this.purchased_at = purchased_at;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tags=" + tags +
                ", purchased_at=" + purchased_at +
                ", placement=" + placement +
                '}';
    }
}
