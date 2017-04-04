//StackArray.java
//CS111 Implementation of a stack interface using an array


import java.util.EmptyStackException;

public class StackArray<T>
{
    private Object[] stack;
    private int top;
    private static final int maxSize=5;

 
    public StackArray()
    {
      stack = (T[]) new Object [maxSize];
      top = 0;
    }

    public StackArray(int numElements)
    {
      stack = (T[])new Object[numElements];
      top = 0;
    }

    public T pop() throws EmptyStackException 
    {   T val;
      if (empty())
        throw new EmptyStackException();

      top--;
      val = (T)stack[top];
      return val;
    }


    public void push (T value) throws FullStackException
    {    int i;
      if (!full())
     {  stack[top]=value;
         top++;
     }
      else //throw new FullStackException();
    {
        StackArray<T> s1 = new StackArray <T>(maxSize*2);
        for (i=0;i<top;i++)
             s1.stack[i]=stack[i];
        s1.top=i;
        stack=s1.stack;
        stack[top]=value;
        top++;
  }
    }

    public T peek() throws EmptyStackException
    {
      if (empty())
        throw new EmptyStackException();

      return (T)stack[top -1];
    }


    public boolean empty()
    { 
      return (top == 0);
    }

    public boolean full ()
    { 
      return (top == stack.length);
    }

    public int size()
    {
      return top;
    }


    public int getMaxSize()
    { 
      return stack.length;
    } 


    public void clear()
    {
      top =0;
    }
}
