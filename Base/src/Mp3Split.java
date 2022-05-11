import java.io.*;

public class Mp3Split {
    public static void cutMusic() throws IOException {
        File file = new File("D:\\softData\\xmind\\思维导图\\语音文件\\20220504\\20220504 第二.mp3");
        File file2 = new File("D:");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;

        int len = 0;
        int x = 0;
        int y = 1020 * 1024 * 4;
        byte[] one = new byte[y];
        if (file.length() % y != 0) {
            x = (int) (file.length() / y + 1);
        } else if (file.length() % y == 0) {
            x = (int) (file.length() / y);
        }
        for (int i = 1; i <= x; i++) {
            len = fis.read(one);
            fos = new FileOutputStream(new File(file2, i + ".mp3"));
            fos.write(one, 0, len);
        }
        fis.close();
        fos.close();
    }

    public static void mergeMusic() throws IOException {
        File file = new File("E:\\merge.flac");
        File file2 = new File("E:\\music");
// if(file.exists()!=true) {
// file.createNewFile();
// }
        File[] f = file2.listFiles();
        FileInputStream fis = null;
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos, 1024 * 1024);
        int len = 0;
        for (int i = 0; i < f.length; i++) {
            fis = new FileInputStream(f[i]);
            BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 1024);
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
            fos.flush();
            fis.close();
        }
        bos.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        cutMusic();
//        mergeMusic();
// TODO Auto-generated method stub
    }
}