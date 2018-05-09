package org.spring.cloud.common.web.result;

/**
 * Created by jiazaibo on 17-2-28.
 */
public class ResponseErrorResult extends ResponseResult {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
