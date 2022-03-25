package movies;
import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive  {
	
	public boolean add(Movie m) {
		for (Movie a : this){
			if (a.equals(m)) {
				return false;
			}
		}
		super.add(m);
		return true;
	}
	
	public ArrayList<Movie> getSorted(){
		TreeSet<Movie> sortTree = new TreeSet<Movie>(this);
		ArrayList<Movie> result = new ArrayList<Movie>(sortTree);
		return result;
	}
	
	public static void main (String[] args){
		// step 1
		ListFilmArchive archive = new ListFilmArchive();
		// step 2
		for(Movie m : Movie.getTestMovies()) {
			archive.add(m);
		}
		//step 3
		System.out.println("Before getSorted()");
		for(Movie m : archive) {
			System.out.println(m);
		}
		// step 4
		System.out.println("");
		System.out.println("After getSorted()");
		for(Movie m : archive.getSorted()) {
			System.out.println(m);
		}
	}
}
