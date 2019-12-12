package cn.haoxiaoyong.seal.operator.tool;

import cn.haoxiaoyong.seal.operator.bean.SealFont;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/19.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class DrawFontRectangle {

    public final static int INIT_BEGIN = 10;

    /**
     * 画长方形2字
     *
     * @param bi
     * @param g2d
     * @param font
     * @param lineSize
     * @param imageSize
     * @param fixH
     * @param fixW
     * @param color
     * @return
     */
    public static BufferedImage drawTwoFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
                                            int imageSize, int fixH, int fixW, Color color) {
        fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        Font f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = 180;
        //float marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH;
        int oldW = marginW;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(color);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画长方形
        ng2d.setStroke(new BasicStroke(6));
        ng2d.drawRect(10, 70, 280, 140);
        ng2d.dispose();
        bi = nbi;

        g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);

        return bi;
    }

    /**
     * 画长方形3字
     *
     * @param bi
     * @param g2d
     * @param font
     * @param lineSize
     * @param imageSize
     * @param fixH
     * @param fixW
     * @param color
     * @return
     */
    public static BufferedImage drawThreeFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
                                              int imageSize, int fixH, int fixW, Color color) {
        fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        Font f = new Font(font.getFontFamily(), Font.BOLD, 80);
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = 180;
        int oldW = marginW;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(color);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画长方形
        ng2d.setStroke(new BasicStroke(6));
        ng2d.drawRect(10, 100, 280, 110);
        ng2d.dispose();
        bi = nbi;

        g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        /*marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());

        g2d.drawString(font.getFontText().substring(3, 4), marginW, marginH);*/
        return bi;
    }

    /**
     * 画长方形4字
     *
     * @param bi
     * @param g2d
     * @param font
     * @param lineSize
     * @param imageSize
     * @param fixH
     * @param fixW
     * @param color
     * @return
     */
    public static BufferedImage drawFourFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
                                             int imageSize, int fixH, int fixW, Color color) {
        //fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        int length = font.getFontText().length();
        int fontSize = 56;
        float marginH = 160;
        Font f = null;
        switch (length) {
            case 4:
                f = new Font(font.getFontFamily(), Font.BOLD, fontSize);
                //拉伸
                BufferedImage nbi4 = new BufferedImage(imageSize, imageSize, bi.getType());
                Graphics2D ng2d4 = nbi4.createGraphics();
                ng2d4.setPaint(color);
                ng2d4.drawImage(bi, 0, 0, imageSize, imageSize, null);
                //画长方形
                ng2d4.setStroke(new BasicStroke(5));
                ng2d4.drawRect(10, 100, 280, 86);
                ng2d4.dispose();
                bi = nbi4;
                break;
            case 5:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 44);
                //拉伸
                BufferedImage nbi5 = new BufferedImage(imageSize, imageSize, bi.getType());
                Graphics2D ng2d5 = nbi5.createGraphics();
                ng2d5.setPaint(color);
                ng2d5.drawImage(bi, 0, 0, imageSize, imageSize, null);
                //画长方形
                ng2d5.setStroke(new BasicStroke(5));
                ng2d5.drawRect(10, 100, 280, 86);
                ng2d5.dispose();
                bi = nbi5;
                break;
            case 6:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 35);
                //拉伸
                BufferedImage nbi6 = new BufferedImage(imageSize, imageSize, bi.getType());
                Graphics2D ng2d6 = nbi6.createGraphics();
                ng2d6.setPaint(color);
                ng2d6.drawImage(bi, 0, 0, imageSize, imageSize, null);
                //画长方形
                ng2d6.setStroke(new BasicStroke(5));
                ng2d6.drawRect(10, 100, 280, 86);
                ng2d6.dispose();
                bi = nbi6;
                break;
            case 7:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 32);
                //拉伸
                BufferedImage nbi7 = new BufferedImage(320, 320, bi.getType());
                Graphics2D ng2d7 = nbi7.createGraphics();
                ng2d7.setPaint(color);
                ng2d7.drawImage(bi, 0, 0, 320, 320, null);
                //画长方形
                ng2d7.setStroke(new BasicStroke(5));
                ng2d7.drawRect(10, 100, 300, 86);
                ng2d7.dispose();
                bi = nbi7;
                break;
            case 8:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 27);
                //拉伸
                BufferedImage nbi8 = new BufferedImage(320, 320, bi.getType());
                Graphics2D ng2d8 = nbi8.createGraphics();
                ng2d8.setPaint(color);
                ng2d8.drawImage(bi, 0, 0, 320, 320, null);
                //画长方形
                ng2d8.setStroke(new BasicStroke(5));
                ng2d8.drawRect(10, 100, 300, 86);
                ng2d8.dispose();
                bi = nbi8;
                break;
            case 9:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 23);
                //拉伸
                BufferedImage nbi9 = new BufferedImage(320, 320, bi.getType());
                Graphics2D ng2d9 = nbi9.createGraphics();
                ng2d9.setPaint(color);
                ng2d9.drawImage(bi, 0, 0, 320, 320, null);
                //画长方形
                ng2d9.setStroke(new BasicStroke(5));
                ng2d9.drawRect(10, 100, 300, 86);
                ng2d9.dispose();
                bi = nbi9;
                break;
            case 10:
                marginH = 153;
                f = new Font(font.getFontFamily(), Font.BOLD, 22);
                //拉伸
                BufferedImage nbi10 = new BufferedImage(340, 340, bi.getType());
                Graphics2D ng2d10 = nbi10.createGraphics();
                ng2d10.setPaint(color);
                ng2d10.drawImage(bi, 0, 0, 340, 340, null);
                //画长方形
                ng2d10.setStroke(new BasicStroke(5));
                ng2d10.drawRect(10, 100, 320, 86);
                ng2d10.dispose();
                bi = nbi10;
                break;
            case 11:
                marginH = 150;
                f = new Font(font.getFontFamily(), Font.BOLD, 20);
                //拉伸
                BufferedImage nbi11 = new BufferedImage(360, 360, bi.getType());
                Graphics2D ng2d11 = nbi11.createGraphics();
                ng2d11.setPaint(color);
                ng2d11.drawImage(bi, 0, 0, 360, 360, null);
                //画长方形
                ng2d11.setStroke(new BasicStroke(5));
                ng2d11.drawRect(10, 100, 340, 86);
                ng2d11.dispose();
                bi = nbi11;
                break;
            case 12:
                marginH = 150;
                f = new Font(font.getFontFamily(), Font.BOLD, 17);
                //拉伸
                BufferedImage nbi12 = new BufferedImage(360, 360, bi.getType());
                Graphics2D ng2d12 = nbi12.createGraphics();
                ng2d12.setPaint(color);
                ng2d12.drawImage(bi, 0, 0, 360, 360, null);
                //画长方形
                ng2d12.setStroke(new BasicStroke(5));
                ng2d12.drawRect(10, 100, 340, 86);
                ng2d12.dispose();
                bi = nbi12;
                break;
            case 13:
                marginH = 150;
                f = new Font(font.getFontFamily(), Font.BOLD, 17);
                //拉伸
                BufferedImage nbi13 = new BufferedImage(380, 380, bi.getType());
                Graphics2D ng2d13 = nbi13.createGraphics();
                ng2d13.setPaint(color);
                ng2d13.drawImage(bi, 0, 0, 380, 380, null);
                //画长方形
                ng2d13.setStroke(new BasicStroke(5));
                ng2d13.drawRect(10, 100, 360, 86);
                ng2d13.dispose();
                bi = nbi13;
                break;

            case 14:
                marginH = 150;
                f = new Font(font.getFontFamily(), Font.BOLD, 15);
                //拉伸
                BufferedImage nbi14 = new BufferedImage(380, 380, bi.getType());
                Graphics2D ng2d14 = nbi14.createGraphics();
                ng2d14.setPaint(color);
                ng2d14.drawImage(bi, 0, 0, 380, 380, null);
                //画长方形
                ng2d14.setStroke(new BasicStroke(5));
                ng2d14.drawRect(10, 100, 360, 86);
                ng2d14.dispose();
                bi = nbi14;
                break;
            case 15:
                marginH = 150;
                f = new Font(font.getFontFamily(), Font.BOLD, 13);
                //拉伸
                BufferedImage nbi15 = new BufferedImage(380, 380, bi.getType());
                Graphics2D ng2d15 = nbi15.createGraphics();
                ng2d15.setPaint(color);
                ng2d15.drawImage(bi, 0, 0, 380, 380, null);
                //画长方形
                ng2d15.setStroke(new BasicStroke(5));
                ng2d15.drawRect(10, 100, 360, 86);
                ng2d15.dispose();
                bi = nbi15;
                break;
        }
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);

        //拉伸

        g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        System.out.println(font.getFontText().length());

        for (int i = 0; i < font.getFontText().length(); i++) {
            int marginW2 = marginW;
            g2d.drawString(font.getFontText().substring(i, i + 1), marginW2, marginH);
            marginW2 += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
            marginW = marginW2;
        }
       /* g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(3, 4), marginW, marginH);*/


        return bi;
    }
}
