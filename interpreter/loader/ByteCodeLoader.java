package interpreter.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import interpreter.Program;
import interpreter.bytecode.ByteCode;

public class ByteCodeLoader {

    private BufferedReader byteSource;

    public ByteCodeLoader(String byteCodeFilePath) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(byteCodeFilePath));
    }

    public Program loadCodes() throws ByteCodeLoaderException {
        Program program = new Program();
        try {
            String line;
            while ((line = byteSource.readLine()) != null) {
                List<String> byteCodeArgs = new ArrayList<>();
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        byteCodeArgs.add(part);
                    }
                }
                String codeClass = CodeTable.getClassName(byteCodeArgs.get(0));
                Class<?> cls = Class.forName(codeClass);
                ByteCode byteCode = (ByteCode) cls.getDeclaredConstructor(List.class).newInstance(byteCodeArgs);
                program.addCode(byteCode);
            }
        } catch (Exception e) {
            throw new ByteCodeLoaderException(e.getMessage());
        }
        return program;
    }
}