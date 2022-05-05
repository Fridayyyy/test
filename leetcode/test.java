import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans=root;
        while (true){
            if (p.val<ans.val&&q.val< ans.val){
                ans=ans.left;
            }else if (q.val> ans.val&&p.val> ans.val){
                ans=ans.right;;
            }else {
                break;
            }
        }
        return ans;
    }
    public boolean findTarget2(TreeNode root, int k) {
        if (root==null) return false;
        Queue<TreeNode>queue=new LinkedList<>();
        Set<Integer>set=new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if (set.contains(k- temp.val)){
                return true;
            }else {
                set.add(temp.val);
            }
            if (temp.left!=null){
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                queue.offer(temp.right);
            }
        }
        return false;
    }
    public boolean findTarget1(TreeNode root, int k) {
        if (root==null){
            return false;
        }
        Set<Integer>set=new HashSet<>();
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()){
            if (root!=null){
                if (set.contains(k- root.val)){
                    return true;
                }
                set.add(root.val);
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                if (set.contains(k- root.val)){
                    return true;
                }
                set.add(root.val);
                root=root.right;
            }
        }
        return false;
    }

    public boolean isValidBST1(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode pre=null;
        while (!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                if (pre!=null&&root.val<=pre.val) return false;
                pre=root;
                root=root.right;
            }
        }
        return true;



    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp=new TreeNode(val);
        TreeNode pos=root;
        if (root==null){
            return temp;
        }
        while (pos!=null){
            if (pos.val>val){
                if (pos.left==null){
                    pos.left=temp;
                    break;
                }else {
                    pos=pos.left;
                }
            }else {
                if (pos.right==null){
                    pos.right=temp;
                    break;
                }else {
                    pos=pos.right;
                }
            }
        }
        return root;
    }
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val==val){
            return root;
        }
        return searchBST1(root.val<val?root.right:root.left,val);
    }
    public TreeNode searchBST2(TreeNode root,int val){
        if (root==null) return null;
        while (root!=null){
            if (root.val==val){
                return root;
            }else {
                root=root.val<val?root.right:root.left;
            }
        }
        return null;
    }
    public boolean hasPathSum2(TreeNode root,int targetSum){
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum2(root.left,targetSum-root.val)||hasPathSum2(root.right,targetSum- root.val);
    }
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        Queue<Integer>valQueue=new LinkedList<>();
        queue.offer(root);
        valQueue.offer(root.val);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            int curVal= valQueue.poll();
            if (cur.left==null&&cur.right==null){
                if (curVal==targetSum){
                    return true;
                }
                continue;
            }
            if (cur.left!=null){
                queue.offer(cur.left);
                valQueue.offer(curVal+cur.left.val);
            }
            if (cur.right!=null){
                queue.offer(cur.right);
                valQueue.offer(curVal+cur.right.val);
            }
        }
        return false;
    }
    public TreeNode invertTree3(TreeNode root){
        if (root==null){
            return null;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size=stack.size();
            for (int i=0;i<size;i++){
                TreeNode cur=stack.pop();
                TreeNode temp=cur.left;
                cur.left=cur.right;
                cur.right=temp;
                if (cur.left!=null){
                    stack.push(cur.left);
                }
                if (cur.right!=null){
                    stack.push(cur.right);
                }
            }
        }
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public TreeNode invertTree2(TreeNode root){
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            TreeNode left=temp.left;
            temp.left=temp.right;
            temp.right=left;
            if (temp.right!=null){
                queue.offer(temp.right);
            }
            if (temp.left!=null){
                queue.offer(temp.left);
            }
        }
        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
    public int MaxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode temp=queue.poll();
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }
    public boolean check(TreeNode m,TreeNode n){
        if (m==null&&n==null){
            return true;
        }
        if (m==null||n==null){
            return false;
        }
        return m.val==n.val&& check(m.left,n.right)&&check(m.right,n.left);
    }
    public Node.ListNode deleteDuplicates(Node.ListNode head) {
        Node.ListNode res=new Node.ListNode(-1);
        res.next=head;
        Node.ListNode tmp=res;
        while (tmp!=null){
            if (tmp.val==tmp.next.val){
                tmp.next=tmp.next.next;
            }
            tmp=tmp.next;
        }
        return res.next;
    }

    public List<List<Integer>> BFI(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null){
            return res;
        }
        //List<List<Integer>> res=new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()>0){
            int size=queue.size();
            LinkedList<Integer> temp=new LinkedList<>();
            for (int i=0;i<size;i++){
                TreeNode node=queue.remove();
                temp.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val=val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }
    public Node.ListNode reverseList(Node.ListNode head) {
        Node.ListNode pre=null;
        Node.ListNode cur=head;

        while (cur!=null){
            Node.ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
    public Node.ListNode removeElements(Node.ListNode head, int val) {
        if (head==null) return null;
        Node.ListNode dum=new Node.ListNode(-1);
        dum.next=head;
        Node.ListNode temp=dum;
        while (temp.next!=null){
            if (temp.next.val==val){
                temp=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return dum.next;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        int[] res=new int[26];
        for (int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            res[c-'a']++;
        }
        for (char c:magazine.toCharArray()){
            res[c-'a']--;
            if (res[c-'a']<0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        int[] res=new int[26];
        for (char c:s.toCharArray()){
            res[c-'a']++;
        }
        for (char c:t.toCharArray()){
            res[c-'a']--;
        }
        for (int i:res){
            if (i!=0) return false;
        }
        return true;
    }
    public int firstUniqChar(String s) {
        char[] temp=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (char t:temp){
            int count=map.getOrDefault(t,0)+1;
            map.put(t,count);
        }
        int ans=-1;
        for (int i=0;i<s.length();i++){
            if (map.get(temp[i])==1){
                ans=i;
                break;
            }
        }
        return ans;
    }
    public boolean isValidSudoku(char[][] board) {
        int[][] rows=new int[9][9];
        int[][] col=new int[9][9];
        int[][][] box=new int[9][9][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c=board[i][j];
                if (c!='.'){
                    int num=c-'0'-1;
                    rows[i][num]++;
                    col[j][num]++;
                    box[i/3][j/3][num]++;
                    if (rows[i][num]>1||rows[j][num]>1||box[i/3][j/3][num]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (row[i]||row[j]==true){
                    matrix[i][j]=0;
                }
            }
        }

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r*c!=mat.length*mat[0].length){
            return mat;
        }
        int[][] res=new int[r][c];
        for (int x=0;x< mat.length*mat[0].length;++x){
            res[x/c][x%c]=mat[x/mat[0].length][x% mat[0].length];
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            for (int j=0;j<numRows;j++){
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
class  MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack=new ArrayDeque<>();
        outStack=new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
}
