class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class 기초_Single_Linked_List_연습 {

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
    private Node head;
    
    // 새로운 node 할당
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

    // 초기 상태
	public void init() {
    	head = null;
	}

    // head 쪽에 node 삽입하기
	public void addNode2Head(int data) {
        // head가 존재하지 않는다면
    	if(head == null) {
            // 전달된 data를 head로 만듦
            head = getNode(data);
            return;
        }
        // head가 존재한다면
        Node new_head = getNode(data);
        // 새로운 node가 현재 head node를 가리키게 함
        new_head.next = head;
        head = new_head;
	}

    // tail 쪽에 node 삽입하기
	public void addNode2Tail(int data) {
        // head가 존재하지 않는다면
    	if(head == null) {
            // 전달된 data를 head로 만듦
            head = getNode(data);
            return;
        }
        // head가 존재한다면, 탐색을 위한 첫 node로 head 할당
        Node now_node = head;
        // next가 null일때까지, 즉 다음 노드가 존재하지 않을때, tail에 도달할 때까지
        while(now_node.next != null) {
            // 다음 node로 계속 탐색함
            now_node = now_node.next;
        }
        Node new_tail = getNode(data);
        // 현재 tail의 다음이 새로운 tail을 가리키도록 함
        now_node.next = new_tail;
	}

    // num번째에 node 삽입하기
	public void addNode2Num(int data, int num) {
        // head가 존재하지 않는다면
    	if(head == null) {
            // 전달된 data를 head로 만듦
            head = getNode(data);
            return;
        }
        // 첫번째 node로 넣는다면,
        if(num == 1) {
            // head에 node를 삽입하는 함수 활용
            addNode2Head(data);
            return;
        }
        // head가 존재한다면, 탐색을 위한 첫 node로 head 할당
        Node cur_node = head;
        // 첫 node가 head이므로 전 node가 존재하지 않기 때문에 초기값 null로 시작
        Node pre_node = null;
        // 탐색하는 node의 index 값을 count함
        int cnt = 1;
        while(true) {
            // 찾고자 하는 node 위치라면
            if(cnt == num - 1) {
                // 만약 next가 없어서 cur_node 값이 null이라면, 즉 tail이었다면
                if(cur_node == null) {
                    // tail에 node를 삽입하는 함수 활용
                    addNode2Tail(data);
                    return;
                }
                // 삽입 전에 기본 세팅
                // pre_node는 삽입할 위치 전의 node로 할당
                pre_node = cur_node;
                // cur_node는 삽입할 위치 후의 node로 할당
                cur_node = cur_node.next;
                break;
            }
            // 다음 node로 계속 탐색함
            cur_node = cur_node.next;
            // cnt update
            cnt++;
        }
        // 새로운 node 삽입. pre_node와 cur_node 사이에 삽입한다.
        Node new_node = getNode(data);
        pre_node.next = new_node;
        new_node.next = cur_node;
	}

    // 해당 data를 가진 node 삭제하기
	public void removeNode(int data) {
        // head의 data가 찾던 data라면
    	if(head.data == data) {
            // head를 head 다음 node로 바꿈
            head = head.next;
            return;
        }
        // head가 존재한다면, 탐색을 위한 첫 node로 head 할당
        Node cur_node = head;
        Node pre_node = null;
        Node next_node = null;
        while(true) {
            // 끝에 도달했다면
            if(cur_node == null)
                return;
            // 현재 node의 data가 찾던 data와 일치할 경우
            if(cur_node.data == data) {
                // 다음 node를 현재 node의 다음 node로 바꿈
                next_node = cur_node.next;
                break;
            }
            // 다음 node 탐색으로 넘어감
            pre_node = cur_node;
            cur_node = cur_node.next;
        }
        // pre_node의 next를 먼저 설정해뒀던 node로 설정함
        pre_node.next = next_node;
	}
    
    // 출력하기
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
}