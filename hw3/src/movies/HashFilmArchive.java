package movies;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {
	
	public ArrayList<Movie> getSorted(){
		Set<Movie> treeSort = new TreeSet<Movie>(this); //ArrayList to HashSet
		ArrayList<Movie> sortedList = new ArrayList<Movie>(treeSort); //TreeSet to sorted ArrayList
		return sortedList;
	}

	
	public static void main (String[] args){
		// step 1
		HashFilmArchive archive = new HashFilmArchive();
		// step 2
		for(Movie m : Movie.getTestMovies()) {
			archive.add(m);
		}
		//step 3
		System.out.println("Before getSorted()");
		for(Movie m : archive) {
			System.out.println(m);
		}
		
		System.out.println("");
		System.out.println("After getSorted()");
		archive.getSorted();
		for(Movie m : archive.getSorted()) {
			System.out.println(m);
		}
		
		 
		
	}
}
