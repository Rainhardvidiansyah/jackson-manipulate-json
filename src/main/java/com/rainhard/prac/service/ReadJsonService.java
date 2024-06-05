package com.rainhard.prac.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainhard.prac.pojo.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadJsonService {



    public void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllInventories() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(); //to manipulate json object
        List<Inventory> inventories = objectMapper.readValue(inputStream(), new TypeReference<List<Inventory>>() {
        });
        for (Inventory inventory : inventories) {
            List<String> placements = new ArrayList<>();
            placements.add(inventory.getPlacement().getName());
            System.out.println(placements);
        }
    }


    public void findItemsById(int id) throws IOException {
        List<Inventory> inventories = objectMapper().readValue(inputStream(), new TypeReference<List<Inventory>>() {
        });

        for (Inventory inventory : inventories) {
            if (inventory.getInventory_id() == id) {
                var response = InventoryResponse.printInventoryResponse(inventory);
                System.out.println(response);
                break;
            }
        }
    }

    public void findAllItemsWithBrownColor() throws IOException {
        List<Inventory> inventories = objectMapper().readValue(inputStream(), new TypeReference<List<Inventory>>() {
        });

        List<String> nameWithBrownColor = new ArrayList<>();
        for (Inventory inventory : inventories) {
            nameWithBrownColor.add(inventory.getName());

            if (nameWithBrownColor.contains("Brown Chair")) {
                var response = InventoryResponse.printInventoryResponse(inventory);
                System.out.println(printResponse(response));
                break;
            }
        }
    }


    public void findDataByTag(String color) throws IOException {
        List<Inventory> inventories = objectMapper().readValue(inputStream(), new TypeReference<List<Inventory>>(){});
        for (Inventory inventory: inventories) {
            if (inventory.getTags().contains(color)) {
                var response = InventoryResponse.printInventoryResponse(inventory);
                System.out.println(printResponse(response));
                break;
            }
        }
    }

    public void findDataByFurniture(String data) throws IOException {
        List<Inventory> inventories = objectMapper().readValue(inputStream(), new TypeReference<List<Inventory>>(){});
        for (Inventory inventory: inventories) {
            if (inventory.getType().contains(data)) {
                List<InventoryResponse> responses = new ArrayList<>();
                responses.add(InventoryResponse.printInventoryResponse(inventory));
                System.out.println(responses);

            }
        }
    }


    private InputStream inputStream() {
        //File file = new File("src/main/resources/test.json"); //good. it works, too
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream("dataitem.json");
    }

    private static Object printResponse(Object object) {
        return object;
    }

    private ObjectMapper objectMapper() throws IOException {
        return new ObjectMapper();
    }
}

//        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
//        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
