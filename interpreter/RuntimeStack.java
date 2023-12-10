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
    return 0;
  }

  public int pop() {
    return 0;
  }

  public int push(int value) {
    return 0;
  }

  public Integer push(Integer value) {
    return 0;
  }

  public void newFrameAt(int offset) {

  }

  public void popFrame() {

  }

  public int store(int offset) {
    return 0;
  }

  public int load(int offset) {
    return 0;
  }
}
