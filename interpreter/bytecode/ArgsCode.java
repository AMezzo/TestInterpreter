package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int arg;

    public ArgsCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.arg = Integer.parseInt(args.get(1));
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(arg);
    }

    @Override
    public String toString() {
        return "ARGS " + arg;
    }
}
