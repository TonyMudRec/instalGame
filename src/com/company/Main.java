package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.*;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        Consumer<File> createDir = dir -> {
            if (dir.mkdir())
                sb.append("Создан каталог ").append(dir.getName()).append("\n");
        };
        File[] files = {new File("C://Games"),
                new File("C://Games", "src"),
                new File("C://Games", "res"),
                new File("C://Games", "savegames"),
                new File("C://Games", "temp"),
                new File("C://Games//src", "main"),
                new File("C://Games//src", "test"),
                new File("C://Games//res", "drawables"),
                new File("C://Games//res", "vectors"),
                new File("C://Games//res", "icons")};

        for(int i = 0; i < files.length; i++) {
            createDir.accept(files[i]);
        }

        try {
            File mainFile = new File("C://Games//src//main", "Main.java");
            File utilsFile = new File("C://Games//src//main", "Utils.java");
            if (mainFile.createNewFile() && utilsFile.createNewFile())
                sb.append("Файлы созданы").append("\n");
        } catch (IOException ex) {
            sb.append(ex.getMessage()).append("\n");
        }

        try (FileWriter fw = new FileWriter("C://Games//temp//temp.txt")) {
            fw.write(String.valueOf(sb));
        } catch (IOException ex) {
            sb.append(ex.getMessage()).append("\n");
        }


    }
}
