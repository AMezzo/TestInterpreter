package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class GotoCode extends ByteCode {
    private String label;
    private int targetAddress;

    public GotoCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.label = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(targetAddress);
    }

    @Override
    public void resolveAddrs(int address) {
        this.targetAddress = address;
    }

    @Override
    public String toString() {
        return "GOTO " + label;
    }
}