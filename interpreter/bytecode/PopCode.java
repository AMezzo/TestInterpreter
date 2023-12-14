package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class PopCode extends ByteCode {
    private int levels;

    public PopCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.levels = Integer.parseInt(args.get(1));
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < levels; i++) {
            vm.popRunStack();
        }
    }

    @Override
    public String toString() {
        return "POP " + levels;
    }
}