package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class HaltCode extends ByteCode {

    public HaltCode(List<String> args) {
        super(args);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.stopRunning();
    }

    @Override
    public String toString() {
        return "HALT";
    }
}