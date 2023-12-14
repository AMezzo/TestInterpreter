package interpreter.loader;

import java.util.HashMap;
import java.util.Map;

public class CodeTable {

  private static Map<String, String> codes = new HashMap<>();

  static {
    init();
  }

  private static void init() {
    codes.put("LIT", "interpreter.bytecode.LitCode");
    codes.put("DMP", "interpreter.bytecode.DmpCode");
    codes.put("FALSEBRANCH", "interpreter.bytecode.FalsebranchCode");
    codes.put("GOTO", "interpreter.bytecode.GotoCode");
    codes.put("HALT", "interpreter.bytecode.HaltCode");
    codes.put("LABEL", "interpreter.bytecode.LabelCode");
    codes.put("LOAD", "interpreter.bytecode.LoadCode");
    codes.put("POP", "interpreter.bytecode.PopCode");
    codes.put("READ", "interpreter.bytecode.ReadCode");
    codes.put("ARGS", "interpreter.bytecode.ArgsCode");
    codes.put("WRITE", "interpreter.bytecode.WriteCode");
    codes.put("STORE", "interpreter.bytecode.StoreCode");
    codes.put("CALL", "interpreter.bytecode.CallCode");
    codes.put("RETURN", "interpreter.bytecode.ReturnCode");    
  }

  public static String getClassName(String byteCode) {
    String className = codes.get(byteCode);
    if (className == null) {
      throw new IllegalArgumentException("ByteCode not recognized: " + byteCode);
    }
    return className;
  }
}
