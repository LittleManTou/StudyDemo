package com.mantou.entity;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by mantou
 */
public class AppMessage<T> {


  /**
   * 类型
   */
  private MessageType type;

  /**
   * 内容
   */
  private String content;

  private String code;

  /**
   * 数据
   */
  private T data;

  public AppMessage() {

  }

  public AppMessage(MessageType type, String content, String code, T data) {
    this.type = type;
    this.content = content;
    this.code = code;
    this.data = data;
  }

  public static AppMessage success() {
    return AppMessage.success("");
  }

  public static AppMessage successOk() {
    return AppMessage.success("ok");
  }

  public static <T> AppMessage success(T data) {
    return new AppMessage<>(MessageType.success, "ok", "1", data);
  }

  public static <T> AppMessage success(List<T> data, Long totalLen) {
    LinkedHashMap<String, Object> jsonObject = new LinkedHashMap<>();
    jsonObject.put("list", data);
    jsonObject.put("total", totalLen.toString());
    return new AppMessage<>(MessageType.success, "ok", "1", jsonObject);
  }

  public static AppMessage error(String errorMsg) {
    return new AppMessage(MessageType.error, errorMsg, "2", "");
  }

  public static AppMessage tokenError(String errorMsg) {
    if (StringUtils.isEmpty(errorMsg)) {
      return tokenError();
    }
    return new AppMessage<>(MessageType.error, errorMsg, "-1", "");
  }

  public static AppMessage tokenError() {
    return new AppMessage<>(MessageType.error, "", "-1", "");
  }

  public MessageType getType() {
    return type;
  }

  public void setType(MessageType type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String toJSON() {
    return JSONObject.toJSONString(this);
  }
}
