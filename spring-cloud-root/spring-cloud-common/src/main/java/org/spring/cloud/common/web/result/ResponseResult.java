package org.spring.cloud.common.web.result;

/**
 * Created by jiazaibo on 17-2-28.
 */
public abstract class ResponseResult {

    private boolean hasError;

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}
