package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class LitCode extends ByteCode {
    private int value;
    private String id;

    public LitCode(List<String> byteCodeArgs) {
        super(byteCodeArgs);
        this.value = Integer.parseInt(byteCodeArgs.get(1));
        this.id = byteCodeArgs.size() > 2 ? byteCodeArgs.get(2) : "";
    }

     @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(value);
        if (!id.isEmpty()) {
            System.out.println(String.format("LIT %d %s  int %s = %d", value, id, id, value));
        } else {
            System.out.println(String.format("LIT %d int %d", value, value));
        }
    }

    @Override
    public String toString() {
        return "LIT " + value + (id.isEmpty() ? "" : " " + id + "     // int " + id);
    }
}