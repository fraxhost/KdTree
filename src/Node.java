/*
public class Node {
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
        right = null;
        left = null;
    }
}
*/

public class Node {
    int[] value;
    Node left;
    Node right;

    Node(int[] value){
        this.value = value.clone();
        right = null;
        left = null;
    }
}
