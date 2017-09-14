import java.io.*;
public  class FileCreator {
	public static void SaveURList(){
		System.out.println("Saving.."); 
		try(PrintWriter out = new PrintWriter("URLs.txt")){
			for(int i= 0;i<URLScanner.urls.size();i++){
				out.println(URLScanner.urls.get(i));
			}
			out.close();
		}
		catch(FileNotFoundException esc){
			System.out.println("could not create file :(");
		}
		System.out.println("Complete");
	}
}
