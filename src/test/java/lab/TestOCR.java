package lab;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * 
 * @author hgh
 * @date 2020/4/10 11:26
 */
public class TestOCR {

    public static void main(String[] args) {
        File imageFile = new File("F:\\Desktop/123.jpg");
        Tesseract tessreact = new Tesseract();
        //需要指定训练集 训练集到 https://github.com/tesseract-ocr/tessdata 下载。
        tessreact.setDatapath("D:\\Tesseract-OCR\\tessdata");
        //注意  默认是英文识别，如果做中文识别，需要单独设置。
        tessreact.setLanguage("chi_sim");
        try {
            String result = tessreact.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
