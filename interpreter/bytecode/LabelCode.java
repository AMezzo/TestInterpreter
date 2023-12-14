package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class LabelCode extends ByteCode {
    private String label;

    public LabelCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.label = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        // In genere, i LabelCode non hanno un comportamento esecutivo in VirtualMachine.
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }
}