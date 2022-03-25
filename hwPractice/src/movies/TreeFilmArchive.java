package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

	public ArrayList<Movie> getSorted(){
		return new ArrayList<>(this);
	}
}
