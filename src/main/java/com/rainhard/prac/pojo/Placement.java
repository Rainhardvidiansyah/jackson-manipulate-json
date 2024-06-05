package com.rainhard.prac.pojo;

public class Placement {

    private int room_id;
    private String name;

    public Placement(){}

    public Placement(int room_id, String name) {
        this.room_id = room_id;
        this.name = name;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                '}';
    }
}
