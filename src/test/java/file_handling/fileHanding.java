package file_handling;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class fileHanding {
    public static void main(String[] str) throws IOException {
        String fileName = getFilePath("Test1.txt");

        try {
            File file = new File(fileName);
            if (file.exists())
                System.out.println("File has already created");
            else if (file.createNewFile())
                System.out.println("File created successfully");
            else
                System.out.println("Filed to create file");

            fileWrite(fileName);
            fileRead(fileName);

        } catch (IOException e) {
            System.out.println("Error while creating file");
        }

    }

    private static void fileWrite(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write("This program to write a file into Text file");
        fw.close();

    }

    private static void fileRead(String fileName) throws IOException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext())
            System.out.print(sc.next()+" ");
        System.out.println();

        FileReader fr = new FileReader(fileName);
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        System.out.println();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String data;
        while ((data = br.readLine()) != null)
            System.out.println(data);

        Path path = Paths.get(fileName);
        List list = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(list);

        String str = new String(Files.readAllBytes(path));
        System.out.println(str);
    }

    private static String getFilePath(String fileName) {
        return Paths.get("src/test/resources/testData", fileName).toAbsolutePath().toString();
    }
}
