import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.*;
public class Main {
	
	public static void main(String[] args){
		System.out.println("What URL do you want to Scan ? (http://www.example.com)");
		Scanner sc = new Scanner(System.in);
		URLScanner.startURL = sc.nextLine();
		System.out.println("How many Sub-Links do you want to scan ?");
		URLScanner.maxURLsScanned = Integer.parseInt(sc.nextLine());
		URLScanner.Scan();
		System.out.println(URLScanner.urls.size()+ " Links have been found");
		for(int i = 0;i <URLScanner.urls.size();i++){
				System.out.println(URLScanner.urls.get(i).toString());
		}
	}
}
