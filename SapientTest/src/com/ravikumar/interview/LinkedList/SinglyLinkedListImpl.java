package com.ravikumar.interview.LinkedList;

public class SinglyLinkedListImpl<T> {
	 
    private LLNode<T> head;
    private LLNode<T> tail;
     
    public void add(T element){
         
        LLNode<T> nd = new LLNode<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and 
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new LLNode
            tail.setNextRef(nd);
            //set tail as newly created LLNode
            tail = nd;
        }
    }
     
    public void addAfter(T element, T after){
         
        LLNode<T> tmp = head;
        LLNode<T> refLLNode = null;
        System.out.println("Traversing to all LLNodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target LLNode, add after this LLNode
                refLLNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refLLNode != null){
            //add element after the target LLNode
            LLNode<T> nd = new LLNode<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        LLNode<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        LLNode<T> tmp = head;
        LLNode<T> refLLNode = null;
        System.out.println("Traversing to all LLNodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target LLNode, add after this LLNode
                refLLNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refLLNode != null){
            tmp = refLLNode.getNextRef();
            refLLNode.setNextRef(tmp.getNextRef());
            if(refLLNode.getNextRef() == null){
                tail = refLLNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        LLNode<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
     
    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();
         
    }
}
 
class LLNode<T> implements Comparable<T> {
     
    private T value;
    private LLNode<T> nextRef;
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public LLNode<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(LLNode<T> ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}