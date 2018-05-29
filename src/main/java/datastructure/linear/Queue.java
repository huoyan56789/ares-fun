package datastructure.linear;

public class Queue {

    //存数据的数组
    private int [] data;

    private int front;//头指针
    private int rear;//尾指针

    public Queue(int size){
        data=new int[size];
        front=0;
        rear=-1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return front==data.length;
    }
    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull(){
        return data.length - 1 == rear;
    }
    /**
     * 向队列的队尾插入一个元素
     */
    public void insert(int item){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        data[++rear]=item;
    }
    /**
     * 获得对头元素
     *
     * @return
     */
    public int peekFront(){
        return data[front];
    }
    /**
     * 获得队尾元素
     *
     * @return
     */
    public int peekRear(){
        return data[rear];
    }
    /**
     * 从队列的队头移除一个元素
     *
     * @return
     */
    public int remove(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return data[front++];
    }
    public static void main(String[] args) {
        Queue queue = new Queue(20);
        queue.insert(10);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(12);
        System.out.println("Now the top_num is:" + queue.peekFront());
        while(! queue.isEmpty()) {
            try {
                System.out.println(queue.remove());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
