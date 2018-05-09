package org.spring.cloud.common.web.result;

/**
 * Created by jiazaibo on 17-2-28.
 */
public class ResponseDataResult extends ResponseResult {

    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResponseDataResult setResponseResult(Object data) {
        ResponseDataResult r = new ResponseDataResult();
        r.setResult(data);
        return r;
    }

}
