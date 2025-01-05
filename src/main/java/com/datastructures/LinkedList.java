package com.datastructures;

import java.util.Arrays;
import java.util.List;

class Node {

    int val;
    Node next;
    Node(){}
    Node(int val){this.val =val;}
    Node(int val, Node next){
        this.val =val;
        this.next=next;
    }
}

public class LinkedList {
    public Node head;
    LinkedList(){};
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy =  new Node(0);
        Node currentDummy=dummy;
        int l1Val=0, l2Val=0;
        int carry =0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                l1Val= l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                l2Val= l2.val;
                l2=l2.next;
            }
            int sum = l1Val+l2Val+carry;
            currentDummy.next = new Node(sum%10);
            carry = sum/10;
            currentDummy= currentDummy.next;
        }
        return dummy.next;

    }


    public void add(int val) {
        Node node = new Node(val);
        if(head==null)
            head=node;
        else{
          Node current = head;
          head=node;
          head.next=current;
        }

    }

    public Node search(int input){
        Node found = null;
        if(head!=null && head.val==input)
            return head;

        Node current = head;
        while (current != null) {
            if (current.val == input) {
                found=current;
                break;
            }
            current = current.next;
        }
        return found;
    };


    public void delete(int input){
        if(head!=null && head.val==input){
            head=head.next;
        }else {
            Node current = head;
            while (current != null && current.next!=null) {
                Node nextNode=current.next;
                if (nextNode.val == input) {
                    current.next=nextNode.next;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void printLinkedList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.val);
            current = current.next;
            System.out.print(" ->");
        }
    }
    public void reverse(){
        Node current = head;
        Node prev=null; Node next=null;
        while(current!=null) {
           next=current.next;
           current.next=prev;
           prev = current;
           current= next;
        }
        head = prev;
    }


    public static void main(String args[]){
        LinkedList l = new LinkedList();
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        l.add(4);
//        l.add(5);
        Node n = new Node(1);
        n.next= new Node(2);
        n.next.next= new Node(3);
        n.next.next.next= new Node(4);
        n.next.next.next.next= new Node(5);
//       l.removeNthFromEnd(n,1);
        l.rotateRight(n, 2);
//        l.printLinkedList();
//        System.out.println("--");
//        System.out.println("--");
//        l.delete(40);
//        l.printLinkedList();
//        System.out.println("--");
//        System.out.println("--");
//        l.add(90);
//        l.add(80);
//        l.printLinkedList();
//        l.reverse();
//        System.out.println("--");
//        System.out.println("-test-");
//        l.printLinkedList();
//        l.reverseOnlyKElements(l.head, 3);
//        l.printLinkedList();

//        System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 2, 0, 5));
        int number =2;
        number = (int) (number + ("1010".charAt(2)=='1'? 1 : 0) * Math.pow(2,1));
        
    }

    private void  reverseOnlyKElements(Node head, int k) {
        Node current=head, prev=null,next=null;
        int i=0;
         while(current!=null && i<k ){
             next=current.next;
             current.next=prev;
             prev=current;
             current=next;
             i++;
         }
         head.next=current;
        this.head=prev;
    }

    public static int binarySearch(int[] nums, int target, int left, int right){
        if(left<=right) {
            int mid = (right+left)/2;
            if(nums[mid]==target) return mid;
            else if(target > nums[mid])
                return binarySearch(nums,target, mid+1, right);
            else if(target<nums[mid])
                return binarySearch(nums, target, left, mid);
            if(right==left && nums[left]!=target) return -1;
        }
       return -1;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if(head==null||(head!=null&&head.next==null)) return head;
        if(head!=null&&head.next==null && n==1) return null;
        Node current=head; int totalElements=0;
        Node slow=head,fast=head;
        while(fast!=null){
            if(fast.next==null){
                totalElements+=1;
                break;
            }
            totalElements+=2;
            fast=fast.next.next;
        }
        current=head;
        int count=1;
        Node prev=null;
        while(current!=null && count<=totalElements-n ){
            prev=current;
            current=current.next;
            count++;
        }
        prev.next=current.next;
        return head;

    }

    public Node rotateRight(Node head, int k) {

        Node current=head, next=null;
        int totalelements=0;
        while(current!=null){
            totalelements+=1;
            next=current.next;
            if(next==null){
                current.next=head;
                break;
            }
            current=current.next;
        }
        int noOfPositionsToMoveHead=0;
        if(k<totalelements){
            noOfPositionsToMoveHead=totalelements-k;

        }else{
            noOfPositionsToMoveHead=(k%totalelements);
        }
        current=head;
        while(noOfPositionsToMoveHead>0){
            current=current.next;
            noOfPositionsToMoveHead--;
        }
        head=current.next;
        current.next=null;
        return head;
    }




}


