package com.strafeup.task3.part2.model;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Shop {

    private String name;
    private Department[] departments;
    private int departmentCount = 0;

    public Shop(String name, int numOfDepartments) {
        this.name = name;
        this.departments = new Department[numOfDepartments];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    public void decrementDepartmentCount() {
        this.departmentCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) &&
                Arrays.equals(departments, shop.departments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(departments);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", departments=" + Arrays.toString(departments) +
                '}';
    }

    public void addDepartment(Department departmentShop) {
        this.departments[departmentCount] = departmentShop;
        departmentCount++;
    }

    public class Department implements Comparator<Department> {

        private String name;
        private String[] products;
        private String[] services;
        private String location;

        public Department(String name, String[] products, String[] services, String location) {
            this.name = name;
            this.products = products;
            this.services = services;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String[] getProducts() {
            return products;
        }

        public void setProducts(String[] products) {
            this.products = products;
        }

        public String[] getServices() {
            return services;
        }

        public void setServices(String[] services) {
            this.services = services;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public int compare(Department o1, Department o2) {
            return o1.getName().compareTo(o2.getName());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Department)) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name) &&
                    Arrays.equals(products, that.products) &&
                    Arrays.equals(services, that.services) &&
                    Objects.equals(location, that.location);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(name, location);
            result = 31 * result + Arrays.hashCode(products);
            result = 31 * result + Arrays.hashCode(services);
            return result;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", products=" + Arrays.toString(products) +
                    ", services=" + Arrays.toString(services) +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
}