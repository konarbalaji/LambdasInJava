package chp04;

public class Response {

    private String message;
    private int code;

    public Response(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
