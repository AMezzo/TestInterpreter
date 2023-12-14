package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String label;
    private String baseId;

    public ReturnCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.label = args.get(1);
            if (label != null && label.contains("<<")) {
                this.baseId = label.substring(0, label.indexOf("<<"));
            } else {
                this.baseId = label; 
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.peekRunStack();
        vm.setPC(vm.popReturnAddress());
        System.out.println("RETURN " + label + " end " + baseId + ": " + returnValue);
    }

    @Override
    public String toString() {
        return "RETURN " + (label != null ? label : "");
    }
}