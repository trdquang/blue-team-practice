import util.FileUtil;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
        String a = FileUtil.readFileBuffer("src/util/user.txt");
        System.out.println(a);
    }
}