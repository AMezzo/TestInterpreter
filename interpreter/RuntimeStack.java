package interpreter;

import java.util.Stack;
import java.util.Vector;

public class RuntimeStack {

  private Stack<Integer> framePointers;
  private Vector<Integer> runStack;

  public RuntimeStack() {
    this.framePointers = new Stack<>();
    this.runStack = new Vector<>();
  }

  public int peek() {
    if(runStack.size() == 0) {
      throw new EmptyStackException("Attempted to peek on an empty stack.");
    }
    return runStack.lastElement();
  }

  public int pop() {
    if(runStack.size() == 0) {
      throw new EmptyStackException("Attempted to pop from an empty stack.");
    }
    return runStack.remove(runStack.size() - 1);
  }

  public int push(int value) {
    runStack.add(value);
    return value;
  }

  public Integer push(Integer value) {
    runStack.add(value);
    return value;
  }

  class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message) {
      super(message);
    }
  }

  public int peekAtOffset(int offset) {
    if (!framePointers.isEmpty()) {
        int frameStart = framePointers.peek();
        int absoluteOffset = frameStart + offset;
        if (absoluteOffset < runStack.size()) {
            return runStack.elementAt(absoluteOffset);
        }
    }
    throw new IllegalArgumentException("Invalid offset: " + offset);
}

public void newFrameAt(int offset) {
  if (offset < 0 || runStack.size() < offset) {
      throw new RuntimeException("Invalid frame offset: " + offset);
  }
  int newFramePointer = runStack.size() - offset;
  framePointers.push(newFramePointer);
}

public void store(int offset, int value) {
        if (!framePointers.isEmpty()) {
            int frameStart = framePointers.peek();
            int storeLocation = frameStart + offset;
            if (storeLocation < runStack.size()) {
                runStack.set(storeLocation, value);
            } else {
                throw new RuntimeException("Invalid offset: " + offset + " for stack frame");
            }
        } else {
            throw new RuntimeException("No frame pointers available");
        }
    }
    
}
