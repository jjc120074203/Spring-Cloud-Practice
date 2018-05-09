package org.spring.cloud.common.exception;

/**
 * Created by xiaoman on 17-2-28.
 */
public class CIBaseException extends RuntimeException {
    private static final long serialVersionUID = 5298104877959869276L;
    public static final int UNKNOWN_EXCEPTION = 0;
    public static final int BIZ_EXCEPTION = 1;
    public static final int TIMEOUT_EXCEPTION = 2;
    public static final int FORBIDDEN_EXCEPTION = 3;
    public static final int CISYS_EXCEPTION = 4;

    private int typecode = BIZ_EXCEPTION;// CIBaseException，异常类型用tpecode表示
    private String errCode;

    public CIBaseException() {
        super();
    }

    public CIBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CIBaseException(String message) {
        super(message);
    }

    public CIBaseException(Throwable cause) {
        super(cause);
    }


    public CIBaseException(int type, String errCode) {
        super();
        this.typecode = type;
        this.errCode = errCode;
    }

    public CIBaseException(int type, String errCode, String message, Throwable cause) {
        super(message, cause);
        this.typecode = type;
        this.errCode = errCode;
    }

    public CIBaseException(int type, String errCode, String message) {
        super(message);
        this.typecode = type;
        this.errCode = errCode;
    }

    public CIBaseException(int type, String errCode, Throwable cause) {
        super(cause);
        this.typecode = type;
        this.errCode = errCode;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public boolean forbiddenException() {
        return (typecode == FORBIDDEN_EXCEPTION);
    }

    public boolean unkownException() {
        return (typecode == UNKNOWN_EXCEPTION);
    }

    public boolean bizException() {
        return (typecode == BIZ_EXCEPTION);
    }

    public boolean timeoutException() {
        return (typecode == TIMEOUT_EXCEPTION);
    }

}
