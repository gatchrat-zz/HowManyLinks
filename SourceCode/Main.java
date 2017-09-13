import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.*;
public class Main {
	
	public static void main(String[] args){
		Scanner.startURL = "http://www.zombfort.de/";
		Scanner.maxURLsScanned = 50;
		Scanner.Scan();
		System.out.println(Scanner.urls.size()+ " Links have been found");
		for(int i = 0;i <Scanner.urls.size();i++){
				System.out.println(Scanner.urls.get(i).toString());
		}
	}
}
