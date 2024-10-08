package controller;

public class Menu {
    public static void menu(){
        System.out.println("-------------Book Store-------------");
        System.out.println("0. Exit");
        System.out.println("1. Login");
    }

    public static void menuAdmin(){
        System.out.println("-------------Admin-------------");
        System.out.println("0. Back menu");
        System.out.println("1. Manager user");
        System.out.println("2. Manager book");
        System.out.println("3. Manager author");
        System.out.println("4. Manager order");
    }

    public static void menuAdminUser(){
        System.out.println("-------------Manage user-------------");
        System.out.println("0. Back menu");
        System.out.println("1. View all user");
        System.out.println("2. Add one user");
        System.out.println("3. Edit one user");
        System.out.println("4. Delete one user");
    }

    public static void menuAdminOrder(){
        System.out.println("-------------Manage user-------------");
        System.out.println("0. Back menu");
        System.out.println("1. View all order");
        System.out.println("2. Group order by user");
//        System.out.println("3. Group order by user");
        System.out.println("4. Delete one user");
    }

    public static void menuAdminAuthor(){
        System.out.println("-------------Manage user-------------");
        System.out.println("0. Back menu");
        System.out.println("1. View all author");
        System.out.println("2. Add");
        System.out.println("3. Edit");
        System.out.println("4. Delete by id");
        System.out.println("5. Show book by author");
    }

    public static void menuAdminBook(){
        System.out.println("-------------Manage book-------------");
        System.out.println("0. Back menu");
        System.out.println("1. View all book");
        System.out.println("2. Add");
        System.out.println("3. Edit");
        System.out.println("4. Delete by id");
        System.out.println("5. Show book by author");
    }
}
