package org.spring.cloud.common.web.result;

/**
 * Created by jiazaibo on 17-3-1.
 */
public class ResponsePaginationDataResult extends ResponseResult {

    private long total;
    private Object result;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResponsePaginationDataResult setPaginationDataResult(long total, Object result) {
        ResponsePaginationDataResult r = new ResponsePaginationDataResult();
        r.setTotal(total);
        r.setResult(result);
        return r;
    }
}
