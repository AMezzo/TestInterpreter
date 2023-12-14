package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {

    private String label;

    public ReturnCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.label = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        return "RETURN " + (label != null ? label : "");
    }
}