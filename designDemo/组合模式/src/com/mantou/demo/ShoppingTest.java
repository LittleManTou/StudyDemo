package com.mantou.demo;

import java.util.ArrayList;

/**
 * 最后“大袋子”中的内容有：{1 双李宁牌运动鞋（单价 198 元）、白色小袋子{2 包韶关香菇（单价 68 元）、
 * 3 包韶关红茶（单价 180 元）}、中袋子{1 个景德镇瓷器（单价 380 元）、红色小袋子{2 包婺源特产（单价 7.9 元）、
 * 1 张婺源地图（单价 9.9 元）}}}，现在要求编程显示李先生放在大袋子中的所有商品信息并计算要支付的总价
 */
public class ShoppingTest {
    public static void main(String[] args) {
        //构建袋子
        Bag b1 = new Bag("白色","大");
        Bag b2 = new Bag("白色","小");
        Bag b3 = new Bag("白色","中");
        Bag b4 = new Bag("红色","小");
        //构建商品
        Articles a1 = new Goods(198,"李宁牌运动鞋",1);
        Articles a2 = new Goods(68,"韶关香菇",2);
        Articles a3 = new Goods(180,"韶关红茶",3);
        Articles a4 = new Goods(380,"景德镇瓷器",1);
        Articles a5 = new Goods((float) 7.9,"婺源特产",2);
        Articles a6 = new Goods((float) 9.9,"婺源地图",1);
        //袋子装商品

        b4.addArticles(a5);//红色小袋子
        b4.addArticles(a6);
        b3.addArticles(a4);//白色中袋子
        b3.addArticles(b4);
        b2.addArticles(a3);//白色小袋子
        b2.addArticles(a2);
        b1.addArticles(a1);//白色大袋子
        b1.addArticles(b2);
        b1.addArticles(b3);
        //展示所有商品名称
        b1.show();
        //计算所有商品的总价格
        float total = b1.calculation();
        System.out.println("商品总价为:" + total + "元");
    }
}

//抽象构件
interface Articles {
    public float calculation(); //计算
    public void show();
}
//树叶构件
class Goods implements Articles {
    private float price ;
    private String name ;
    private Integer num ;
    //构造商品
    public Goods(float price, String name, Integer num) {
        this.price = price;
        this.name = name;
        this.num = num;
    }
    //计算该商品总价格
    @Override
    public float calculation() {
        return price * num;
    }
    //展示该商品名称
    @Override
    public void show() {
        System.out.println(name);
    }
}
//树枝构件
class Bag implements  Articles {
    ArrayList<Articles> list = new ArrayList<>();
    private String color ;
    private String size ;
    //构造
    public Bag(String color, String size) {
        this.color = color;
        this.size = size;
    }

    //添加商品
    public void addArticles(Articles articles) {
        list.add(articles);
    }
    //移除商品
    public void removeArticles(Articles articles) {
        list.remove(articles);
    }
    //计算价格
    @Override
    public float calculation() {
        float total = 0;
        for (Articles articles : list) {
            total += articles.calculation();
        }
        return total;
    }
    //展示商品信息
    @Override
    public void show() {
        System.out.println(color + size + "袋子中的商品包含:");
        for (Articles articles : list) {
            articles.show();
        }
    }
}

