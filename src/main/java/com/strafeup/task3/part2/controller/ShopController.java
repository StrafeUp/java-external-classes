package com.strafeup.task3.part2.controller;

import com.strafeup.task3.part2.model.Shop;
import com.strafeup.task3.part2.model.ShopModel;
import com.strafeup.task3.part2.util.Tokenizer;
import com.strafeup.task3.part2.view.ConsolePrinter;
import com.strafeup.task3.part2.view.UserInput;

import java.util.Arrays;

public class ShopController {
    private ShopModel shopModel = new ShopModel();

    public void start() {
        startMenu();
    }

    public void startMenu() {
        while (true) {
            ConsolePrinter.print("Welcome to shop management system\n Choose action:\n" +
                    "1. Create and add departments to shop\n" +
                    "2. Sort departments by name\n" +
                    "3. Add new product to department");
            switch (Integer.parseInt(UserInput.getLine())) {
                case 1:
                    addDepartment();
                    ConsolePrinter.printDepartments(shopModel.getDepartments());
                    break;
                case 2:
                    sortDepartments();
                    ConsolePrinter.printDepartments(shopModel.getDepartments());
                    break;
                case 3:
                    addProduct();
                    ConsolePrinter.printDepartments(shopModel.getDepartments());
                    break;
                case 5:
                    return;
            }
        }
    }

    private void addProduct() {
        ConsolePrinter.printDepartments(shopModel.getDepartments());
        ConsolePrinter.print("Enter name of the department");
        Shop.Department department = shopModel.getDepartmentByName(UserInput.getLine());

        String[] products = department.getProducts();
        ConsolePrinter.print("Add products separated by comma");
        String[] userInput = Tokenizer.getTokensFromString(UserInput.getLine(), ",");

        String[] newProductList = new String[products.length + userInput.length];
        int j = 0;
        newProductList = Arrays.copyOf(products, products.length);
        for (int i = products.length - 1; i < newProductList.length; i++) {
            newProductList[i] = userInput[j];
            j++;
        }
        department.setProducts(newProductList);
    }

    private void sortDepartments() {
        shopModel.sortByName();
    }

    public void addDepartment() {
        ConsolePrinter.print("Enter department name\n");
        String name = UserInput.getLine();
        ConsolePrinter.print("Enter main products separated by comma");
        String[] products = Tokenizer.getTokensFromString(UserInput.getLine(), ",");

        ConsolePrinter.print("Enter main services of department separated by comma");
        String[] services = Tokenizer.getTokensFromString(UserInput.getLine(), ",");
        ConsolePrinter.print("Enter address of the department");
        String location = UserInput.getLine();

        shopModel.addDepartment(name, products, services, location);
    }


}
