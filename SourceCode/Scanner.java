import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.*;
public class Scanner {
	static Document dok;
	static List urls;
	/**
	 * The Url to start the Search from
	 * I.E http://www.zombfort.de/ 
	 */
	public static String startURL; 
	public static int maxTime;
	public static int maxURLsScanned;
	public static void main(String[] args){
		
		
	}
	public static void Scan(){
		urls = new LinkedList();
		//get links from start URL
		fetchDoc(startURL);
		extractLinks(dok);
		//get links from each of the extracted URL
		for(int i = 0;i<maxURLsScanned;i++){
		
			fetchDoc("https://"+urls.get(i).toString());
			extractLinks(dok);
			if(i==urls.size()-1){
				i=99;
			}
		}
		
	}

	/**
	 * Extracts links from a Website
	 * @param doc The Website
	 */
	public static void extractLinks(Document doc){
		Elements links = doc.select("a[href]");
		for(int i =0;i<links.size();i++){
			if(!urls.contains((links.get(i).attr("abs:href").toString()))&&getBaseDomain(links.get(i).attr("abs:href").toString())!=null){
				urls.add((links.get(i).attr("abs:href").toString()));
			}
				
		}
		
		
	}
	public static void fetchDoc(String url){
		
		if(url.length()<10){
			System.out.println("search not possible");
			return;
		}
		System.out.println("searching in:"+url);
		try{
			dok = Jsoup.connect(url).get();
		}
		catch(IOException execption){
			
		}
		
	}
	
	public static String getHost(String url){
	    if(url == null || url.length() == 0)
	        return "";

	    int doubleslash = url.indexOf("//");
	    if(doubleslash == -1)
	        doubleslash = 0;
	    else
	        doubleslash += 2;

	    int end = url.indexOf('/', doubleslash);
	    end = end >= 0 ? end : url.length();

	    int port = url.indexOf(':', doubleslash);
	    end = (port > 0 && port < end) ? port : end;

	    return url.substring(doubleslash, end);
	}


	
	public static String getBaseDomain(String url) {
	    String host = getHost(url);

	    int startIndex = 0;
	    int nextIndex = host.indexOf('.');
	    int lastIndex = host.lastIndexOf('.');
	    while (nextIndex < lastIndex) {
	        startIndex = nextIndex + 1;
	        nextIndex = host.indexOf('.', startIndex);
	    }
	    if (startIndex > 0) {
	        return host.substring(startIndex);
	    } else {
	        return host;
	    }
	}
}
