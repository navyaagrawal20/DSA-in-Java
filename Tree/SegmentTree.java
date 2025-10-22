class Segment{
    public static void main(String[] args) {
        int[] arr={3,8,6,7,-2,-8,4,9};
        Segment st = new Segment(arr);
        // st.display();
        System.out.println(st.query(2,5));
    }
    public static class Node{
        int data;
        int startinterval;
        int endinterval;
        Node left;
        Node right;

        public Node(int data, int startinterval, int endinterval) {
            this.data = data;
            this.startinterval = startinterval;
            this.endinterval = endinterval;
        }
    }
    Node root;

    public Segment(int[] arr) {
        // create a tree from the given array
        this.root = buildTree(arr, 0, arr.length - 1);
    }
    private Node buildTree(int[] arr, int start, int end) {
        if(start== end){
            Node leaf= new Node(arr[start], start, end);
            leaf.data= arr[start];
            return leaf;
        }
        // create the new node with the index u have
        Node node= new Node(0, start, end);
        int mid= start + (end - start)/2;
        node.left= buildTree(arr, start, mid);
        node.right= buildTree(arr, mid+1, end);
        node.data= node.left.data+ node.right.data;
        return node;
    }
    public void display(){
            display(this.root);
    }
    private void display(Node node) {
        if(node== null){
            return;
        }
        String str= "";
        if(node.left!= null){
           str= str+ "Interval [" + node.left.startinterval + "," + node.left.endinterval + "] and data " + node.left.data ;
        }else{
            str= str+"no left child ";
        }

        //current node data
        str= str+ "Interval [" + node.startinterval + "," + node.endinterval + "] and data " + node.data ;
        // str+= node.data;
        if(node.right!= null){
           str= str+ "Interval [" + node.right.startinterval + "," + node.right.endinterval + "] and data " + node.right.data;
        }else{
            str= str+"no right child ";
        }
        System.out.println(str);

        //call recursively
        display(node.left);
        display(node.right);
    }


// private void display(Node node) {
//     if (node == null) {
//         return;
//     }

//     String str = "";

//     if (node.left != null) {
//         str += "Left [" + node.left.startinterval + "," + node.left.endinterval + "] = " + node.left.data + " ";
//     } else {
//         str += "no left child ";
//     }

//     // current node
//     str += " <- [" + node.startinterval + "," + node.endinterval + "] = " + node.data + " -> ";

//     if (node.right != null) {
//         str += "Right [" + node.right.startinterval + "," + node.right.endinterval + "] = " + node.right.data;
//     } else {
//         str += "no right child";
//     }

//     System.out.println(str);

//     // recursive calls
//     display(node.left);
//     display(node.right);
// }


    //query
    public int query(int qstart, int qend){
        return query(this.root, qstart, qend);
    }
    private int query(Node node , int qstart, int qend) {
        //completely outside
        if(node.endinterval < qstart || node.startinterval > qend){
            return 0;
        }
        //completely inside
        if(node.startinterval >= qstart && node.endinterval <= qend){
            return node.data;
        }
        //partially inside and partially outside
        int leftans= query(node.left, qstart, qend);
        int rightans= query(node.right, qstart, qend);
        return leftans + rightans;
    }

    //update function 
    public  void  update(int index, int value){
        update(this.root, index, value);
    }
    private  int  update(Node node, int index, int value){
        if(index>= node.startinterval && index<= node.endinterval){
            if(index== node.startinterval && index== node.endinterval){
                node.data= value;
                return node.data;
            }
            else{
                int leftAns= update(node.left, index, value);
                int rightAns= update(node.right, index, value);
                node.data= leftAns +  rightAns; 
                return node.data;    
            }
        } 
        return node.data;
           
    }
}
