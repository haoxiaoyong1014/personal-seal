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


/**
 * Created by haoxy on 2018/12/17.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */

public class TestSeal {

    /**
     * @param fontText       :名字
     * @param fontFamilyTag: 字体   1:方正黑体,2:仿宋 3:楷体
     * @param colorTag:     字体颜色, 1:红色, 2黑色, 3:蓝色
     * @param shapeTag:      选择形状    1: 正方形, 2: 长方形
     */
    @Test
    public void testSealColor() throws Exception {
        //1.生成指定颜色的私章以及指定字体
        SealFont font = new SealFont("李四", FontFamily.Font_KaiTi, ColorFamily.Font_Red);
        SealUtil.handle(font);
    }


    @Test
    public void testSealSquare(){
        SealFont sealFont = new SealFont("哈哈哈", FontFamily.Font_FangSong, ColorFamily.Font_Red);
        AbstractSealSquare sealSquare = new SealSquare(sealFont);
        System.out.println(sealSquare.getSavePath());
    }

    @Test
    public void testSealRectangle(){
        SealFont sealFont = new SealFont("方术柯屎", FontFamily.Font_KaiTi, ColorFamily.Font_Black);
        AbstractSealRectangle sealRectangle=new SealRectangle(sealFont);
        System.out.println(sealRectangle.getSavePath());
    }
}
