package vti.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static boolean checkFileExists(String pathFile) {
        File file = new File(pathFile);

        if (file.exists()) {
            System.out.println("file có tồn tại!");
            return true;
        } else {
            System.out.println("file không tồn tại!");
            return false;
        }
    }

    public static void createFile(String name) {
        String pathFile = "Lesson - 7/file/" + name;
        File file = new File(pathFile);
        try {
            if (file.createNewFile()) {
                System.out.println("tạo file thành công!");
            } else {
                System.out.println("tạo file thất bại!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  delFile(String path){
        File file = new File(path);

        if (file.exists()) {
            System.out.println(file.delete() ? " Xóa thành công!" : "Xóa thất bại");
        } else {
            System.out.println("file không tồn tại!");
        }
    }
}
