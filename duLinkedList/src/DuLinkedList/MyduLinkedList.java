/*
*双向链表类
* 作用：1  创建链表
*      2  查找节点
*      3  插入节点
*      4  删除节点
*      5  遍历链表
 */
package DuLinkedList;

import java.util.Scanner;

public class MyduLinkedList {
    private static class  Node{
        Node   next=null;
        Node   front=null;
        String data;
        public Node(String str){
            data=str;
        }
        public Node(){}
    }
    Scanner sc=new Scanner(System.in);
    Node first=null;
    Node before=null;
    Node current=null;
    public void InitList_DuL(String str){
        Node    newnode=new Node(str);
        if(first==null)     {
            first=newnode;
            before=first;
        }
        else{
                current=newnode;
                current.front=before;
                before.next=current;
                before=current;
            }
        first.front=null;
    }           //创建链表
    public Node Search_Dul(String str)throws MyException{
        Node newnode=first;
        while(newnode!=null){
            if(newnode.data.equals(str))     return newnode;
            newnode=newnode.next;
        }
        if(newnode==null)   throw  new MyException("输入有误！没有该节点！");
        return null;
    }   //查找节点
    public void InsertBeforeList_DuL(){
        System.out.print("请输入新节点数据：");
        Node node1=new Node();
        node1.data=sc.next();
        System.out.print("原链表：");
        TraverseList_DuL();
        System.out.print("请输入要在那个节点前插入（该节点数据）：");
        String str=sc.next();
        try{
            Node    newnode=Search_Dul(str);
            if(newnode==first){
                first=node1;
                first.next=newnode;
                newnode.front=first;
            }
            else{
                Node node2=newnode.front;
                node2.next=node1;
                node1.front=node2;
                node1.next=newnode;
            }
            System.out.print("新链表：");
            TraverseList_DuL();
        }catch(MyException  e){
            System.out.println(e.getMessage());
        }
    }                       //插入节点
    public void InsertAfterList_DuL(){
        System.out.print("请输入新节点数据：");
        Node node1=new Node();
        node1.data=sc.next();
        System.out.print("原链表：");
        TraverseList_DuL();
        System.out.print("请输入在那个节点后面（该节点数据）：");
        String str=sc.next();
        try{
            Node newnode=Search_Dul(str);
            node1.next=newnode.next;
            newnode.next=node1;
            node1.front=newnode;
            System.out.print("新链表：");
            TraverseList_DuL();
        }catch(MyException e){
            System.out.println(e.getMessage());
        }

    }                        //插入节点
    public void DeleteList_DuL(){
        System.out.print("原链表：");
        TraverseList_DuL();
        System.out.print("请输入要删除的节点");
        String str=sc.next();
        try{
            Node newnode=Search_Dul(str);
            if(newnode==first)  {
                first=first.next;
                first.front=null;
            }
            else    {
                Node node1=newnode.front;
                Node node2=newnode.next;
                node1.next=node2;
            }
            System.out.print("新链表：");
            TraverseList_DuL();
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }                                   //删除节点
    public void TraverseList_DuL(){
        Node newnode=first;
        System.out.print(newnode.data);
        newnode=newnode.next;
        while(newnode!=null) {
            System.out.print("->"+newnode.data);
            newnode=newnode.next;
        }
        System.out.println();
    }                                   //遍历链表
}

