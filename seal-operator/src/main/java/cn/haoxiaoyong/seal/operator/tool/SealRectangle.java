package cn.haoxiaoyong.seal.operator.tool;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.constant.ColorFamily;
import cn.haoxiaoyong.seal.operator.constant.Constant;
import cn.haoxiaoyong.seal.operator.constant.FontFamily;
import cn.haoxiaoyong.seal.operator.tool.abs.AbstractSealRectangle;
import cn.haoxiaoyong.seal.operator.utils.BytesUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/19.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class SealRectangle extends AbstractSealRectangle implements Constant {

    public SealRectangle(SealFont sealFont) {
        super(sealFont);
        try {
            this.handle(sealFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handle(SealFont sealFont) throws Exception {
        sealFont.setFontFamily(sealFont.getFontFamilyTag() == FontFamily.Font_HeiTi ? Font_HeiTi : (sealFont.getFontFamilyTag() == FontFamily.Font_FangSong ? Font_FangSong : Font_KaiTi));
        this.setSavePath(BytesUtils.storeBytes(BytesUtils.buildBytes(this.buildAndStorePersonSeal(sealFont)), PERSONAL_SEAL_SAVE_PATH));
    }

    @Override
    public BufferedImage buildAndStorePersonSeal(SealFont sealFont) throws Exception {

        return this.drawTwoRectangle(sealFont, PERSONAL_SEAL_LINE_SIZE, PERSONAL_SEAL_IMAGE_SIZE, fixH, fixW);
    }

    @Override
    protected BufferedImage buildBi(int imageSize, SealFont sealFont) throws Exception {
        if (sealFont == null || sealFont.getFontText().length() < 2 || sealFont.getFontText().length() > 4) {
            throw new Exception("FontText.length illegal!");
        }
        //1.画布
        BufferedImage bi = new BufferedImage(imageSize, imageSize / 2, BufferedImage.TYPE_4BYTE_ABGR);
        return bi;
    }


    @Override
    public BufferedImage drawTwoRectangle(SealFont font, int lineSize, int imageSize, int fixH, int fixW) throws Exception {
        BufferedImage bi = buildBi(imageSize, font);
        Graphics2D g2d = bi.createGraphics();
        Color color = font.getColorTag() == ColorFamily.Font_Red ? Color.RED : (font.getColorTag() == ColorFamily.Font_Black ? Color.BLACK : Color.BLUE);
        //2.1设置画笔颜色
        g2d.setPaint(color);
        //2.2抗锯齿设置`
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (font.getFontText().length() == 2) {
            bi = DrawFontRectangle.drawTwoFont(bi, g2d, font, lineSize, imageSize, fixH, fixW, color);
        } else if (font.getFontText().length() == 3) {
            bi = DrawFontRectangle.drawThreeFont(bi, g2d, font, lineSize, imageSize, fixH, fixW, color);
        } else {
            bi = DrawFontRectangle.drawFourFont(bi, g2d, font, lineSize, imageSize, fixH, fixW, color);
        }
        return bi;
    }
}
