package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class CallCode extends ByteCode {
    private String label;
    private int targetAddress;

    public CallCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.label = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.savePC(); 
        vm.setPC(targetAddress); 
    }

    @Override
    public String toString() {
        return "CALL " + label;
    }

    public void resolveAddrs(int address) {
        this.targetAddress = address;
    }
}