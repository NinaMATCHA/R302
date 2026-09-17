package listes;

public class SinglyListClass {
    
    private Node header;
    private long size;

    public SinglyListClass() {
        this.header = null;
        this.size = 0;
    }

    public SinglyListClass(Node header, long size) {
        this.header = header;
        this.size = size;
    }

    public Long size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {
        if (isEmpty()) {
            return null;
        }
        return header.getElement();
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }
        Node current = header;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void addFirst(Integer element) {
        Node newNode = new Node(element, header);
        header = newNode;
        size++;
    }

    public void addLast(Node element) {
        Integer elemSize = 0;

        if (header == null) {
            header = element;
            elemSize++;
        } 
        else {
            Node current = header;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(element);
            while (current != null) {
                elemSize++;
                current = current.getNext();
            }
        }
        this.size = this.size + elemSize;
    }

    public void addLast(Integer element) {
        Node newNode = new Node(element);
        if (header == null) {
            header = newNode;
        } else {
            Node current = header;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Integer removedElement = header.getElement();
        header = header.getNext();
        size--;
        return removedElement;
    }


    public Node getnext() {
        return header;
    }

    private static class Node {
        private Integer element;
        private Node next;

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(Integer element) {
            this.element = element;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = header;
        while (current != null) {
            sb.append(current.getElement()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyListClass list = new SinglyListClass();

        list.addFirst(1);
        list.addLast(2);

        list.size();

        Node node2 = new Node(4);
        Node node1 = new Node(3,node2);

        list.addLast(node1);

        System.out.println(list.toString());
        System.out.println(list.size());
    }

}
