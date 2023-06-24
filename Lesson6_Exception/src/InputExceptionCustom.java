public class InputExceptionCustom extends Exception{
    private String msg;
    public InputExceptionCustom(String msg) {
        super(msg);
        this.msg = msg;
    }


}
