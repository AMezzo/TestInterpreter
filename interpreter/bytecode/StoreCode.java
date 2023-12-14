package interpreter.bytecode;

import java.util.List;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int offset;
    private String id; 

    public StoreCode(List<String> args) {
        super(args);
        this.offset = Integer.parseInt(args.get(1));
        this.id = args.size() > 2 ? args.get(2) : "";
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.popRunStack();
        vm.storeRunStack(offset, value);
        if (!id.isEmpty()) {
            System.out.println("STORE " + offset + " " + id + " " + id + " = " + value);
        }
    }

    @Override
    public String toString() {
        return "STORE " + offset + (id != null ? " " + id : "");
    }
}