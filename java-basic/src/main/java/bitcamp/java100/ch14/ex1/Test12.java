package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test12 {
    public static void main(String[] args) throws Exception {
        
        File file = new File(".");
        
        printFiles(file);

    }
    
    static void printFiles(File dir) throws Exception {
        File[] files = dir.listFiles();
        int i = 0;
        String path;
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                path = f.getCanonicalPath();
                i = path.indexOf("bin") + 4;
                System.out.println(
                        path.substring(i).replace(".class", "").replace("/", ",").replace("\\","."));
            }
            if (f.isDirectory()) {
                printFiles(f);
            }
        }
    }

}
