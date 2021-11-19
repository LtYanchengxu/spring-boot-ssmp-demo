package top.yanchengxu.controller.utils;



import lombok.Data;


@Data
public class Result {

    private boolean flag;
    private Object data;
    private String message;

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }

}
