import java.util.*;

public class DFSBFS1260 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int startNode = sc.nextInt();


        Node[] nodes = new Node[nodeCount];
        for(int k=0; k<nodeCount; k++){
            nodes[k]=new Node(k+1); // 1, 2, 3, 4
        }
        
        for(int j =0; j<lineCount; j++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            nodes[n1-1].links.add(nodes[n2-1]);
            nodes[n2-1].links.add(nodes[n1-1]);
        }

        for(Node n : nodes) n.links.sort(new Com());
//---------------------------------------------------------------//
        Queue<Node> q = new LinkedList<>();
        List<String> a = new LinkedList<>();
        q.add(nodes[startNode-1]);
        a.add(String.valueOf(startNode));

        while(!q.isEmpty()){
            Node now = q.poll();
            now.visit = true;

            for(Node l : now.links){
                if(l.visit || q.contains(l)) continue;
                a.add(String.valueOf(l.i));
                q.add(l);
            }
        }
        
        for(Node l : nodes) {
            l.visit = false;
        }

        Stack<Node> stack = new Stack<>();
        List<String> s = new LinkedList<>();

        stack.push(nodes[startNode-1]);
        s.add(String.valueOf(startNode));

        while(!stack.isEmpty()){
            Node now = stack.pop();
            now.visit = true;
            System.out.println(now.i);
            for(Node l : now.links){
                if(l.visit||stack.contains(l)) continue;
                // s.add(String.valueOf(l.i));
                stack.add(l);
                // break;
            }
        }
        String ss = String.join(" ", s);
        String aa = String.join(" ", a);
        // System.out.println(ss);
        // System.out.println(aa);
    }
    static class Com implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.i, o2.i);
        }
    }
    static class Node{
        int i = 0;
        List<Node> links = new LinkedList<>();
        boolean visit = false;
        Node(int i) { this.i = i;}
    }
}
