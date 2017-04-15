package util;

import java.util.Comparator;

import model.FavoritoActor;

public class FavComparator implements Comparator<FavoritoActor> {

	@Override
	public int compare(FavoritoActor o1, FavoritoActor o2) {
		if (o1.getCantidadFavoritos() == o2.getCantidadFavoritos()) {
			return 0;
		} else if (o1.getCantidadFavoritos() < o2.getCantidadFavoritos()) {
			return 1;
		}
		return -1;
	}

	
}
