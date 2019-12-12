package cn.haoxiaoyong.seal.operator;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.constant.ColorFamily;
import cn.haoxiaoyong.seal.operator.constant.FontFamily;
import cn.haoxiaoyong.seal.operator.tool.SealRectangle;
import cn.haoxiaoyong.seal.operator.tool.abs.AbstractSealRectangle;
import cn.haoxiaoyong.seal.operator.tool.abs.AbstractSealSquare;
import cn.haoxiaoyong.seal.operator.tool.SealSquare;
import cn.haoxiaoyong.seal.operator.tool.SealUtil;
import org.junit.Test;

import java.io.*;
import org.apache.commons.codec.binary.Base64;


/**
 * Created by haoxy on 2018/12/17.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */

public class TestSeal {

    /**
     * @param fontText       :名字
     * @param fontFamilyTag: 字体   1:方正黑体,2:仿宋 3:楷体
     * @param colorTag:      字体颜色, 1:红色, 2黑色, 3:蓝色
     * @param shapeTag:      选择形状    1: 正方形, 2: 长方形
     */
    @Test
    public void testSealColor() throws Exception {
        //1.生成指定颜色的私章以及指定字体
        SealFont font = new SealFont("李四", FontFamily.Font_KaiTi, ColorFamily.Font_Red);
        SealUtil.handle(font);
    }


    @Test
    public void testSealSquare() {
        SealFont sealFont = new SealFont("大风好", FontFamily.Font_KaiTi, ColorFamily.Font_Red);
        AbstractSealSquare sealSquare = new SealSquare(sealFont);
        System.out.println(sealSquare.getSavePath());
    }

    /**
     * 长方形
     * 阿不力米提·阿
     */
    @Test
    public void testSealRectangle() {
        SealFont sealFont = new SealFont("阿不力米", 3, ColorFamily.Font_Red);
        AbstractSealRectangle sealRectangle = new SealRectangle(sealFont);
        System.out.println(sealRectangle.getSavePath());
    }


    /**
     * @param path
     * @return String
     * @description 将文件转base64字符串
     * @date 2018年3月20日
     * @author changyl
     */
 /*   public static String fileToBase64(String path) {
        String base64 = null;
        InputStream in = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }*/

    public static void base64ToFile(String base64, String fileName) {
        File file = null;
        //创建文件目录
        String filePath="/tmp/image/";
        File  dir=new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            byte[] bytes = Base64.decodeBase64(base64.getBytes());
            file=new File(filePath+"/"+fileName);
            fos = new java.io.FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        base64ToFile("data:image/png;base64,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","西安市住房和城乡建设局.png");
    }
}
