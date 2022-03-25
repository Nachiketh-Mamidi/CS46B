package dotLab;

import java.io.*;


public class DotReader 
{
	private BufferedReader			br;
	
	public DotReader(BufferedReader br)
	{
		this.br = br;
	}
	
	public Dot readDot() throws IOException, DotException{
		String[] arr = null;
		String stri = br.readLine();
		System.out.println(stri);
		
		if (stri != null) {
			arr = stri.split(",");
		}
		else
		{
			return null;
		}
		

		if(arr.length !=4) {
			DotException de = new DotException("Not size 4");
			throw de;
		}
		
		Dot t = new Dot(arr[0], Integer.parseInt(arr[1]),Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
		return t;
	}
	
}
