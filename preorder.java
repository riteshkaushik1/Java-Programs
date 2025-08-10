import java.util.Scanner;

public class preorder {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static Node build(int arr[],int n){
        return insert(arr,n,0);
    }
    static Node insert(int arr[],int n,int i){
        if(i<n && arr[i]!=-1){
            Node temp=new Node(arr[i]);
            temp.left=insert(arr,n,2*i+1);
            temp.right=insert(arr,n,2*i+2);
            return temp;
        }
        return null;
    }
    static void preorder(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Node root=build(arr, n);
        preorder(root);

    }
}