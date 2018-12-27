package cn.haoxiaoyong.seal.operator.service;

import cn.haoxiaoyong.seal.operator.bean.SealFont;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/19.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface SealSquareProcessor {

    BufferedImage drawTreeSquare(SealFont font, int lineSize,
                                 int imageSize, int fixH, int fixW) throws Exception;

    BufferedImage drawFourSquare(BufferedImage bi, SealFont font, int lineSize, int imageSize, int fixH,
                                 int fixW, Color color);

}
