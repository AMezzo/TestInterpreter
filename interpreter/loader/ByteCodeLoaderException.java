package interpreter.loader;

public class ByteCodeLoaderException extends Exception {

    private String byteCodeFileLine;

    public ByteCodeLoaderException(String byteCodeFileLine, String message) {
        super(message);
        this.byteCodeFileLine = byteCodeFileLine;
    }

    @Override
    public String getMessage() {
        return "Error loading byte code at line: " + byteCodeFileLine + " - " + super.getMessage();
    }
}
