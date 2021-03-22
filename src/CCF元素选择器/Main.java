package CCF元素选择器;
import java.util.*;

class Node{
    int level;
    String div;
    String id;
}
public class Main{
    private static Scanner cin;
    public static List<Node> list = new ArrayList<>();
    public static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[] args) {
        cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        cin.nextLine();

        list.clear();
        for(int i=1;i<=n;i++){
            String tmp = cin.nextLine();
            //System.out.println("读入的是 " + tmp);
            Node node = new Node();
            int pos = 0;
            while (tmp.charAt(pos) == '.'){
                pos++;
            }
            node.level = pos;
            tmp = tmp.substring(pos);
            for(String item : tmp.split(" ")){
                if(item.charAt(0) == '#')
                    node.id = item;
                else node.div = item;
            }
            list.add(node);
        }

//        for(Node node : list){
//            System.out.println(node.level + "   " + node.div + "   " + node.id);
//        }

        while(m-->0){
            set.clear();
            String choose = cin.nextLine();
            String [] chooses = choose.split(" ");

            dfs(0,-1,0,chooses);
            System.out.print(set.size());
            for(Integer item : set){
                System.out.print(" "+item);
            }
            System.out.println();
        }
    }
    public static  void dfs(int idx,int fatherLevel ,int idc, String[] chooses){
        // System.out.println("我现在要寻找: "+ chooses[idc] + " 我在数组处于: "+ idx + " 在查找数组里处于: " + idc);

        if(idc == chooses.length){
            //System.out.println("get到的idx "+ idx);
            set.add(idx);
            return ;
        }
        // 找不到了，返回
        if(idx == list.size())
            return  ;
        for(int i = idx;i<list.size();i++){
            Node node = list.get(i);
            if(node.level <= fatherLevel)
                return  ;
            String choose = chooses[idc];
            //System.out.println("当前处理  " + choose);
            if( (node.div!=null && node.div .equalsIgnoreCase(choose)) ||(node.id!=null&& node.id.equals(choose)) ){
                //System.out.println("找到了一个 " + choose + "下一个处理: " + idc);
                dfs(i+1,node.level,idc+1,chooses);

            }
        }

    }
}
/*
11 5
html
..head
....title
..body
....h1
....p #subtitle
....div #main
......h2
......p #one
......div
........p #two




*/

