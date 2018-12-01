package com.hmzhou;

import java.io.File;

public class Main {

    private static final String PATH = "/Volumes/suntec/大数据";
    private static final String STICK_NAME = "【北京尚学堂·百战程序员】";
    private static final String STATE_NAME = "";

    public static void main(String[] args) {
        // write your code here
        String path = PATH;
        File parent = new File(path);
        if (!parent.exists() || !parent.isDirectory()) {
            System.err.println("当前文件夹不存在或者不是一个目录");
            return;
        }

        stickFile(parent);
    }

    private static void stickFile(File file) {

        if (!file.exists()) return;
        if (file.isFile()) {
            String filename = file.getName();
            file.renameTo(new File(file.getParent(), filename.replaceAll(STICK_NAME, STATE_NAME)));
            return;
        }

        if (file.isDirectory()) {
            File[] childs = file.listFiles();
            if (childs != null) {
                for (File child : childs) {
                    stickFile(child);
                }
            }
            String filename = file.getName();
            file.renameTo(new File(file.getParent(), filename.replaceAll(STICK_NAME, STATE_NAME)));
        }
    }
}
