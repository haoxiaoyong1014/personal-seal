package cn.haoxiaoyong.seal.operator.bean;

/**
 * @Description: 印章字体类
 * @Author Ran.chunlin
 * @Date: Created in 12:17 2018-10-04
 */
public class SealFont {
    /**
     * @param fontText       :名字
     * @param fontFamilyTag: 字体   1:方正黑体,2:仿宋 3:楷体
     * @param colorTag:      字体颜色, 1:红色, 2黑色, 3:蓝色
     */
    public SealFont(String fontText, int fontFamilyTag, int colorTag) {
        this.fontText = fontText;
        this.fontFamilyTag = fontFamilyTag;
        this.colorTag = colorTag;
    }

    public SealFont() {

    }

    /**
     * 字体内容
     */
    private String fontText;
    /**
     * 字形名
     */
    private String fontFamily;
    /**
     * 字体大小
     */
    private Integer fontSize = 120;
    /**
     * 字距
     */
    private Double fontSpace;
    /**
     * 边距（环边距或上边距）
     */
    private Integer marginSize;

    /**
     * 字体类型
     * 1:方正黑体,2:仿宋 3:楷体
     */
    private Integer fontFamilyTag;

    /**
     * 字体颜色,
     * 1:红色, 2黑色, 3:蓝色
     */
    private Integer colorTag;


    public Integer getFontFamilyTag() {
        return fontFamilyTag;
    }

    public void setFontFamilyTag(Integer fontFamilyTag) {
        this.fontFamilyTag = fontFamilyTag;
    }

    public Integer getColorTag() {
        return colorTag;
    }

    public void setColorTag(Integer colorTag) {
        this.colorTag = colorTag;
    }


    public SealFont setFontSpace(Double fontSpace) {
        this.fontSpace = fontSpace;
        return this;
    }

    public SealFont setMarginSize(Integer marginSize) {
        this.marginSize = marginSize;
        return this;
    }

    public SealFont setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public SealFont setFontText(String fontText) {
        this.fontText = fontText;
        return this;
    }

    public SealFont setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }


    public String getFontText() {
        return fontText;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Double getFontSpace() {
        return fontSpace;
    }

    public Integer getMarginSize() {
        return marginSize;
    }

}
