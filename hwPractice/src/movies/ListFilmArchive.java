package movies;

import java.util.*;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {
	@Override
	public boolean add(Movie m) {
		for (Movie a : this) {
			if (a.equals(m)) {
				return false;
			}
		}
		return super.add(m);
	}
	
	public ArrayList<Movie> getSorted(){
		TreeSet movieTree = new TreeSet(this);
		return new ArrayList<>(movieTree);
	}
}
