class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class 기초_Double_Linked_List_연습 {
	
	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
    	head = null;
		nodeCnt = 0;
	}

	public void addNode2Head(int data) {
    	if(head == null) {
            head = getNode(data);
            return;
        }
        Node new_head = getNode(data);
        head.prev = new_head;
        new_head.next = head;
        head = new_head;
	}

	public void addNode2Tail(int data) {
    	if(head == null) {
            head = getNode(data);
            return;
        }
        Node now_node = head;
        while(now_node.next != null) {
            now_node = now_node.next;
        }
        Node new_tail = getNode(data);
        now_node.next = new_tail;
        new_tail.prev = now_node;
	}

	public void addNode2Num(int data, int num) {
    	if(head == null) {
            head = getNode(data);
            return;
        }
        if(num == 1) {
            addNode2Head(data);
            return;
        }
        Node cur_node = head;
        Node pre_node = null;
        int cnt = 1;
        while (true) { 
            if (cnt == num - 1) {
                if (cur_node == null) {
                    addNode2Tail(data);
                    return;
                }
                Node new_node = getNode(data);
                pre_node = cur_node;
                cur_node = cur_node.next;

                new_node.prev = pre_node;
                new_node.next = cur_node;

                pre_node.next = new_node;
                if (cur_node != null) {
                    cur_node.prev = new_node;
                }
                return;
            }
            cur_node = cur_node.next;
            cnt++;
        }
	}
	
	public int findNode(int data) {
		int cnt = 1;
        Node cur_node = head;
        while(true) {
            if(cur_node.data == data) {
                return cnt;
            }
            cur_node = cur_node.next;
            cnt++;
        }
	}
	
	public void removeNode(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            head = head.next;
            if (head != null)
                head.prev = null;
            nodeCnt--;
            return;
        }

        Node cur_node = head;
        while (cur_node != null) {
            if (cur_node.data == data) {
                Node pre_node = cur_node.prev;
                Node next_node = cur_node.next;

                if (pre_node != null)
                    pre_node.next = next_node;

                if (next_node != null)
                    next_node.prev = pre_node;

				nodeCnt--;
                return;
            }
            cur_node = cur_node.next;
        }
	}

	public int getList(int[] output) {
        Node curNode = head;
        int count = 0;
        while (curNode != null && count < MAX_NODE) {
            output[count] = curNode.data;
            curNode = curNode.next;
            count++;
        }
        return count;
	}
	
	public int getReversedList(int[] output) {
        int count = 0;
        Node curNode = head;
        while (curNode != null && count < MAX_NODE) {
            output[nodeCnt - 1 - count] = curNode.data;
            curNode = curNode.next;
            count++;
        }
        return nodeCnt;
	}
}