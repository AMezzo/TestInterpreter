package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {

    public WriteCode(List<String> args) {
        super(args);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.peekRunStack();
        System.out.println(value);
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
