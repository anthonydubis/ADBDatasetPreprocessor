import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class Preprocessor {
	public static void processRestaurantData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("restaurant-raw.csv")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("restaurant10000.csv", true)));
		String line = null;
		int i = 0;
		
		while ((line = br.readLine()) != null && i++ < 10000) {
			String[] split = line.split(",");
			
			/* Trim trailing and lead white space */
			for (int k = 0; k < split.length; k++)
				split[k] = split[k].trim();
			
			/* Sort the array */
			Arrays.sort(split);
			
			for (int k = 0; k < split.length; k++) {
				if (split[k].equals(""))
					continue;
				
				out.print(split[k]);
				if (k < split.length-1)
					out.print(",");
				else
					out.println();
			}
		}
		
		out.close();
		br.close();
		
		System.out.println("Done with restaurant data");
	}
	
	public static void processNameData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("babynames-raw.csv")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("babynames.csv", true)));
		String line = null;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String[] split = line.split(",");
			
			for (int k = 0; k < split.length; k++)
				split[k] = split[k].trim();
			
			Arrays.sort(split);
			
			for (int k = 0; k < Integer.parseInt(split[0]); k++) {
				for (int j = 1; j < split.length; j++) {
					out.print(split[j]);
					if (j < split.length-1)
						out.print(",");
					else
						out.println();
				}
			}
		}
		
		out.close();
		br.close();
		
		System.out.println("Done with baby data");
	}
	
	public static void processDeathData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Death.csv")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("death-processed.csv", true)));
		String line = null;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			String[] split = line.split(",");
			
			for (int k = 0; k < split.length; k++)
				split[k] = split[k].trim();
			
			Arrays.sort(split);
			
			for (int k = 0; k < Integer.parseInt(split[0]); k++) {
				for (int j = 1; j < split.length; j++) {
					out.print(split[j]);
					if (j < split.length-1)
						out.print(",");
					else
						out.println();
				}
			}
		}
		
		out.close();
		br.close();
		
		System.out.println("Done with death data");
	}

	public static void main(String[] args) throws IOException {
		// processRestaurantData();
		// processNameData();
		processDeathData();
	}
}
