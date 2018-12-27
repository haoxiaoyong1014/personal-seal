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
public class DrawFontSquare  {

    public final static int INIT_BEGIN = 10;
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
     */
    protected static BufferedImage drawThreeFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
                                                 int imageSize, int fixH, int fixW, Color color) {
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
        ng2d.setStroke(new BasicStroke(lineSize));
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
    protected static BufferedImage drawFourFont(BufferedImage bi, SealFont font, int lineSize, int imageSize, int fixH,
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
