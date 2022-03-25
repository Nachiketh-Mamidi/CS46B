package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {
	public ArrayList<Movie> getSorted(){
		ArrayList<Movie> result = new ArrayList<Movie>(this);
		return result;
		
	}
	
	public static void main (String[] args){
		// step 1
		TreeFilmArchive archive = new TreeFilmArchive();
		// step 2
		for(Movie m : Movie.getTestMovies()) {
			archive.add(m);
		}
		//step 3
		System.out.println("before getSorted()");
		for(Movie m : archive) {
			System.out.println(m);
		}
		System.out.println("");
		System.out.println("after getSorted()");
		for(Movie m : archive.getSorted()) {
			System.out.println(m);
		}
	}
}
