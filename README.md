####  persional-seal

**使用方式:**

* 引入maven依赖

```xml
<groupId>cn.haoxiaoyong.personal.seal</groupId>
<artifactId>seal-operator</artifactId>
<version>v1.0.1</version>
```
**生成正方形签章**

```java
@Test
    public void testSealSquare(){
        SealFont sealFont = new SealFont("哈哈哈", FontFamily.Font_FangSong, ColorFamily.Font_Red);
        AbstractSealSquare sealSquare = new SealSquare(sealFont);
        System.out.println(sealSquare.getSavePath());//返回生成签章的地址
    }

```

* 参数说明

        String fontText: 个人姓名
        int fontFamilyTag: 字体,例如:仿宋,楷体,正方黑体
        int colorTag: 字体颜色,例如: 红色,黑色,蓝色
 
 
![image](https://github.com/haoxiaoyong1014/best-pay-demo/raw/master/src/main/java/com/github/lly835/Images/personalSeal1545881514300342.png) 

**生成长方形签章**    

```java
 @Test
    public void testSealRectangle(){
        SealFont sealFont = new SealFont("方术柯", FontFamily.Font_KaiTi, ColorFamily.Font_Black);
        AbstractSealRectangle sealRectangle=new SealRectangle(sealFont);
        System.out.println(sealRectangle.getSavePath());//返回生成签章的地址
    }
``` 

* 参数同上 

![image](https://github.com/haoxiaoyong1014/best-pay-demo/raw/master/src/main/java/com/github/lly835/Images/personalSeal1545275357787669.png) 

 