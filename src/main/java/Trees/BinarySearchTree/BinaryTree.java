package main.java.Trees.BinarySearchTree;

public class BinaryTree<K, V> {

    //Every single tree no matter what it is will have a root value
    Node root;

    /**
     * during this function, First create a new Node that should have user entered key and value.
     * Then check if their already is a root value or not, hence if the tree is present or not.
     * Once the tree is found, create a focusNode which at first hold root value and then create
     * parentNode that will hold focusNode inside the while loop. Create a always true while loop.
     * Inside that loop check if the key entered by user is smaller than focusNode.key or not. If
     * it is then make leftChild the focusNode otherwise make rightChild the focusNode. Once, the
     * perfect spot is found and it's null, put the newNode at that position using parentNode.side_child
     */
    public <K extends Comparable> void addNode(K key, V name){
        //TODO create a new node(One box), with parameters same as passed by user
        Node newNode = new Node(key, name);

        //Check if their is any tree present or not
        //TODO is not the above node as root node.
        if (root == null){
            root = newNode;//root gets the newNode
        }
        // if the root is not null
        else{
            //The focusNode is the node which is in focus. Hence, from that node we can determine it's left and right child and parent as well.
            //TODO Create a focus node and give it the value of node.
            Node focusNode = root;
            Node parent;//TODO create a parentNode.

            //TODO you want some kinda loop which is always true until it goes to return statement...
            while (true){
                //parent node should be focusNode.
                //parent node will remain constant throughout the loop but the focusNode can change
                //*Everytime the while runs and focusNode is not null the parentNode will be the focusNode
                parent = focusNode;

                //If the key entered is smaller by focusnode, put the key in the left until you did not hit the null
                if(key.compareTo(focusNode.key) < 0){
                    //TODO put the node at the left side of the focus node in focus.
                    focusNode = focusNode.leftChild;

                    //If the left side is null put the key over there.
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                } else{
                    //TODO put the node at the right side of the focusnode in focus
                    focusNode = focusNode.rightChild;

                    //If the right node is null give that the key value.
                    if(focusNode == null){
                        //Parent should always be inside for loop.
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * In this Method, first we create a focusNode, with root value as starting value. From there, create
     * a while loop and if the key is smaller go left otherwise right, by changing the focusNode value to
     * preferred side. Once the key is equal to focusNode.key end the while loop and return that node.
     */
    public <K extends Comparable> Node findNode(K key){
        //TODO create a new node as focusNode with value root
        Node focusNode = root;

        //TODO start a while loop, until the is not equal to focusNode.key
        while(key != focusNode.key){
            //TODO if the focus node is smaller then key, go to the left node of focus node and transfer that left node to focusNode
            if (key.compareTo(focusNode.key) < 0){
                focusNode = focusNode.leftChild;
            }
            //TODO else go to the right node of focusNode and transfer that right node to focusNode
            else {
                focusNode = focusNode.rightChild;
            }
            //Keep going to the node until the key is not found.
        }

        if (focusNode == null){
            return null;
        }

        //TODO once the key is found return the key.
        return focusNode;
    }


    //? ASK PAUL...
    public <K extends Comparable> boolean remove(K key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.key != key) {
            parent = focusNode;

            if (key.compareTo(focusNode.key) < 0) {
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return false;
            }

        }

        //If it doesn't have a child just set it to root
        if (focusNode.rightChild == null && focusNode.leftChild == null){
            if(focusNode == root){
                root = null;
            } else if (isItALeftChild){
                parent.leftChild = null;
            } else{
                parent.rightChild = null;
            }
        }

        else if(focusNode.rightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            } else if(isItALeftChild){
                parent.leftChild = focusNode.leftChild;
            } else{
                parent.rightChild = focusNode.leftChild;
            }
        }

        else if(focusNode.leftChild == null){

            if(focusNode == root){
                root = focusNode.rightChild;
            } else if (isItALeftChild){
                parent.leftChild = focusNode.rightChild;
            } else{
                parent.rightChild = focusNode.rightChild;
            }
        }

        else{
            Node replacement = getReplacementNode(focusNode);

            if(focusNode == root){
                root = replacement;
            }else if(isItALeftChild){
                parent.leftChild = replacement;
            } else{
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    /**
     * To print the Binary tree
     * @param focusNode
     */
    public void inOrderTraverseTree(Node focusNode){
        if (focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if (focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if (focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public static void main(String[] args){
        BinaryTree<Integer, String> theTree = new BinaryTree<>();

        theTree.addNode(25, "Vice pres");
        theTree.addNode(50, "Boss");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Sec");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "SalesMan");

        theTree.remove(25);

        theTree.inOrderTraverseTree(theTree.root);

        System.out.println((theTree.findNode(30)));
    }
}
