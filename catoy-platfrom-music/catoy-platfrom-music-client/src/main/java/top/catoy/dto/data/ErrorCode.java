package top.catoy.dto.data;

public enum ErrorCode {
    PERMISSION_DENIED("PERMISSION_DENIED", "没有权限"),
    PARAMETER_VALIDATION_ERROR("PARAMETER_VALIDATION_ERROR", "参数校验错误"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", "位置异常"),
    DOWNLOAD_ERROR("DOWNLOAD_ERROR", "下载异常");

    private String code;

    private String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}