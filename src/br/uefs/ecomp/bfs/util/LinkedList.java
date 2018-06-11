package br.uefs.ecomp.bfs.util;

public class LinkedList implements IList{
    private Node head;
    private Node tail;
    private int sizeList;
    
    private class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public Object getData(){
            return data;
        }
        public void setData(Object data){
            this.data = data;
        }
    }
    
    @Override
    public boolean contains(Object data){
       for(Node n = head;n != null; n = n.getNext()){
           if(n.getData() != null && n.getData().equals(data)){
               return true;
           }
       }
       return false;
    }

    @Override
    public boolean isEmpty(){
       return head == null;
    }

    @Override
    public int size(){
        return sizeList;
    }

    @Override
    public void addStart(Object data){
        if (isEmpty()){
            head = new Node(data);
            tail = head;
        }else{
            Node n = new Node(data);
            n.setNext(head);
            head = n;
        }
        sizeList++;
    }
    
    @Override
    public void addLast(Object data){
        if(isEmpty()){
            head = new Node(data);
            tail = head;
        }else{
            Node n = new Node(data);
            tail.setNext(n);
            tail = n;
        }
        sizeList++;
    }

    @Override
    public Object toRemoveStart(){
        if(isEmpty()){
            return null;
        }else{
            Node n;
            n = head;
            head = head.getNext();
        sizeList--;
        return n.getData();
        }
    }

    @Override
    public Object toRemoveLast(){   
        Node aux;
        aux = head;
        
        if(isEmpty()){
            return null;
        }if(size() == 1){
            sizeList--;
            Object data = head.getData();
            head = tail = null;
            return data;
        }else{
            sizeList--;
            for (Node n = head; n.getNext() != null; n = n.getNext()) {
                if(n.getNext().getNext() == null){
                   tail = n; 
                }
                aux = n;
            }
            Object data = aux.getNext().getData();
            tail.setNext(null);
            return data;
        }
    }
    
    @Override
    public Object get(int index){
        if(index >= 0 && index < size()){
            Node aux = head;
            for(int i = 0 ; i < index; i++){
                aux = aux.getNext();
            }
            Object data = aux.getData();
            return data;
        }
        return null;
    }

    @Override
    public Iterator iterator(){
        ListIterator iteratorlist = new ListIterator(this.head);
        return iteratorlist;
    }
    
    private class ListIterator  implements Iterator{
        private Node current;

        ListIterator(Node head){
            current = head;
        }

        @Override
        public boolean hasNext(){
            return  current != null;
        }

        @Override
        public Object next(){
            Object data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}