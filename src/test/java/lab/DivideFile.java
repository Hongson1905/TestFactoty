package lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 
 *  文件分类
 * @author hgh
 * @date 2020/4/23 8:44
 */
public class DivideFile {


    public static void main(String[] args) {
        File s_dir = new File("F:\\Desktop\\NOW\\项目管理\\网源协调\\数据文件\\全文件");
        File t_dir = new File("F:\\Desktop\\NOW\\项目管理\\网源协调\\数据文件\\12类文件样例");
        divideFile(s_dir,t_dir);
    }


    public static void divideFile(File s_dir, File t_dir){
        if (!s_dir.exists())return;
        if (s_dir.isDirectory()){
            for (File file : s_dir.listFiles()) {
                divideFile(file,t_dir);
            }
        }else if (s_dir.isFile()){
            for (File t_file : t_dir.listFiles()) {
                if (t_file.isDirectory()){
                    if (s_dir.getName().trim().contains(t_file.getName().trim())){
                        String newFileName = s_dir.getName();
                        if (newFileName.contains("_")){
                            newFileName = newFileName.split("_")[1];
                        }
                        copyFile(s_dir,new File(t_file.getPath()+File.separator+newFileName));
                        return;
                    }
                }
            }
        }else {
            System.out.println("unknown file !!!");
        }
    }

    public static void copyFile(File from, File to){

        try (FileChannel input = new FileInputStream(from).getChannel();
             FileChannel output = new FileOutputStream(to).getChannel()
        ){
            output.transferFrom(input, 0, input.size());
            System.out.println("copy file " + from.getName() + " to " + to.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
