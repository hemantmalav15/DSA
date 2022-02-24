import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
//  This function swaps List of Children Nodes
  public static void swap(ArrayList<Node> al){
    int i = 0;
    int j = al.size()-1;

    while(i < j){
      Node temp = al.get(i);
      al.set(i,al.get(j));
      al.set(j,temp);

      i++;
      j--;
    }
  }

  public static void mirror(Node node){
    
    Queue<Node> q = new LinkedList<Node>();
    q.add(node);

    while(q.size() > 0){
      node = q.remove();
      swap(node.children);

      for(Node child: node.children){
        q.add(child);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    display(root);
    mirror(root);
    display(root);
  }

}