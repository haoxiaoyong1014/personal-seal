package cn.haoxiaoyong.seal.operator.tool;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.constant.Constant;
import cn.haoxiaoyong.seal.operator.constant.FontFamily;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * @Description: 印章工具类
 * @Author Ran.chunlin
 * @Date: Created in 18:24 2018-10-03
 */
public abstract class SealUtil implements Constant {

    /**
     * 默认从10x10的位置开始画，防止左上部分画布装不下
     */

    private static String addString;

    public static void handle(SealFont font) throws Exception {
         addString = font.getFontText().length() == 2 ? PERSONAL_SEAL_ADD_TEXTS : PERSONAL_SEAL_ADD_TEXT;

        //font.setFontFamily(font.getFontFamilyTag() == 1 ? BLACK_BODY : (font.getFontFamilyTag() == 2 ? IMITATION_SONG : CARCASS));
        font.setFontFamily(font.getFontFamilyTag() == FontFamily.Font_HeiTi ? Font_HeiTi : (font.getFontFamilyTag() == FontFamily.Font_FangSong ? Font_FangSong : Font_KaiTi));
        //if (font.getShapeTag() == 2) {
            storeBytes(buildBytes(DrawTwo.buildPersonSeal(PERSONAL_SEAL_IMAGE_SIZE, PERSONAL_SEAL_LINE_SIZE, font, addString)), PERSONAL_SEAL_SAVE_PATH);
        //}
      //  buildAndStorePersonSeal(PERSONAL_SEAL_IMAGE_SIZE, PERSONAL_SEAL_LINE_SIZE, font, addString, PERSONAL_SEAL_SAVE_PATH);
    }

    /**
     * 生成私人印章图片，并保存到指定路径
     *
     * @param lineSize  边线宽度
     * @param font      字体对象
     * @param addString 追加字符
     * @param fullPath  保存全路径
     * @throws Exception 异常
     */


    public static void buildAndStorePersonSeal(int imageSize, int lineSize, SealFont font, String addString,
                                               String fullPath) throws Exception {
        storeBytes(buildBytes(buildPersonSeal(imageSize, lineSize, font, addString)), fullPath);
    }

    /**
     * 生成印章图片的byte数组
     *
     * @param image BufferedImage对象
     * @return byte数组
     * @throws IOException 异常
     */
    public static byte[] buildBytes(BufferedImage image) throws Exception {

        try (ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
            //bufferedImage转为byte数组
            ImageIO.write(image, "png", outStream);
            return outStream.toByteArray();
        }
    }

    /**
     * 生成私人印章图片
     *
     * @param lineSize  线条粗细
     * @param font      字体对象
     * @param addString 是否添加文字，如“印”
     * @return BufferedImage对象
     * @throws Exception 异常
     */
    public static BufferedImage buildPersonSeal(int imageSize, int lineSize, SealFont font, String addString)
            throws Exception {
        if (font == null || font.getFontText().length() < 2 || font.getFontText().length() > 4) {
            throw new Exception("FontText.length illegal!");
        }

        int fixH = 18;
        int fixW = 2;

        //1.画布
        BufferedImage bi = new BufferedImage(imageSize, imageSize / 2, BufferedImage.TYPE_4BYTE_ABGR);

        //2.画笔
        Graphics2D g2d = bi.createGraphics();
        Color color = font.getColorTag() == 1 ? Color.RED : (font.getColorTag() == 2 ? Color.BLACK : Color.BLUE);
        //2.1设置画笔颜色
        g2d.setPaint(color);

        //2.2抗锯齿设置
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //3.写签名
        int marginW = fixW + lineSize;
        float marginH;
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle;
        Font f;

        if (font.getFontText().length() == 2) {
            if (addString != null && addString.trim().length() > 0) {
                //drawThreeFont
                bi = drawThreeFont(bi, g2d, font.setFontText(font.getFontText() + addString), lineSize, imageSize, fixH,
                        fixW, true, color);
            } else {
                f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());
                g2d.setFont(f);
                rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
                marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH - 4;
                g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
                marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ?
                        INIT_BEGIN :
                        font.getFontSpace());
                g2d.drawString(font.getFontText().substring(1), marginW, marginH);

                //拉伸
                BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
                Graphics2D ng2d = nbi.createGraphics();
                ng2d.setPaint(color);
                ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

                //画正方形
                ng2d.setStroke(new BasicStroke(lineSize));
                ng2d.drawRect(0, 0, imageSize, imageSize);
                ng2d.dispose();
                bi = nbi;
            }
        } else if (font.getFontText().length() == 3) {
            if (addString != null && addString.trim().length() > 0) {
                bi = drawFourFont(bi, font.setFontText(font.getFontText() + addString), lineSize, imageSize, fixH,
                        fixW, color);
            } else {
                //drawThreeFont
                bi = drawThreeFont(bi, g2d, font.setFontText(font.getFontText()), lineSize, imageSize, fixH, fixW,
                        false, color);
            }
        } else {
            //drawFourFont
            bi = drawFourFont(bi, font, lineSize, imageSize, fixH, fixW, color);
        }

        return bi;
    }

    /**
     * 将byte数组保存为本地文件
     *
     * @param buf      byte数组
     * @param fullPath 文件全路径
     * @throws IOException 异常
     */
    private static void storeBytes(byte[] buf, String fullPath) throws IOException {
        Random random = new Random();
        String fileName = "personalSeal" + System.currentTimeMillis() + "" + random.nextInt(1000) + ".png";
        File file = new File(fullPath + fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            //1.如果父目录不存在，则创建
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }

            //2.写byte数组到文件
            bos.write(buf);
        }
    }



    /**
     * 画三字
     *
     * @param bi        图片
     * @param g2d       原画笔
     * @param font      字体对象
     * @param lineSize  线宽
     * @param imageSize 图片尺寸
     * @param fixH      修复膏
     * @param fixW      修复宽
     * @param isWithYin 是否含有“印”
     */
    private static BufferedImage drawThreeFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
                                               int imageSize, int fixH, int fixW, boolean isWithYin, Color color) {
        fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        Font f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH;
        int oldW = marginW;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(color);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画正方形
        ng2d.setStroke(new BasicStroke(6));
        ng2d.drawRect(0, 0, imageSize, imageSize);
        //ng2d.drawRect(15, 15, 240, 100);
        ng2d.dispose();
        bi = nbi;

        g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        marginW +=
                Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());

        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginH += Math.abs(rectangle.getHeight());

        g2d.drawString(font.getFontText().substring(3, 4), oldW, marginH);

        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);
        return bi;
    }

    /**
     * 画四字
     *
     * @param bi        图片
     * @param font      字体对象
     * @param lineSize  线宽
     * @param imageSize 图片尺寸
     * @param fixH      修复膏
     * @param fixW      修复宽
     */
    private static BufferedImage drawFourFont(BufferedImage bi, SealFont font, int lineSize, int imageSize, int fixH,
                                              int fixW, Color color) {
        int marginW = fixW + lineSize;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(color);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画正方形
        ng2d.setStroke(new BasicStroke(lineSize));
        ng2d.drawRect(0, 0, imageSize, imageSize);
        ng2d.dispose();
        bi = nbi;

        Graphics2D g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext context = g2d.getFontRenderContext();

        Font f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());//font.getFontFamily()
        g2d.setFont(f);
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH;
        System.out.println("字体名称:" + f.getName());
        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        int oldW = marginW;
        marginW +=
                Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());

        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginH += Math.abs(rectangle.getHeight());

        g2d.drawString(font.getFontText().substring(3, 4), oldW, marginH);

        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);
        return bi;
    }
}
