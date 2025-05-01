package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//前序遍历 转为 层序遍历
//输入：hello,2,ok,0,bye,0,test,0,one,1,two,1,a,0
/*
输出：
    3
    hello test one
    ok bye two
    a
 */
public class PreorderTraversal_To_LevelOrderTraversal {
    public static class Comment {
        String text;
        ArrayList<Comment> childs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] all = input.split(",");
        String[] text = new String[all.length / 2];
        int[] count = new int[all.length / 2];
        for (int i = 0; i < all.length; i++) {
            if (i % 2 == 0) {
                text[i / 2] = all[i];
            } else {
                count[(i - 1) / 2] = Integer.parseInt(all[i]);
            }
        }

        int index = 0;
        int maxDeep = 1;
        int[] param = new int[2];
        ArrayList<Comment> roots = new ArrayList<>();
        while (index<text.length){
            Comment root = new Comment();
            int deep = 1;
            param[0] = index;
            param[1] = deep;
            preorderTraversal_to_tree(root, text, count, param);
            index = param[0];
            roots.add(root);
            maxDeep = Math.max(maxDeep, param[1]);
        }
        System.out.println(maxDeep);
        LevelOrderTraversal(roots);

    }

    private static void preorderTraversal_to_tree(Comment root, String[] text, int[] count, int[] param) {
        root.text = text[param[0]];
        root.childs = new ArrayList<>();
        int childsCount = count[param[0]];
        param[0] = param[0] + 1;
        if(childsCount > 0){
            param[1] = param[1] +1;
        }
        for (int i = 0; i < childsCount; i++) {
            Comment child = new Comment();
            root.childs.add(child);
            preorderTraversal_to_tree(child, text, count, param);
        }
    }

    private static void LevelOrderTraversal(ArrayList<Comment> roots) {
        Queue<Comment> queue = new LinkedList<>();
        for(Comment root : roots){
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            String result = "";
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Comment node = queue.poll();
                if(i != size-1){
                    result = result + node.text + " ";
                }else {
                    result = result  + node.text;
                }
                ArrayList<Comment> childs = node.childs;
                if(childs != null){
                    for(Comment child : childs){
                        queue.offer(child);
                    }
                }
            }
            System.out.println(result);
        }

    }

}
