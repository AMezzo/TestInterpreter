package interpreter;

import java.util.Stack;
import java.util.Vector;

public class RuntimeStack {

  private Stack<Integer> framePointers;
  private Vector<Integer> runStack;

  public RuntimeStack() {
    this.framePointers = new Stack<>();
    this.runStack = new Vector<>(100);
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
  framePointers.push(runStack.size() - offset);
}


public void store(int offset, int value) {
  if (!framePointers.isEmpty() && offset >= 0) {
      int frameStart = framePointers.peek();
      int storeLocation = frameStart + offset;
      if (storeLocation < runStack.size()) {
          runStack.set(storeLocation, value);
      } else {
          throw new RuntimeException("Invalid offset: " + offset + " for stack frame");
      }
  } else {
      throw new RuntimeException("No frame pointers available or invalid offset");
  }
}

public void clearCurrentFrame() {
  if (!framePointers.isEmpty()) {
      int frameStart = framePointers.pop();
      while (runStack.size() > frameStart) {
          runStack.remove(runStack.size() - 1);
      }
  }
  }

  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int lastFrameIndex = 0;
        for (int frameIndex : framePointers) {
            sb.append("[");
            for (int i = lastFrameIndex; i < frameIndex; i++) {
                sb.append(runStack.get(i)).append(", ");
            }
            sb.append("] ");
            lastFrameIndex = frameIndex;
        }
        sb.append("[");
        for (int i = lastFrameIndex; i < runStack.size(); i++) {
            sb.append(runStack.get(i)).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
