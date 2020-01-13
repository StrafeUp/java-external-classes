package com.strafeup.task5.part4.model;

import com.strafeup.task5.part4.view.ConsolePrinter;

class Node {
    int data;
    Node parentNode;
    Node leftChildNode;
    Node rightChildNode;
    boolean color;
}

public class RedBlackTree {
    private Node rootNode;
    private Node tempNode;

    public RedBlackTree() {
        tempNode = new Node();
        tempNode.color = false;
        tempNode.leftChildNode = null;
        tempNode.rightChildNode = null;
        rootNode = tempNode;
    }


    private void fixDelete(Node currentNode) {
        Node siblingNode;
        while (currentNode != rootNode && !currentNode.color) {
            if (currentNode == currentNode.parentNode.leftChildNode) {
                siblingNode = currentNode.parentNode.rightChildNode;
                if (siblingNode.color) {
                    siblingNode.color = false;
                    currentNode.parentNode.color = true;
                    leftRotate(currentNode.parentNode);
                    siblingNode = currentNode.parentNode.rightChildNode;
                }
                if (!siblingNode.leftChildNode.color && !siblingNode.rightChildNode.color) {
                    siblingNode.color = true;
                    currentNode = currentNode.parentNode;
                } else {
                    if (!siblingNode.rightChildNode.color) {
                        siblingNode.leftChildNode.color = false;
                        siblingNode.color = true;
                        rightRotate(siblingNode);
                        siblingNode = currentNode.parentNode.rightChildNode;
                    }
                    siblingNode.color = currentNode.parentNode.color;
                    currentNode.parentNode.color = false;
                    siblingNode.rightChildNode.color = false;
                    leftRotate(currentNode.parentNode);
                    currentNode = rootNode;
                }
            } else {
                siblingNode = currentNode.parentNode.leftChildNode;
                if (siblingNode.color) {
                    siblingNode.color = false;
                    currentNode.parentNode.color = true;
                    rightRotate(currentNode.parentNode);
                    siblingNode = currentNode.parentNode.leftChildNode;
                }
                if (!siblingNode.rightChildNode.color && !siblingNode.leftChildNode.color) {
                    siblingNode.color = true;
                    currentNode = currentNode.parentNode;
                } else {
                    if (!siblingNode.leftChildNode.color) {
                        siblingNode.rightChildNode.color = false;
                        siblingNode.color = true;
                        leftRotate(siblingNode);
                        siblingNode = currentNode.parentNode.leftChildNode;
                    }
                    siblingNode.color = currentNode.parentNode.color;
                    currentNode.parentNode.color = false;
                    siblingNode.leftChildNode.color = false;
                    rightRotate(currentNode.parentNode);
                    currentNode = rootNode;
                }
            }
        }
        currentNode.color = false;
    }

    private void exchangeNodes(Node leftNode, Node rightNode) {
        if (leftNode.parentNode == null) {
            rootNode = rightNode;
        } else if (leftNode == leftNode.parentNode.leftChildNode) {
            leftNode.parentNode.leftChildNode = rightNode;
        } else {
            leftNode.parentNode.rightChildNode = rightNode;
        }
        rightNode.parentNode = leftNode.parentNode;
    }

    private void deleteNodeHelper(Node node, int key) {
        Node rootNode = tempNode;
        Node currentNode, parentNode;
        while (node != tempNode) {
            if (node.data == key) {
                rootNode = node;
            }
            if (node.data <= key) {
                node = node.rightChildNode;
            } else {
                node = node.leftChildNode;
            }
        }
        if (rootNode == tempNode) {
            ConsolePrinter.println("Couldn't find key in the tree");
            return;
        }
        parentNode = rootNode;
        boolean parentOriginalColor = parentNode.color;
        if (rootNode.leftChildNode == tempNode) {
            currentNode = rootNode.rightChildNode;
            exchangeNodes(rootNode, rootNode.rightChildNode);
        } else if (rootNode.rightChildNode == tempNode) {
            currentNode = rootNode.leftChildNode;
            exchangeNodes(rootNode, rootNode.leftChildNode);
        } else {
            parentNode = minimum(rootNode.rightChildNode);
            parentOriginalColor = parentNode.color;
            currentNode = parentNode.rightChildNode;
            if (parentNode.parentNode == rootNode) {
                currentNode.parentNode = parentNode;
            } else {
                exchangeNodes(parentNode, parentNode.rightChildNode);
                parentNode.rightChildNode = rootNode.rightChildNode;
                parentNode.rightChildNode.parentNode = parentNode;
            }
            exchangeNodes(rootNode, parentNode);
            parentNode.leftChildNode = rootNode.leftChildNode;
            parentNode.leftChildNode.parentNode = parentNode;
            parentNode.color = rootNode.color;
        }
        if (!parentOriginalColor) {
            fixDelete(currentNode);
        }
    }

    private void fixInsert(Node currentNode) {
        Node uncleNode;
        while (currentNode.parentNode.color) {
            if (currentNode.parentNode == currentNode.parentNode.parentNode.rightChildNode) {
                uncleNode = currentNode.parentNode.parentNode.leftChildNode;
                if (uncleNode.color) {
                    uncleNode.color = false;
                    currentNode.parentNode.color = false;
                    currentNode.parentNode.parentNode.color = true;
                    currentNode = currentNode.parentNode.parentNode;
                } else {
                    if (currentNode == currentNode.parentNode.leftChildNode) {
                        currentNode = currentNode.parentNode;
                        rightRotate(currentNode);
                    }
                    currentNode.parentNode.color = false;
                    currentNode.parentNode.parentNode.color = true;
                    leftRotate(currentNode.parentNode.parentNode);
                }
            } else {
                uncleNode = currentNode.parentNode.parentNode.rightChildNode;
                if (uncleNode.color) {
                    uncleNode.color = false;
                    currentNode.parentNode.color = false;
                    currentNode.parentNode.parentNode.color = true;
                    currentNode = currentNode.parentNode.parentNode;
                } else {
                    if (currentNode == currentNode.parentNode.rightChildNode) {
                        currentNode = currentNode.parentNode;
                        leftRotate(currentNode);
                    }
                    currentNode.parentNode.color = false;
                    currentNode.parentNode.parentNode.color = true;
                    rightRotate(currentNode.parentNode.parentNode);
                }
            }
            if (currentNode == rootNode) {
                break;
            }
        }
        rootNode.color = false;
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root != tempNode) {
            ConsolePrinter.print(indent);
            if (last) {
                ConsolePrinter.print("R----");
                indent += "   ";
            } else {
                ConsolePrinter.print("L----");
                indent += "|  ";
            }
            String sColor = root.color ? "RED" : "BLACK";
            ConsolePrinter.println(root.data + "(" + sColor + ")");
            printHelper(root.leftChildNode, indent, false);
            printHelper(root.rightChildNode, indent, true);
        }
    }

    public Node minimum(Node node) {
        while (node.leftChildNode != tempNode) {
            node = node.leftChildNode;
        }
        return node;
    }

    public Node maximum(Node node) {
        while (node.rightChildNode != tempNode) {
            node = node.rightChildNode;
        }
        return node;
    }

    public void leftRotate(Node currentNode) {
        Node rightChildNode = currentNode.rightChildNode;
        currentNode.rightChildNode = rightChildNode.leftChildNode;
        if (rightChildNode.leftChildNode != tempNode) {
            rightChildNode.leftChildNode.parentNode = currentNode;
        }
        rightChildNode.parentNode = currentNode.parentNode;
        if (currentNode.parentNode == null) {
            this.rootNode = rightChildNode;
        } else if (currentNode == currentNode.parentNode.leftChildNode) {
            currentNode.parentNode.leftChildNode = rightChildNode;
        } else {
            currentNode.parentNode.rightChildNode = rightChildNode;
        }
        rightChildNode.leftChildNode = currentNode;
        currentNode.parentNode = rightChildNode;
    }

    public void rightRotate(Node currentNode) {
        Node leftChildNode = currentNode.leftChildNode;
        currentNode.leftChildNode = leftChildNode.rightChildNode;
        if (leftChildNode.rightChildNode != tempNode) {
            leftChildNode.rightChildNode.parentNode = currentNode;
        }
        leftChildNode.parentNode = currentNode.parentNode;
        if (currentNode.parentNode == null) {
            this.rootNode = leftChildNode;
        } else if (currentNode == currentNode.parentNode.rightChildNode) {
            currentNode.parentNode.rightChildNode = leftChildNode;
        } else {
            currentNode.parentNode.leftChildNode = leftChildNode;
        }
        leftChildNode.rightChildNode = currentNode;
        currentNode.parentNode = leftChildNode;
    }

    public void insert(int key) {
        Node node = new Node();
        node.parentNode = null;
        node.data = key;
        node.leftChildNode = tempNode;
        node.rightChildNode = tempNode;
        node.color = true;

        Node tempNode = null;
        Node currentNode = this.rootNode;
        while (currentNode != this.tempNode) {
            tempNode = currentNode;
            if (node.data < currentNode.data) {
                currentNode = currentNode.leftChildNode;
            } else {
                currentNode = currentNode.rightChildNode;
            }
        }
        node.parentNode = tempNode;
        if (tempNode == null) {
            rootNode = node;
        } else if (node.data < tempNode.data) {
            tempNode.leftChildNode = node;
        } else {
            tempNode.rightChildNode = node;
        }
        if (node.parentNode == null) {
            node.color = false;
            return;
        }
        if (node.parentNode.parentNode == null) {
            return;
        }
        fixInsert(node);
    }

    public void deleteNode(int data) {
        deleteNodeHelper(this.rootNode, data);
    }

    public void printTree() {
        printHelper(this.rootNode, "", true);
    }

}