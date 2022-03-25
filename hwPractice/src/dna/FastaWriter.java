package dna;

import java.io.*;


//
// Writes a fasta record to a print writer.
//



public class FastaWriter 
{
	
	private PrintWriter writer;

	public FastaWriter(PrintWriter pw)
	{
		writer = pw;
	}
	
	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// To write something on a separate line, use the println() method of PrintWriter.
	public void writeRecord(FastaRecord rec) throws IOException
	{
		this.writer.println(rec.getDefline());
		this.writer.println(rec.getSequence());

	}
}
