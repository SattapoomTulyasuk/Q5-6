import java.io.File;

public class Showdir {
    public static void main(String[] args) {
        String path;
        path = "/home/poom/Desktop/Test dir";
        System.out.println(path.split("/")[path.split("/").length-1]);
        Showdirtree(path,0);
    }

    public static String Showdirtree (String dir,Integer tabcount) {
        File f = new File(dir);
        File[] files = f.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                for(int i=0;i<tabcount+1;i++){
                    System.out.print("\t");
                }
                System.out.print("|---");
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    Showdirtree(file.getAbsolutePath(),tabcount+1);
                }
            }
        }
        return null;
    }
}