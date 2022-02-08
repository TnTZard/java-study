package IO.file;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/12/20 16:36
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
//        File file = new File("E:\\thinkive\\project\\system-model\\oracle关键字.java");
//        System.out.print(readFile(file));
        try {
            changeName("E:\\thinkive\\temp\\tech替换\\src");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static final String replacePath ="E:\\thinkive\\temp\\tech替换\\src";

    public static void changeName(String path) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()){
                String orgName = files[i].toString();
                String name = files[i].getAbsolutePath();
                String path1 = name.replace(replacePath, "");
                File f = null;
                if (name.contains("md")) {
                    String replaceName = path1.replace("md", "uiMd");
                    f = new File("E:\\thinkive\\temp\\tech2\\" + replaceName);

                } else {
                    f = new File("E:\\thinkive\\temp\\tech2\\" + path1);
                }
                f.mkdirs();
                changeName(orgName);
            }else{
                File f = null;
                String name = files[i].getAbsolutePath();
                if (name.contains("Md")) {
                    String replaceName = name.replace("Md", "UiMd").replace("md", "uiMd")
                            .replace(replacePath, "E:\\thinkive\\temp\\tech2\\");
                    f = new File(replaceName);
                    try {
                        copyFileUsingJava7Files(files[i], f);
                    } catch (Exception e) {

                    }

                }
            }
        }
    }

    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
            Files.copy(source.toPath(), dest.toPath());
    }

    public static String readFile(File file) {
        // 读取文件内容public String readFile(){
        String path = "";
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append("," + "\"" + s + "\"");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }



}
