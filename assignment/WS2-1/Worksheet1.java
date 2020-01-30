/**
 * @author FUWEI FENG
 * This class contains the solution for Worksheet1
 * This class has 8 methods.
 */

 public class Worksheet1 {
	// Exercise 1

	/**
	 * The power method is used to raise integer m to the power of integer n.
	 * @param m	the base of the result
	 * @param n the power of the result
	 * @return the result that m is raised to the power of n
	 */
	static int power(int m, int n) {
		if(m==0) {
			return 0;
		} else {
			if(n == 0) {
				return 1;
			} else {
				return m * power(m, n-1);
			}
		}

	}

	/**
	 * The fastPower method is used to raise integer m to the power of integer n in a more efficient way.
	 * @param m the base of the result.
	 * @param n the power of the result.
	 * @return the result that m is raised to the power of n.
	 */
	static int fastPower(int m, int n) {
		if(m == 0) {
			return 0;
		} else {
			if(n == 0) {
				return 1;
			} else if (n % 2 == 0) {  // n is even
				return fastPower(m*m, n/2);
			} else {  // n is odd
				return fastPower(m*m, n/2) * m;
			}
		}
	}

	// Exercise 2

	/**
	 * The negateAll method is used to return a new list with all the elements of the list with sign negated.
	 * @param a	the list need to be negated.
	 * @return the new list that has been negated.
	 */
	static List<Integer> negateAll(List<Integer> a) {
	 	if(a.isEmpty()) {
	 		return new List<Integer>();
		} else {
	 		return new List<Integer>(a.getHead()*(-1), negateAll(a.getTail()));
		}
	}

	// Exercise 3

	/**
	 * The find method is used to find the position of the first occurrence of x in the list a.
	 * @param x The number that need to be found in the list.
	 * @param a	The list to be searched.
	 * @return The position of the number in the list.
	 */
	static int find(int x, List<Integer> a) {
		if(a.isEmpty()) {
			throw new IllegalArgumentException("There is not the number in the list");
		} else {
			if(a.getHead().equals(x)) {
				return 0;
			} else {
				return 1 + find(x, a.getTail());
			}
		}
	}

	// Exercise 4

	/**
	 * The allEven method is used to indicate that whether all the list's elements are even.
	 * @param a	The list need to be indicate
	 * @return true(if all the elements are even)   false(if not all the elements are even)
	 */
	static boolean allEven(List<Integer> a) {
		if(a.isEmpty()) {
			return true;
		} else {
			if(a.getHead() % 2 == 0) {
				return allEven(a.getTail());
			} else {
				return false;
			}
		}
	}

	// Exercise 5

	/**
	 * The evenNumbers method is used to return a new list which contains all the even elements of the list a.
	 * @param a the list need to be found the even number.
	 * @return the new list contains the even number.
	 */
	static List<Integer> evenNumbers(List<Integer> a) {
		if(a.isEmpty()) {
			return new List<Integer>();
		} else {
			if(a.getHead() % 2 == 0) {
				return new List<Integer>(a.getHead(), evenNumbers(a.getTail()));
			} else {
				return evenNumbers(a.getTail());
			}
		}
	}

	// Exercise 6

	/**
	 * The sorted method is used to know whether the list is sorted.
	 * @param a the list need to be recognized that whether the list is sorted.
	 * @return true(if the list is sorted) false(if the list is not sorted).
	 */
	static boolean sorted(List<Integer> a) {
		if(a.isEmpty()) {
			return true;
		} else {
			if(a.getTail().isEmpty()) {
				return true;
			} else {
				if(a.getHead() >= a.getTail().getHead()) {
					return sorted(a.getTail());
				} else {
					return false;
				}
			}
		}
	}

	// Exercise 7

	/**
	 * The merge method is used to merge the list a and list b.
	 * @param a The first list need to merge
	 * @param b The second list need to merge
	 * @return a new list contains all the elements of a and all the elements of b.
	 */
	static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if(a.isEmpty()) {
			return b;
		} else if(b.isEmpty()) {
			return a;
		} else {
			if(b.getHead() >= a.getHead()) {
				return merge(new List<>(b.getHead(), a), b.getTail());
			} else {
				return new List<>(a.getHead(), merge(a.getTail(),b));
			}
		}
	}

	// Exercise 8

	/**
	 * The removeDuplicates method is used to remove the duplicate elements in the list.
	 * @param a  the list.
	 * @return the new list without duplicate elements.
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if(a.isEmpty()) {
			return new List<>();
		} else {
			if(a.getTail().isEmpty()) {
				return a;
			} else {
				if(a.getHead() == a.getTail().getHead()) {
					return removeDuplicates(a.getTail());
				} else {
					return new List<>(a.getHead(), removeDuplicates(a.getTail()));
				}
			}
		}
	}
}
