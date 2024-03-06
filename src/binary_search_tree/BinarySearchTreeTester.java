package binary_search_tree;

public class BinarySearchTreeTester {
    public static void main(String[] args) {

        BinarySearchTree bt = new BinarySearchTree();

        bt.insert(new Node(5));
        bt.insert(new Node(4));
        bt.insert(new Node(10));
        bt.insert(new Node(42));
        bt.insert(new Node(1));
        bt.insert(new Node(0));
        bt.insert(new Node(9));
        bt.insert(new Node(11));

        System.out.println(bt.search(42));

        System.out.println();

        bt.display();




    }
}
