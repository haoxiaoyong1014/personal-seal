package cn.haoxiaoyong.seal.operator.tool;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.constant.ColorFamily;
import cn.haoxiaoyong.seal.operator.constant.Constant;
import cn.haoxiaoyong.seal.operator.constant.FontFamily;
import cn.haoxiaoyong.seal.operator.tool.abs.AbstractSealSquare;
import cn.haoxiaoyong.seal.operator.utils.BytesUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/19.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class SealSquare extends AbstractSealSquare implements Constant {


    public SealSquare(SealFont sealFont) {
        super(sealFont);
        try {
            this.handle(sealFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handle(SealFont sealFont) throws Exception {
        this.setAddString(sealFont.getFontText().length() == 2 ? PERSONAL_SEAL_ADD_TEXTS : PERSONAL_SEAL_ADD_TEXT);
        sealFont.setFontFamily(sealFont.getFontFamilyTag() == FontFamily.Font_HeiTi ? Font_HeiTi : (sealFont.getFontFamilyTag() == FontFamily.Font_FangSong ? Font_FangSong : Font_KaiTi));

        this.setSavePath(BytesUtils.storeBytes(BytesUtils.buildBytes(this.buildAndStorePersonSeal(sealFont)), PERSONAL_SEAL_SAVE_PATH));
    }

    public BufferedImage buildAndStorePersonSeal(SealFont font) throws Exception {
        return this.drawTreeSquare(font, PERSONAL_SEAL_LINE_SIZE, PERSONAL_SEAL_IMAGE_SIZE, fixH, fixW);
    }

    @Override
    protected BufferedImage buildBi(int imageSize, SealFont font) throws Exception {
        if (font == null || font.getFontText().length() < 2 || font.getFontText().length() > 4) {
            throw new Exception("FontText.length illegal!");
        }
        //1.画布
        BufferedImage bi = new BufferedImage(imageSize, imageSize / 2, BufferedImage.TYPE_4BYTE_ABGR);

        return bi;
    }

    /*@Override
    protected Graphics2D buildG2d(int imageSize, SealFont font) throws Exception {
        BufferedImage bi = buildBi(imageSize, font);
        Graphics2D g2d = bi.createGraphics();
        Color color = font.getColorTag() == ColorFamily.Font_Red ? Color.RED : (font.getColorTag() == ColorFamily.Font_Black ? Color.BLACK : Color.BLUE);
        //2.1设置画笔颜色
        g2d.setPaint(color);

        //2.2抗锯齿设置
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return g2d;
    }*/


    @Override
    public BufferedImage drawTreeSquare(SealFont font, int lineSize, int imageSize, int fixH, int fixW) throws Exception {
        BufferedImage bi = buildBi(imageSize, font);
        Graphics2D g2d = bi.createGraphics();
        Color color = font.getColorTag() == ColorFamily.Font_Red ? Color.RED : (font.getColorTag() == ColorFamily.Font_Black ? Color.BLACK : Color.BLUE);
        //2.1设置画笔颜色
        g2d.setPaint(color);
        //2.2抗锯齿设置
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (font.getFontText().length() == 2) {
            bi = DrawFontSquare.drawThreeFont(bi, g2d, font.setFontText(font.getFontText() + this.getAddString()), lineSize, imageSize, fixH, fixW, color);
        } else if (font.getFontText().length() == 3) {
            bi = DrawFontSquare.drawFourFont(bi, font.setFontText(font.getFontText() + this.getAddString()), lineSize, imageSize, fixH, fixW, color);
        } else {
            bi = drawFourSquare(bi, font, lineSize, imageSize, fixH, fixW, color);
        }
        return bi;
    }

    @Override
    public BufferedImage drawFourSquare(BufferedImage bi, SealFont font, int lineSize, int imageSize, int fixH, int fixW, Color color) {

        return DrawFontSquare.drawFourFont(bi, font, lineSize, imageSize, fixH, fixW, color);
    }


}
