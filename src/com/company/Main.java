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

        File gamesDir = new File("C://Games");
        File srcDir = new File("C://Games", "src");
        File resDir = new File("C://Games", "res");
        File saveGamesDir = new File("C://Games", "savegames");
        File tempDir = new File("C://Games", "temp");
        File mainDir = new File("C://Games//src", "main");
        File testDir = new File("C://Games//src", "test");
        File drawablesDir = new File("C://Games//res", "drawables");
        File vectorsDir = new File("C://Games//res", "vectors");
        File iconsDir = new File("C://Games//res", "icons");

        createDir.accept(gamesDir);
        createDir.accept(srcDir);
        createDir.accept(resDir);
        createDir.accept(saveGamesDir);
        createDir.accept(mainDir);
        createDir.accept(tempDir);
        createDir.accept(testDir);
        createDir.accept(drawablesDir);
        createDir.accept(vectorsDir);
        createDir.accept(iconsDir);

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
