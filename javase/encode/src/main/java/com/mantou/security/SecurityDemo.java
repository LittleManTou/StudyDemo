package com.mantou.security;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * @author mantou
 * @date 2021/11/24 15:41
 * @desc 加密解密的各种方式
 */
public class SecurityDemo {
    //1.采用抑或的方式进行加密解密，可逆
    //特点： 一个数异或两次以后是原数本身
    public static String xor(String input) {
        final Integer  code = 3000 ;
        //例如 String("abc")  --->  String("xyz");
        char[] chars = input.toCharArray();  //转成字符数组
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ code) ;
        }
        return new String(chars);
    }
    //2.MD5加密 , 速度快
    //特点：不可逆
    public static String md5Encode(byte[] bytes) {
        return DigestUtils.md5Hex(bytes);//需要Commons-codec 包
    }

    //3.SHA256加密 ， 安全性更高
    //特点：不可逆
    public static String sha256Encode(byte[] bytes) {
        return DigestUtils.sha256Hex(bytes);
    }

    //4.Base64加密
    //特点：可逆
    public static String base64Encode(byte[] bytes){
        return Base64.encode(bytes);
    }

    //4.Base64解密
    //特点：可逆
    public static byte[] base64Decode(String encode){
        return Base64.decode(encode);
    }


    public static void main(String[] args) {
        //1.测试^加密解密
        //加密
        String mantouEncode = xor("mantou");
        System.out.println(mantouEncode);
        //解密
        String deCode = xor(mantouEncode);
        System.out.println(deCode);      //可逆


        //2.base64

        String md5Encode = md5Encode("mantou".getBytes());
        System.out.println(md5Encode);

        //3.SHA256加密
        String sha256Encode = sha256Encode("mantou".getBytes());
        System.out.println(sha256Encode);

        //4.Base64加密解密
        String base64Encode= base64Encode("mantou".getBytes());
        System.out.println(base64Encode);
        byte[] bytes = base64Decode(base64Encode);
        System.out.println(new String(bytes));

    }





}
