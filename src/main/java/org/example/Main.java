package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void createDir(String path, StringBuilder log) {
        File dir = new File(path);
        if (dir.mkdir()) {
            log.append("Папка " + path + " была успешно создана.\n");
        } else {
            log.append("Ошибка создания папки " + path + ". Возможно, папка уже существует.\n");
        }
    }
    public static void createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл " + path + " был успешно создан.\n");
            } else {
                log.append("Файл " + path + " не был создан.\n");
            }
        } catch (IOException e) {
            log.append(e.getMessage() + "\n");
        }
    }
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        createDir("D:/Games/src", log);
        createDir("D:/Games/res", log);
        createDir("D:/Games/temp", log);
        createDir("D:/Games/src/main", log);
        createDir("D:/Games/src/test", log);
        createFile("D:/Games/src/main/Main.java", log);
        createFile("D:/Games/src/main/Utils.java", log);
        createDir("D:/Games/res/drawables", log);
        createDir("D:/Games/res/vectors", log);
        createDir("D:/Games/res/icons", log);
        createFile("D:/Games/temp/temp.txt", log);
        try (FileWriter writer = new FileWriter("D:/Games/temp/temp.txt", false)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(log);

    }
}