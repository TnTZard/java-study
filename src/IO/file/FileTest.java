package IO.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/9/7 11:00
 */
public class FileTest {

    public static void main(String[] args) {
        List<String> list = getAllFile("E:\\thinkive\\gitlab-test\\cust\\alibaba\\testGroup\\234", false);
        System.out.println(list);
    }

    private static List<String> getAllFile(String path, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(path);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if(isAddDirectory){
                    list.add(file.getAbsolutePath());
                }
                list.addAll(getAllFile(file.getAbsolutePath(),isAddDirectory));
            } else {
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }
}
