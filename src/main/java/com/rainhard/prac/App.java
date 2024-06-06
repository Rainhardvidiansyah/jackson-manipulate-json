package com.rainhard.prac;

import com.rainhard.prac.pojo.users.User;
import com.rainhard.prac.service.HttpClientService;
import com.rainhard.prac.service.ReadJsonService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;


public class App {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        ReadJsonService readJsonService = new ReadJsonService();
        //readJsonService.findItemsById(3);
        //readJsonService.findAllItemsWithBrownColor();
        readJsonService.findDataByTag("brown");
        readJsonService.findDataByFurniture("furniture");

        HttpClientService httpClientService = new HttpClientService();
        //httpClientService.getAllUsers();
        //httpClientService.getUserById();
        //System.out.println(httpClientService.findAllUser());
        Optional<User> user = httpClientService.findUserByName("Leanne Graham");
        user.ifPresent(System.out::println);

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