
package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public abstract class ByteCode {

    private List<String> args;

    public ByteCode(List<String> byteCodeArgs) {
        this.args = byteCodeArgs;
    }

    public List<String> getArgs() {
        return args;
    }

    public abstract void execute(VirtualMachine vm);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + String.join(" ", args);
    }
}
