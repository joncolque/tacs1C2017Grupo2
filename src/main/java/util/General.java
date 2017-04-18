package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class General {

	public static Set<Integer> findDuplicateIntegers(List<Integer> inList) {
		List<Integer> copia = new ArrayList<Integer>(inList);
		for(Integer valor : new HashSet<Integer>(inList)) {
			copia.remove(valor);
		}
		return new HashSet<Integer>(copia);
	}
	
}
