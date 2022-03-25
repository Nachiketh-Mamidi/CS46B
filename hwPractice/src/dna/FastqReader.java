package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	private BufferedReader   theBufferedReader;

	
	public FastqReader(BufferedReader br)
	{
		theBufferedReader = br;
	}
	
	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String defline = this.theBufferedReader.readLine();
		if (defline == null) {
			return null;
		}
		
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		String sequence = this.theBufferedReader.readLine();
		this.theBufferedReader.readLine();
		String quality = this.theBufferedReader.readLine();
		return new FastqRecord(defline, sequence, quality);
		
	}
}
