package cn.haoxiaoyong.seal.operator.tool;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.constant.Constant;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/18.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class DrawTwo implements Constant {

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

        /*//3.写签名
        int marginW = fixW + lineSize;
        float marginH;
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle;
        Font f;*/
        if (font.getFontText().length() == 2) {
            bi = drawTwoFont(bi, g2d, font.setFontText(font.getFontText()), lineSize, imageSize, fixH,
                    fixW, true, color);
        }
        return bi;
    }

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
     * @param isWithYin
     * @param color
     * @return
     */
    private static BufferedImage drawTwoFont(BufferedImage bi, Graphics2D g2d, SealFont font, int lineSize,
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

        //画长方形
        ng2d.setStroke(new BasicStroke(6));
        //ng2d.drawRect(0, 0, imageSize, imageSize);
        ng2d.drawRect(10, 10, 280, 130);
        ng2d.dispose();
        bi = nbi;

        g2d = bi.createGraphics();
        g2d.setPaint(color);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);
        /*marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        marginW += Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());

        g2d.drawString(font.getFontText().substring(3, 4), marginW, marginH);*/
        return bi;
    }
}
