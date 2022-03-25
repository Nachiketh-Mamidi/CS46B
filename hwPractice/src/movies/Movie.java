package movies;

public class Movie implements Comparable<Movie> {
	private String title;
	private int year;
	
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	public int compareTo(Movie that){
		if (this.title.compareTo(that.title) == 0) {
			return Integer.compare(this.year, that.year);
		} else {
			return this.title.compareTo(that.title);
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean equals(Object o) {
		// to override equals method from object.java
		Movie m = (Movie) o;
		return (this.compareTo(m) == 0);
	}
	
	public String toString() {
		return "Movie " + title + " (" + year + ")";
	}
	
	public static Movie[] getTestMovies() {
		Movie[] test = new Movie[10];
		test[0] = new Movie("Test 0", 2000);
		test[1] = new Movie("Test 0", 2001);
		
		test[2] = new Movie("Test 2", 2002);
		test[3] = new Movie("Test 3", 2002);
		
		test[4] = new Movie("Test 4", 2003);
		test[5] = new Movie("Test 4", 2003);
		test[6] = new Movie("Test 6", 2010);
		test[7] = new Movie("Test 7", 2011);
		test[8] = new Movie("Test 8", 2012);
		test[9] = new Movie("Test 9", 2013);
		
		return test;
	}
	
	public int hashCode() {
		return title.hashCode() + year;
	}
	
	
}
