package com.rainhard.prac;

import com.rainhard.prac.service.ReadJsonService;

import java.io.IOException;


public class App {
    public static void main( String[] args ) throws IOException {
        ReadJsonService readJsonService = new ReadJsonService();
        //readJsonService.findItemsById(3);
        //readJsonService.findAllItemsWithBrownColor();
        readJsonService.findDataByTag("brown");
        readJsonService.findDataByFurniture("furniture");
    }

}



/*
Your tasks to create functions:

1. Find items in the Meeting Room.
2. Find all electronic devices.
3. Find all the furniture.
4. Find all items were purchased on 16 Januari 2020.
5. Find all items with brown color.
 */