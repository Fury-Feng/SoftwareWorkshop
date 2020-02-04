package school.secondweek;

/**
 * @author FUWEI FENG
 * This class contains the solution for Worksheet2
 * This class has 11 methods.
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1
	/**
	 * The negateAll method is used to returns a new tree containing all the elements of a with their sign negated.
	 * @param t the tree that need to be negated
	 * @return a new tree with their sign negated.
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if(t.isEmpty()) {
			return new Tree<>();
		} else {
			return new Tree<>(t.getValue() * (-1), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	// Exercise 2
	/**
	 * The allEven method is used to indicate whether all the values in its nodes are even.
	 * @param a The tree need to be indicated.
	 * @return true(if the tree is all even) false(if the tree is not all even)
	 */
	static boolean allEven(Tree<Integer> a) {
		if(a.isEmpty()) {
			return true;
		} else {
			if(a.getValue() % 2 == 0) {
				return allEven(a.getLeft()) && allEven(a.getRight());
			} else {
				return false;
			}
		}
	}

	// Exercise 3

	/**
	 * The depth method is used to get the depth of the given node value.
	 * In the depth method it use recordDepth method to get the depth.
	 * @param a the tree need to be found.
	 * @param x the value need to find
	 * @return the depth of the depth of the value or -1(if the value is not in the tree)
	 */
	static int depth(Tree<Integer> a, int x) {
		return recordDepth(a, x, 0);
	}

	/**
	 * This is the helper method to record the depth of recent node.
	 * @param a the tree need to be found.
	 * @param x the value need to find
	 * @param deep the depth of current node.
	 * @return the depth of current node or -1(if the value is not in the tree)
	 */
	static int recordDepth(Tree<Integer> a, int x, int deep) {
		if(a.isEmpty()) {
			return -1;
		} else {
			if(a.getValue().equals(x)) {
				return deep;
			}
			if(recordDepth(a.getLeft(), x, deep + 1) == -1) {
				return recordDepth(a.getRight(), x, deep+1);
			} else {
				return recordDepth(a.getLeft(), x, deep + 1);
			}
		}
	}

	// Exercise 4

	/**
	 * The preorder method is used to return a list containing the values in a by traversing the nodes in preorder.
	 * @param a the tree
	 * @param <E> Generic type
	 * @return a list that contain the values in preorder.
	 */
	static <E> List<E> preorder(Tree<E> a) {
		if(a.isEmpty()) {
			return new List<E>();
		}
		return new List<E>(a.getValue(), append(preorder(a.getLeft()), preorder(a.getRight())));
	}

	/**
	 * The append method is used to append creates a new list by appending two given lists.
	 * @param list1	the first list
	 * @param list2 the second list
	 * @param <E> Generic type
	 * @return the new list with list1 and list2.
	 */
	static <E> List<E> append(List<E> list1, List<E> list2) {
		if(list1.isEmpty()) {
			return list2;
		} else {
			return new List<E>(list1.getHead(), append(list1.getTail(), list2));
		}
	}

	// Exercise 5

	/**
	 * The isSearchTree method is used to indicate whether the tree is a binary search tree.
	 * @param a the tree need to be indicated
	 * @return true(if the tree is a binary search tree) or false(if the tree is a binary search tree)
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		return helpSearchTree(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * The helpSearchTree method is a helper function to get the boolean value.
	 * @param a the tree need to be indicated
	 * @param minVal the minimum value of the elements in the tree
	 * @param maxVal the maximum value of the elements in the tree
	 * @return true(if the tree is a binary search tree) or false(if the tree is a binary search tree)
	 */
	static boolean helpSearchTree(Tree<Integer> a, int minVal, int maxVal) {
		if(a.isEmpty()) {
			return true;
		} else {
			if(a.getValue() > minVal && a.getValue() < maxVal) {
				return helpSearchTree(a.getLeft(), minVal, a.getValue()) && helpSearchTree(a.getRight(), a.getValue(), maxVal);
			} else {
				return false;
			}
		}
	}

	// Exercise 6

	/**
	 * The printDescending method is used to print the values stored in it in descending order.
	 * @param a the tree need to be printed
	 */
	static void printDescending(Tree<Integer> a) {
		if(a.isEmpty()) {
			return;
		} else {
			printDescending(a.getRight());
			System.out.println(a.getValue() + " ");
			printDescending(a.getLeft());
		}
	}

	// Exercise 7

	/**
	 * The max method is used to find the maximum value stored in the tree.
	 * @param a the tree need to be found
	 * @return the maximum value in the tree
	 */
	static int max(Tree<Integer> a) {
		if(a.isEmpty()) {
			return -1;
		} else {
			if(a.getRight().isEmpty()) {
				return a.getValue();
			} else {
				return max(a.getRight());
			}
		}

	}

	// Exercise 8

	/**
	 * The delete method is used to delete the value from tree and return the resulting tree.
	 * @param a the tree
	 * @param x the value need to be deleted
	 * @return the resulting tree
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if(a.isEmpty()) {
			return new Tree<>();
		} else {
			if(a.getValue() > x) {
				return new Tree<>(a.getValue(), delete(a.getLeft(), x), a.getRight());
			} else if(a.getValue() < x) {
				return new Tree<>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
			} else {
				if(!a.getLeft().isEmpty() && !a.getRight().isEmpty()) {
					return new Tree<>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
				} else if(!a.getLeft().isEmpty()) {
					return a.getLeft();
				} else if(!a.getRight().isEmpty()) {
					return a.getRight();
				} else {
					return new Tree<>();
				}
			}
		}
	}

	// Exercise 9

	/**
	 * The is HeightBalanced method is used to indicated whether the tree is a height balanced tree.
	 * @param a the tree
	 * @param <E> the Generic type
	 * @return true(if the tree is a height balanced tree) or false(if the tree is not a height balanced tree)
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if(a.isEmpty()) {
			return true;
		} else {
			if((a.getRight().getHeight() - a.getLeft().getHeight()) <= 1 && (a.getRight().getHeight() - a.getLeft().getHeight()) >= -1) {
				return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
			} else {
				return false;
			}
		}
	}

	// Exercise 10

	/**
	 * The insertHB method is used to insert a value into the tree, and maintain the height balanced tree.
	 * @param a the tree
	 * @param x the value need insert
	 * @return the inserted height-balanced tree
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if(a.isEmpty()) {
			return new Tree<>(x);
		} else {
			if(x < a.getValue()) {
				return rotation(new Tree<>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()));
			} else if(x > a.getValue()) {
				return rotation(new Tree<>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)));
			} else {
				return rotation(a);
			}
		}
	}

	/**
	 * The deleteHB method is used to delete a value from the tree, and maintain the height-balanced tree.
	 * @param a the tree
	 * @param x the value need delete
	 * @return the deleted height-balanced tree
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if(a.isEmpty()) {
			return new Tree<>();
		} else {
			if(a.getValue() > x) {
				return rotation(new Tree<>(a.getValue(), deleteHB(a.getLeft(), x), a.getRight()));
			} else if(a.getValue() < x) {
				return rotation(new Tree<>(a.getValue(), a.getLeft(), deleteHB(a.getRight(), x)));
			} else {
				if(!a.getLeft().isEmpty() && !a.getRight().isEmpty()) {
					return rotation(new Tree<>(max(a.getLeft()), deleteHB(a.getLeft(), max(a.getLeft())), a.getRight()));
				} else if(!a.getLeft().isEmpty()) {
					return rotation(a.getLeft());
				} else if(!a.getRight().isEmpty()) {
					return rotation(a.getRight());
				} else {
					return new Tree<>();
				}
			}
		}
	}

	/**
	 * The rotation method is used to maintain the height-balanced tree.
	 * @param a the tree need to be height balanced.
	 * @return the height-balanced tree
	 */
	static Tree<Integer> rotation(Tree<Integer> a) {
		if(isHeightBalanced(a)) {
			return a;
		} else {
			if(a.getRight().getHeight() - a.getLeft().getHeight() == -2) {
				if(a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == -1) {
					return rotateRight(a);
				} else if(a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == 1) {
					return rotateLR(a);
				} else if(a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == 0) {
					return rotateRight(a);
				} else {
					return new Tree<Integer>(a.getValue(), rotation(a.getLeft()), a.getRight());
				}
			} else if(a.getRight().getHeight() - a.getLeft().getHeight() == 2) {
				if(a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == 1) {
					return rotateLeft(a);
				} else if(a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == -1) {
					return rotateRL(a);
				} else if(a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == 0) {
					return rotateLeft(a);
				} else {
					return new Tree<Integer>(a.getValue(), a.getLeft(), rotation(a.getRight()));
				}
			} else {
				return new Tree<Integer>(a.getValue(), rotation(a.getLeft()), rotation(a.getRight()));
			}
		}
	}

	/**
	 * The rotateRight method is used to single right rotation the tree.
	 * @param a the tree need to be rotated
	 * @return the rotated tree
	 */
	static Tree<Integer> rotateRight(Tree<Integer> a) {
		return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), new Tree<>(a.getValue(), a.getLeft().getRight(), a.getRight()));
	}

	/**
	 * The rotateLeft method is used to single left rotation the tree
	 * @param a the tree need to be rotated
	 * @return the rotated tree
	 */
	static Tree<Integer> rotateLeft(Tree<Integer> a) {
		return new Tree<Integer>(a.getRight().getValue(), new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft()), a.getRight().getRight());
	}

	/**
	 * The rotateLR method is used to LR rotation(double) the tree.
	 * @param a the tree need to be rotated
	 * @return the rotated tree
	 */
	static Tree<Integer> rotateLR(Tree<Integer> a) {
		return rotateRight(new Tree<>(a.getValue(), rotateLeft(a.getLeft()), a.getRight()));
	}

	/**
	 * The rotateRL method is used to RL rotation(double) the tree.
	 * @param a the tree need to be rotated
	 * @return the rotated tree
	 */
	static Tree<Integer> rotateRL(Tree<Integer> a) {
		return rotateLeft(new Tree<>(a.getValue(), a.getLeft(), rotateRight(a.getRight())));
	}



	public static void main(String[] args) {
		Tree<Integer> t = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>(4)), new Tree<>(6));
		Tree<Integer> a = new Tree<>(84,new Tree<>(), new Tree<>(98, new Tree<>(90), new Tree<>()));
		Tree<Integer> t1 = new Tree<>(3, new Tree<>(2, new Tree<>(1), new Tree<>()), new Tree<>());
		Tree<Integer> t2 = new Tree<>(10, new Tree<>(5, new Tree<>(2, new Tree<>(1), new Tree<>(3)), new Tree<>(6)), new Tree<>(15));
		Tree<Integer> t3 = new Tree<>(84, new Tree<>(48, new Tree<>(45), new Tree<>(50, new Tree<>(49), new Tree<>(59))), new Tree<>(89));
//		System.out.println(negateAll(t));
//		System.out.println(allEven(t));
//		System.out.println(depth(t, 9));
//		System.out.println(preorder(t));
//		System.out.println(isSearchTree(t));
//		printDescending(t);
//		printDescending(t);
//		System.out.println(t);
//		System.out.println(delete(t, 3));
//		System.out.println(t.getHeight());
//		System.out.println(isHeightBalanced(t));
//		System.out.println(a);
//		System.out.println(isHeightBalanced(a));
//		System.out.println(t1);
//		System.out.println(rotateRight(t1));
//		System.out.println(rotateLR(t3));
		Tree<Integer> t4 = new Tree<>(5, new Tree<>(4, new Tree<>(3), new Tree<>()), new Tree<>(6));
		System.out.println(isHeightBalanced(t4));
		System.out.println(t4);
		System.out.println(insertHB(t4, 2));
		Tree<Integer> t5 = insertHB(t4, 2);
		System.out.println(t5);
		System.out.println(deleteHB(t5, 6));
	}

}

