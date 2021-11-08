import java.io.File;

public class Showdir {
    public static void main(String[] args) {
        String path, fileName, root;
        try {
            // path = args[0];
            // fileName = args[1];
            path = "/home/poom/Desktop";
            fileName = "Test dir";
            root = search(path, fileName);
        } catch (Exception ArrayIndexOutOfBounds) {
            System.out.println("Wrong parameter given");
            root = null;
        }
        if (root != null) {
            System.out.println(root+"\n\n");
            Showdirtree(root,0);
        } else {
            System.out.println("Can't find file/folder");
        }
    }


    public static String search(String rootPath, String fileName) {
        File f = new File(rootPath);
        File[] files = f.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (fileName.equals(file.getName())) {
                    System.out.println("\n\n\n\n\nFound. \n");
                    String path = rootPath + "/" + file.getName();
                    return path;
                }
                if (file.isDirectory()) {
                    System.out.println("Processing in " + file.getAbsolutePath());
                    String path = search(file.getAbsolutePath(), fileName);
                    if (path != null) {
                        return path;
                    }
                }
            }
        }
        return null;
    }


    public static String Showdirtree (String dir,Integer tabcount) {
        File f = new File(dir);
        File[] files = f.listFiles();
        System.out.println(f.getName());
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("\t"+file.getName());
                if (file.isDirectory()) {
                    Showdirtree(file.getAbsolutePath(),tabcount+1);
                }
            }
        }
        return null;
    }
}