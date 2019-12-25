package com.strafeup.task3.part2.model;

import java.util.Arrays;

public class ShopModel {

    private Shop shop;

    public ShopModel() {
        this.shop = new Shop("Shop1", 3);
    }

    public void addDepartment(String name, String[] products, String[] services, String location) {
        this.shop.addDepartment(new Shop("Shop1", 2).new Department(name, products, services, location));
    }

    public void removeDepartmentByName(String name) {
        Shop.Department[] departments = shop.getDepartments();
        int tempVar = 0;
        for (int i = 0; i < shop.getDepartmentCount(); i++) {
            if (departments[i].getName().equalsIgnoreCase(name)) {
                departments[i] = null;
                shop.decrementDepartmentCount();
                tempVar = i;
                break;
            } else return;
        }
        for (int i = tempVar; i < shop.getDepartmentCount(); i++) {
            departments[i] = departments[i + 1];
        }
    }

    public void sortDepartmentsByName() {
        Shop.Department[] departments = shop.getDepartments();
        Arrays.sort(departments);
        shop.setDepartments(departments);
    }

    public Shop.Department[] getDepartments() {
        return shop.getDepartments();
    }

    public void sortByName() {
        Arrays.sort(shop.getDepartments(), (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public Shop.Department getDepartmentByName(String name) {
        for (Shop.Department dep: shop.getDepartments()) {
            if(dep.getName().equalsIgnoreCase(name)){
                return dep;
            }
        }
        return null;
    }
}
