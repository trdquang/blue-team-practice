package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFileBuffer(String path) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ) {
            List<String> res = new ArrayList<>();
            String line = bufferedReader.readLine();
            res.add(line);
            while (line != null) {
                line = bufferedReader.readLine();
                if(line != null)
                    res.add(line);
            }
            return res;
        } catch (IOException e) {

            return null;
        }

    }

    public static void writeFile(String path, String context, boolean status) throws IOException {
        try (Writer writer = new FileWriter(path, status);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(context);
        } catch (IOException e) {
        }

    }
}
