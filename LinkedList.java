import java.util.*;
import java.lang.*;

public class LinkedList
{
    public static void main(String a[])
    {
       Node head = new Node(10);
       SinglyLinkedList list = new SinglyLinkedList(head);
       list.insertNode(head,20);
       list.insertNode(head,30);
       list.insertNode(head,40);
       printLinkedList(head);
       list.deleteNode(head);
       System.out.println();
       printLinkedList(head);
       System.out.println();
       int n = list.size(head);
       System.out.println(n);



       
    
    }
    public static void printLinkedList(Node head)
    {
        Node temp = head;
        while(temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next; 
        }   
    }
}

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList
{
    Node head;

    SinglyLinkedList(Node head)
    {
        this.head = head;
    }
    
    public void insertNode(Node head,int data)
    {
      Node temp = head;
      while(temp.next!=null)
      {
        temp = temp.next;
      }
      temp.next = new Node(data);

    }
    public void deleteNode(Node head)
    {
        Node temp = head;
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
       temp.next = null;
    }
    public int size(Node head)
    {
        Node temp = head;
        int cnt = 0;
        while(temp!=null)
        {
            temp = temp.next;
            cnt++;
        }   
        return cnt;
    }
}