package lab5;
import java.io.File;

public class Lister {
	File file;
	boolean showHidden;
	
	Lister(File file, boolean showHidden){
		this.file = file;
		this.showHidden = showHidden;
	}
	
	public void list() {
		listRecurse(file, "");
	}
	
	private void listRecurse(File file, String indent) {
		System.out.println(indent + file.getName() + ":");
		File[] flist = file.listFiles();
		for (File f : flist) {
			if(!f.isHidden() && showHidden == false) {
				if (f.isDirectory()) {
					listRecurse(f, indent+ "  ");
				} else {
					System.out.println(indent + f.getName());
				}
				
			}
		}
	}
	
	public static void main (String[] args) {
		
		File dir = new File("/Users/nachiketh/Documents/SJSU Fall 2021/CS 46B/hw");
		Lister listr = new Lister(dir, false);
		listr.list();
		
	}
}

