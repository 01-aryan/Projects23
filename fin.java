import java.util.*;

public class fin {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode=new Node(data);

        if(head==null) {
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;

    }

    public void addLast(int data) {
        Node newNode=new Node(data);

        if(head==null) {
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
        
    }

    public static Node getMiddle(Node head) {
        if(head==null) {
            return null;
        }

        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    public static Node reverse(Node head) {
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
            head=prev;
            return head;
            
    }



   

    public static void insertTail(Node tail,Node curr) {
        
        tail.next=curr;
        tail=curr;
    }

    public static Node sort(Node head) {
        Node zerohead=new Node(-1);
        Node zerotail=zerohead;
        Node onehead=new Node(-1);
        Node onetail=onehead;
        Node twohead=new Node(-1);
        Node twotail=twohead;

        Node curr=head;

        // Create separate list of 0,1,2s

        while(curr!=null) {
            int value=curr.data;

            if(value==0) {
               insertTail(zerotail,curr);
            }
            else if(value==1) {
                insertTail(onetail,curr);
            }
            else if(value==2) {
                insertTail(twotail,curr);
            }
            curr=curr.next;
        }

        // merge 3 sublists

        if(onehead.next!=null) {
            zerotail.next=onehead.next;
        }
        else {
            zerotail.next=twohead.next;
        }
        onetail.next=twohead.next;
        twotail.next=null;

        head=zerohead.next;


        

        return head;


    }


    public void print(Node head) {
        Node temp=head;

        while(temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");

    } 


    public static void main(String args[]) {
        
        fin f=new fin();
        /*f.addFirst(6);
        f.addFirst(4);
        f.addFirst(1);
        f.addLast(3);
        f.addLast(5);
        f.addLast(2);*/

        f.addFirst(0);
        f.addFirst(1);
        f.addLast(2);
        f.addLast(2);
        f.addLast(0);

    
    Node n=sort(head);   
        f.print(n);
        
        
    }
}