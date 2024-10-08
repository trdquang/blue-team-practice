package util;

import java.util.Scanner;

public class FuntionUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int inputOneNum(){
        int num = 0;
        while (true){
            try {
                num = Integer.parseInt(sc.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Input one integer");
            }
        }
        return num;
    }
}
