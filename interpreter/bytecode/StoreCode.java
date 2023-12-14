package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int offset;
    private String id; 

    public StoreCode(List<String> args) {
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
        int value = vm.popRunStack();
        vm.storeRunStack(offset, value);
    }

    @Override
    public String toString() {
        return "STORE " + offset + (id != null ? " " + id : "");
    }
}