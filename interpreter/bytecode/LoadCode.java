package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class LoadCode extends ByteCode {
    private int offset;
    private String id; 

    public LoadCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.offset = Integer.parseInt(args.get(1));
            if (args.size() > 2) {
                this.id = args.get(2);
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRunStack(offset);
    }

    @Override
    public String toString() {
        return "LOAD " + offset + (id != null ? " " + id : "");
    }
}