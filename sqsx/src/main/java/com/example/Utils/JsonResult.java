package com.example.Utils;
import java.io.Serializable;

public class JsonResult implements Serializable {

     private static final long serialVersionUID = 4997293587553904193L;
     /** * 响应状态 */
     private Integer status;
    /** * 响应信息 */
     private String msg;
    /** * 响应数据 */
    private Object data;

    public JsonResult(Integer status, String msg, Object data) { this.status = status; this.msg = msg; this.data = data; }
    public static JsonResult build(Integer status,String msg,Object data){ return new JsonResult(status,msg,data); }
    public static JsonResult ok(Object data){ return new JsonResult(200,"ok",data); }
    public static JsonResult refuse(){ return new JsonResult(400,"refuse",null); }
    public static JsonResult ok(){ return JsonResult.ok(null); }
    public static JsonResult errMsg(String msg){ return new JsonResult(500,msg,null); }
    public static JsonResult errMap(Object data){ return new JsonResult(501,"error",data); }
    public static JsonResult errTokenMsg(String msg){ return new JsonResult(502,msg,null); }
    public static JsonResult errException(String msg){ return new JsonResult(555,msg,null); }
    public JsonResult() { }

    @Override
    public String toString() { return "JsonResult{" + "status=" + status + ", msg='" + msg + '\'' + ", data=" + data + '}'; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

}







