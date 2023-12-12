package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;
import interpreter.loader.Program;

public class VirtualMachine {
    private int pc;
    protected Stack<Integer> returnAddresses;
    private boolean isRunning;
    private boolean isDumping; 
    protected Program program;
    protected RuntimeStack runStack;

    public VirtualMachine(Program program) {
        this.program = program;
        this.returnAddresses = new Stack<>();
        this.runStack = new RuntimeStack();
    }

    public int getPC() {
        return this.pc;
    }

    public boolean getIsRunning() {
        return this.isRunning;
    }

    public boolean getIsDumping() {
        return this.isDumping;
    }

    public void setDumpMode(boolean mode) {
        this.isDumping = mode;
    }

    public void executeProgram() {
        this.pc = 0;
        this.isRunning = true;

        while (this.isRunning) {
            ByteCode code = this.program.getCode(this.pc);
            code.execute(this);

            if (this.isDumping) {
                System.out.println(runStack); 
            }

            this.pc++;
        }
    }
}