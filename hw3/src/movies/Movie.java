package movies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Movie implements Comparable<Movie>  {
	private String title;
	private int year;
	
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	public int compareTo(Movie that){
		int titleCmp = this.title.compareTo(that.title); //title comparison
		if (titleCmp != 0){
			return titleCmp;
		}
		return this.year - that.year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean equals(Object x){
		Movie that = (Movie)x;
		return this.compareTo(that) == 0;
	}
	
	public String toString() {
		return "Movie " + title + "(" + year + ")";
	}
	
	public static Movie[] getTestMovies() {
		Movie[] movies = new Movie[10];
		movies[0] = new Movie("Superman", 1978);
		movies[1] = new Movie("Superman", 2013);
		movies[2] = new Movie("Ironman 1", 2008);
		movies[3] = new Movie("Hulk", 2008);
		movies[4] = new Movie("Batman", 2010);
		movies[5] = new Movie("Batman", 2010);
		movies[6] = new Movie("Joker", 2019);
		movies[7] = new Movie("Thor", 2011);
		movies[8] = new Movie("Black Panther", 2018);
		movies[9] = new Movie("Dark Knight", 2008);
		return movies;
	}
	
	public int hashCode()
	{
		return this.title.hashCode() + year;
      }

	public static void main (String[] args) {
		Map<Movie, Integer> hashMovies = new HashMap<>();
		for (int i = 0; i < getTestMovies().length; i ++) {
			hashMovies.put(getTestMovies()[i], i * 100000);
		}
		
		Map<Movie, Integer> treeMovies = new TreeMap<>();
		for (int i = 0; i < getTestMovies().length; i ++) {
			treeMovies.put(getTestMovies()[i], i * 100000);
		}
		
		for (Movie m : hashMovies.keySet()) {
			System.out.println(m + " made " + hashMovies.get(m));
		}
		
		System.out.println("____________________");
		
		for (Movie m : treeMovies.keySet()) {
			System.out.println(m + " made " + treeMovies.get(m));
		}
	}
}
