import java.util.*;

// Name : 이승준
// Student ID :20171667

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {

	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;// the reference to the root node

	BST() { 
		// BST constructor. 
		root = null;
	}

    void Show() {

		System.out.print( "Pre  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("In   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("Post Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Count      : ");
		System.out.print( Count(root));
		System.out.println("");
		System.out.print("Height      : ");
		System.out.println( Height(root));
		System.out.println("");
	}


	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode<T>(item);
			return true;
		}
		TreeNode<T> ptr, parent;
		ptr = root;
		while(true) {
			if(ptr.data.GetKey() == item.GetKey()) {
				ptr.data = item;
				return false;
			}
			else if(item.GetKey() < ptr.data.GetKey()) {
				parent = ptr;
				if(ptr.leftChild != null)	ptr = ptr.leftChild;
				else {
					ptr = new TreeNode<T>(item);
					parent.leftChild = ptr;
					break;
				}
			}
			else {
				parent = ptr;
				if(ptr.rightChild != null)	ptr = ptr.rightChild;
				else {
					ptr = new TreeNode<T>(item);
					parent.rightChild = ptr;
					break;
				}
			}
		}
		return true;

	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		while(true) {////////////왼쪽 or 오른쪽 
			if(ptr.data.GetKey() == item.GetKey()) {
				return ptr.data;
			}
			else if(item.GetKey() < ptr.data.GetKey()) {
				if(ptr.leftChild != null) {
					ptr = ptr.leftChild;
				}
				else	return null;
			}
			else if(item.GetKey() > ptr.data.GetKey()) {
				if(ptr.rightChild != null) {
					ptr = ptr.rightChild;
				}
				else	return null;
			}
		}
		
	}


	boolean Delete(T item)  {
		if(root == null)
			return false;	// non existing key
		TreeNode<T> parent, current;
		parent = root; current = root;
		while(current.data.GetKey() != item.GetKey()) {
			parent = current;
			if(current.data.GetKey()>item.GetKey())
					current = current.leftChild;
			else
					current = current.rightChild;
			if(current ==null)
					return false;
		}
		if(current.leftChild == null && current.rightChild==null) {//자식없음
			if(current == root) {
				root = null;
				return true;
			}
			if(parent.leftChild == current) {
				parent.leftChild = null;
				return true;
			}
			else {
				parent.rightChild = null;
				return true;
			}
		}
		else if(current.rightChild == null) {//왼쪽만
			if(current == root) {
				root = current.leftChild;
				return true;
			}
			if(parent.leftChild == current) {
				parent.leftChild = current.leftChild;
				return true;
			}
			else {
				parent.rightChild = current.leftChild;
				return true;
			}
		}
		else if(current.leftChild == null) {//d오른쪽만
			if(current == root) {
				root = current.rightChild;
				return true;
			}
			if(parent.leftChild == current) {
				parent.leftChild = current.rightChild;
				return true;
			}
			else {
				parent.rightChild = current.rightChild;
				return true;
			}
		}
		else {//두개다
			TreeNode<T> tempD, secondP;
			secondP = current;
			tempD = current.rightChild;
			while(tempD.leftChild != null) {
				secondP = tempD;
				tempD = tempD.leftChild;
			}
			if(tempD != current.rightChild) {
				if(tempD.rightChild !=null) {
					secondP.leftChild = tempD.rightChild;
					tempD.rightChild = current.rightChild;
				}
				else {
					secondP.leftChild = null;
				}
			}
			tempD.leftChild = current.leftChild;
			tempD.rightChild = current.rightChild;
			if(current == root) {
				root = tempD;
				return true;
			}
			if(parent.leftChild == current) {
				parent.leftChild = tempD;;
				return true;
			}
			else {
				parent.rightChild = tempD;
				return true;
			}
		}
	}

	void  PreOrder(TreeNode<T> t)  {
		if(t != null) {
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
			if(t.leftChild != null) {
				PreOrder(t.leftChild);
			}
			if(t.rightChild != null) {
				PreOrder(t.rightChild);
			}
		}


	}

	void  InOrder(TreeNode<T> t)  {
		if(t != null) {
			if(t.leftChild != null) {
				InOrder(t.leftChild);
			}
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") " );
			if(t.rightChild != null) {
				InOrder(t.rightChild);
			}
		}
	}

	

	void  PostOrder(TreeNode<T> t)  {
		if(t != null) {
			if(t.leftChild != null) {
				PostOrder(t.leftChild);
			}
			if(t.rightChild != null) {
				PostOrder(t.rightChild);
			}
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
		}

	}

	int  Count(TreeNode<T> t)  {
		if (t == null) {
	        return 0;
	    }
		return 1+Count(t.leftChild) +  Count(t.rightChild);


		
	}

	int  Height(TreeNode<T> t)  {
		if (t == null) {
	        return 0;
	    }
		return 1+Math.max(Height(t.leftChild), Height(t.rightChild));
	    
	}
}


