package interpreter.loader;

import interpreter.bytecode.ByteCode;
import java.util.ArrayList;
import java.util.List;

public class Program {

  private List<ByteCode> byteCodes;

  public Program() {
    this.byteCodes = new ArrayList<>();
  }

  public void addCode(ByteCode code) {
    this.byteCodes.add(code);
  }

  public ByteCode getCode(int pc) {
    if (pc >= 0 && pc < this.byteCodes.size()) {
      return this.byteCodes.get(pc);
    }
    throw new IndexOutOfBoundsException("Program counter out of bounds.");
  }

}
