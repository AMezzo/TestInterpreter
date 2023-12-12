package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class DmpCode extends ByteCode {
    private boolean dumpState;

    public DmpCode(List<String> byteCodeArgs) {
        super(byteCodeArgs);
        dumpState = byteCodeArgs.get(1).equals("+");
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumpMode(dumpState);
    }
}