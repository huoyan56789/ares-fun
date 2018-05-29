package datastructure.linear;

public class Stack {
    //存数据的数组
    int [] data;

    //定义栈的大小
    private int size;
    //定义栈顶
    private int top;

    public Stack(int size){
        this.size=size;
        data=new int[size];
        top=-1;
    }

    public int getSize(){
        return size;
    }
    public int getTop(){
        return top;
    }
    /**
     * 判断是否为空栈
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 判断是否为满栈
     * @return
     */
    public boolean isFull(){
        return (top+1)==size;
    }
    /**
     * 入栈操作（将数据放入栈）
     * @param data
     * @return
     */
    public boolean push(int data){
        if(isFull()){
            System.out.println("Stack ifull");
            return false;
        }else{
            top++;
            this.data[top]=data;
            return true;
        }
    }
    /**
     *  出栈操作(将栈顶元素移除，并返回）
     * @return
     * @throws Exception
     */
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }else{
            return this.data[top--];
        }
    }
    /**
     * 获取栈顶的元素,但不移除
     * @return
     */
    public int peek(){
        return this.data[getTop()];
    }
    public static void main(String[] args) {
        Stack stack = new Stack(20);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(12);
        System.out.println("Now the top_num is:" + stack.peek());

        while(! stack.isEmpty()) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
