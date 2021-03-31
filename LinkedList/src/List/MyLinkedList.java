/*
*链表类：
* 主要功能：1    创建链表
*         2    搜索节点
*         3    插入节点
*         4    遍历节点
*         5    删除节点
*         6    反转链表
*         7    成环链表
*         8    奇偶调换
*         9    中间节点
 */


package List;
import java.util.*;

public class MyLinkedList {
    private static class Node {
        String data;
        Node next;
        public Node(){}
        public Node(String value){
            data=value;
        }
    }
    Scanner sc=new Scanner(System.in);
    Node first=null;                                      //头节点的引用
    Node current=null;
    public void initList(String value){
        Node newNode=new Node(value);
        if(first==null)     {first=newNode;  current=newNode;}
        else                {current.next=newNode; current=newNode;}
    }                  //创建链表
    /*public void Destory(){
        Node p=first,q=first.next;
        while(p!=null){
            p=null;
            p=q;
            q=p.next;
        }
    }*/
    public Node searchList(String n) throws MyException{
        Node node=first;
        while(node!=null){
            if(node.data.equals(n))    return node;
            else                node=node.next;
        }
        if(node==null)
            throw new MyException("输入有误！链表中没有该节点！");
        return null;
    }   //搜索节点
    public void InsertList(){
        System.out.print("请输入新节点数据：");
        Node newnode=new Node();
        newnode.data=sc.next();
        System.out.print("原链表：");
        TraverseList();
        System.out.print("请输入你想插入的节点：");
        String n=sc.next();
        try{
            Node innode=searchList(n);
            newnode.next=innode.next;
            innode.next=newnode;
            System.out.print("新链表：");
            TraverseList();}catch(MyException e){
            System.out.println(e.getMessage());
        }
    }                               //插入节点
    public void TraverseList(){
        Node node=first.next;
        System.out.print(first.data);
        while(node!=null){
            System.out.print("->"+node.data);
            node=node.next;
        }
        System.out.println();
    }                               //遍历节点
    public void DeleteList(){
        System.out.print("原链表：");
        TraverseList();
        System.out.print("请选择要删除的节点：");
        String n=sc.next();
        try{
        Node node1=searchList(n);
        if(first==node1)    first=first.next;
        else {
            Node node2 = first;
            while (node2.next != node1) {
                node2=node2.next;
            }
            node2.next=node1.next;
        }
        System.out.print("新链表");
        TraverseList();
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }                                   //删除节点
    public void ReverseList(){
        MyReverseList   list2=new MyReverseList();
        Node node=first;
        while(node!=null){
            list2.add(node.data);
            node=node.next;
        }
        System.out.print("原链表：");
        TraverseList();
        System.out.print("新链表：");
        list2.display();
    }                                   //反转链表
    public void IsLoopList(){
        String c;
        System.out.print("是否让链表成环？（Y/N）：");
        c=sc.next();
        try{
        if(c.equals("Y")){
            TraverseList();
            System.out.print("请选择成环点：");
            String n=sc.next();
                Node node1=searchList(n);
                Node node2=first;
                while(node2.next!=null)     node2=node2.next;
                node2.next=node1;

        }
        System.out.print("是否判断链表成环？（Y/N）：");
        c=sc.next();
        if(c.equals("Y")){
            Node node3=first;   Node node4=first.next;
            if(node4!=null)     node4=node4.next;
            while(node4!=null){
                node3=node3.next;
                node4=node4.next;
                if(node4!=null)     node4=node4.next;
                if(node3==node4)    break;
            }
            if(node4==null) System.out.println("不成环！");
            else System.out.println("成环！");
        }
    }catch (MyException e){
            System.out.println(e.getMessage());
        }}                                     //成环链表
    public void ReverseEvenList(){
        Node h,p,q;
        h=first;    p=first.next;   q=null;
        System.out.print("原链表：");
        TraverseList();
        if(p.next!=null)    q=p.next;
        int i=0;
        while(p!=null){
            h.next=q;
            p.next=h;
            if(i==0)    first=p;
            if(q!=null&&q.next!=null){
                h.next=q.next;
                h=q;}
            if(q==null)     break;
            p=q.next;
            if(p!=null) q=p.next;
            i++;
        }
        System.out.print("新链表：");
        TraverseList();
    }                                 //奇偶调换
    public void FindMidNode(){
        Node p,q;
        p=first;    q=first.next;   if(q!=null)     q=q.next;
        while(q!=null){
            p=p.next;
            q=q.next;
            if(q!=null)     q=q.next;
        }
        System.out.println("中间节点："+p.data);
    }                                       //中间节点
}
