package file_handling;

import java.io.*;
import java.nio.BufferUnderflowException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class textReadWrite {
    public static void main(String[] args) {
        try {
            File file = new File(getFilePath("textFile.txt"));
            if (file.exists())
                System.out.println("File already created");
            else {
                if (file.createNewFile())
                    System.out.println("File created successfully");
                else
                    System.out.println("Failed to create a file");
            }
            fileWrite(getFilePath("textFile.txt"));
            fileRead(getFilePath("textFile.txt"));

        } catch (IOException e) {
            System.out.println("Error reading text file");
        }
    }

    private static String getFilePath(String fileName) {
        return Paths.get("src/test/resources/testdata", fileName).toAbsolutePath().toString();
    }

    private static void fileWrite(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        fw.write("This is program to write a text into the text files");
        fw.close();
    }

    private static void fileRead(String fileName) throws IOException{
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext())
            System.out.print(sc.next()+" ");
        System.out.println();

        FileReader fr = new FileReader(fileName);
        int i;
        while((i = fr.read()) != -1)
            System.out.print((char) i);
        System.out.println();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String data;
        while((data = br.readLine()) != null)
            System.out.println(data);

        Path path = Paths.get(fileName);
        List<String> lst = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(lst);

        String str = new String(Files.readAllBytes(path));
        System.out.println(str);



    }
}
