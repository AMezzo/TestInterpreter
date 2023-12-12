package interpreter.loader;

import java.util.HashMap;
import java.util.Map;

public class CodeTable {

  private static Map<String, String> codes = new HashMap<>();

  static {
        codes.put("LIT", "interpreter.bytecode.LitCode");
        codes.put("DMP", "interpreter.bytecode.DmpCode");
  }

  public static String getClassName(String byteCode) {
    return codes.get(byteCode);
}
}
