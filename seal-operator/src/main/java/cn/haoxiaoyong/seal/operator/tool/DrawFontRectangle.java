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
        fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        Font f = new Font(font.getFontFamily(), Font.BOLD, 56);
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = 160;
        int oldW = marginW;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(color);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画长方形
        ng2d.setStroke(new BasicStroke(6));
        ng2d.drawRect(10, 100, 280, 86);
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
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(3, 4), marginW, marginH);
        return bi;
    }
}
