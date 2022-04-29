package com.mantou.test;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MyReadXml {
    public static Object getObjet(){
        Object obj = null ;
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document parse = dBuilder.parse("抽象工厂/src/com/mantou/config/config.xml");
            NodeList className = parse.getElementsByTagName("className");
            Node firstChild = className.item(0).getFirstChild();
            String cName = "com.mantou.test." + firstChild.getNodeValue();
            Class<?> clazz = Class.forName(cName);
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
