package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    public ReadCode(List<String> args) {
        super(args);
    }

    @Override
    public void execute(VirtualMachine vm) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            int input = scanner.nextInt();
            vm.pushRunStack(input);
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "READ";
    }
}