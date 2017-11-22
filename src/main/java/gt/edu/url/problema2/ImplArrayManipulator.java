package gt.edu.url.problema2;


public class ImplArrayManipulator<E> implements ArrayManipulator<E>{

	@Override
	public int subsets(List<E> set) {
		// TODO Auto-generated method stub
		
		int n = set.size();
		E temp;
		int cont;
		if(n == 1) {
			for(int i = 0; i < set.size(); i++) {
				System.out.println(set.remove(i));
			}
		}
		else {
			for(int i = 0; i < (n - 1); i++) {
				subsets(set);
				if(n % 2 == 0) {
					temp = set.get(i);
					set.set(i, set.get(n - 1));
					set.set(n - 1, temp);
				}
				else {
					temp = set.get(0);
					set.set(0, set.get(n - 1));
				}
			}
			subsets(set);
		}
		
		return 0;
	}

}
