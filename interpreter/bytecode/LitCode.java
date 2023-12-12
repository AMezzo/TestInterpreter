package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class LitCode extends ByteCode {
    private int value;
    private String id;

    public LitCode(List<String> byteCodeArgs) {
        super(byteCodeArgs);
        value = Integer.parseInt(byteCodeArgs.get(1));
        if (byteCodeArgs.size() > 2) {
            id = byteCodeArgs.get(2);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(value);
    }
}