package util;

import java.io.*;

public class FileUtil {
    public static String readFileBuffer(String path) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ) {
            String line = bufferedReader.readLine();
            String res = line + "\n";
            while (line != null) {
                line = bufferedReader.readLine();
                res += line +"\n" ;
            }
            return res;
        } catch (IOException e) {

            return null;
        }

    }

    public static void writeFile(String path, String context) throws IOException {
        try (Writer writer = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(context);
        } catch (IOException e) {

        }

    }
}
