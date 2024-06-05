package com.rainhard.prac.pojo;

import java.util.List;

public class InventoryResponse {
    private int inventory_id;
    private String name;
    private String type;
    private List<String> tags;
    private long purchased_at;
    private int room_id;
    private String room_name;

    public InventoryResponse() {}
    public InventoryResponse(int inventory_id, String name, String type, List<String> tags,
                             long purchased_at, int room_id, String room_name) {
        this.inventory_id = inventory_id;
        this.name = name;
        this.type = type;
        this.tags = tags;
        this.purchased_at = purchased_at;
        this.room_id = room_id;
        this.room_name = room_name;
    }

    public static InventoryResponse printInventoryResponse(Inventory inventory){
        var inventoryResponse = new InventoryResponse();
        inventoryResponse.setInventory_id(inventory.getInventory_id());
        inventoryResponse.setName(inventory.getName());
        inventoryResponse.setTags(inventory.getTags());
        inventoryResponse.setRoom_id(inventory.getPlacement().getRoom_id());
        inventoryResponse.setRoom_name(inventory.getPlacement().getName());
        return inventoryResponse;
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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public String toString() {
        return "InventoryResponse{" +
                "inventory_id=" + inventory_id +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                ", room_id=" + room_id +
                ", room_name='" + room_name + '\'' +
                '}';
    }
}
