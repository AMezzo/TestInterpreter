package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class BopCode extends ByteCode {
    private String operator;

    public BopCode(List<String> args) {
        super(args);
        if (args != null && args.size() > 1) {
            this.operator = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int secondOperand = vm.popRunStack();
        int firstOperand = vm.popRunStack();
        int result;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
            case "==":
                result = (firstOperand == secondOperand) ? 1 : 0;
                break;
            case "!=":
                result = (firstOperand != secondOperand) ? 1 : 0;
                break;
            case ">":
                result = (firstOperand > secondOperand) ? 1 : 0;
                break;
            case ">=":
                result = (firstOperand >= secondOperand) ? 1 : 0;
                break;
            case "<":
                result = (firstOperand < secondOperand) ? 1 : 0;
                break;
            case "<=":
                result = (firstOperand <= secondOperand) ? 1 : 0;
                break;
            case "&":
                result = (firstOperand != 0 && secondOperand != 0) ? 1 : 0;
                break;
            case "|":
                result = (firstOperand != 0 || secondOperand != 0) ? 1 : 0;
                break;
            default:
                throw new RuntimeException("Invalid operator in BopCode: " + operator);
        }

        vm.pushRunStack(result);
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}