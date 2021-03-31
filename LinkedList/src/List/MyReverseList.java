/*
*反转链表的类
* 作用：创建一个反转链表。
 */


package List;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class MyReverseList {
    private static class Node2{
        String data;
        Node2 front;
        public Node2(){}
        public Node2(String n){
            data=n;
        }
    }
    Node2  before=null;
    Node2  current=null;
//    Node2  first;
    public void add(String n){
        Node2 newnode=new Node2(n);
        if(current==null) {
            //before.front = null;
            before = current = newnode;
        }
        else{
            current=newnode;
            current.front=before;
            before=current;
        }
    }
    public void display(){
        System.out.print(current.data);
        current=current.front;
        while(current!=null){
            System.out.print("->"+current.data);
            current=current.front;
        }
    }


}