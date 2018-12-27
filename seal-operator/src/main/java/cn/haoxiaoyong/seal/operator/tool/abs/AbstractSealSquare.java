package cn.haoxiaoyong.seal.operator.tool.abs;

import cn.haoxiaoyong.seal.operator.bean.SealFont;
import cn.haoxiaoyong.seal.operator.service.SealSquareProcessor;

import java.awt.image.BufferedImage;

/**
 * Created by haoxy on 2018/12/19.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public abstract class AbstractSealSquare implements SealSquareProcessor {

    private SealFont sealFont;

    private String savePath;

    private String addString;

    public AbstractSealSquare(SealFont sealFont) {
        this.sealFont = sealFont;
    }

    protected abstract BufferedImage buildBi(int imageSize, SealFont sealFont) throws Exception;


    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getAddString() {
        return addString;
    }

    public void setAddString(String addString) {
        this.addString = addString;
    }

}
