package movies;
import java.util.*;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {
	
	public ArrayList<Movie> getSorted(){
		TreeSet movieTree = new TreeSet(this);
		return new ArrayList<>(movieTree);
	}
}
