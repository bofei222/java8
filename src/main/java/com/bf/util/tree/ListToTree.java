package com.bf.util.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Tree to be created
 * 1 --> 2
 *       --> 3
 *       --> 4 --> 5
 *
 */
public class ListToTree {

    public static void main(String[] args) {

        //Create a List of nodes
        Node node1 = new Node("Five", "5", "4");
        Node node2 = new Node("Four", "4", "2");
        Node node3 = new Node("Two",  "2", "1");
        Node node4 = new Node("Three", "3", "2");
        Node node5 = new Node("One",   "1", null);  // root as parentId is null

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        //convert to a tree
        createTree(nodes);

    }

    private static void createTree(List<Node> nodes) {

        Map<String, Node> mapTmp = new HashMap<>();

        //Save all nodes to a map
        for (Node current : nodes) {
            mapTmp.put(current.getId(), current);
        }

        //loop and assign parent/child relationships
        // 找到所有的父节点，
        // 并设置child关联关系， 即可通过引用 链接起来
        for (Node current : nodes) {
            String parentId = current.getParentId();

            // 当pId是null 是根节点
            if (parentId != null) {
                Node parent = mapTmp.get(parentId);
//                if (parent != null) {
//                    current.setParent(parent);
                    parent.addChild(current);
//                    mapTmp.put(parentId, parent);
//                    mapTmp.put(current.getId(), current);
//                }
            }

        }


        //get the root
        Node root = null;
        for (Node node : mapTmp.values()) {
            if(node.getParent() == null) {
                root = node;
                break;
            }
        }

        System.out.println(root);
    }
}

