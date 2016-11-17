package store.utility;

import java.net.URI;
import java.net.URISyntaxException;

public class RoutingUtility {
	public static String getId(String url) {
		try {
			URI uri = new URI(url);
			String path = uri.getPath();
			return path.substring(path.lastIndexOf('/') + 1);
		} catch (URISyntaxException ex) {
			return "";
		}
	}
	
	public static String getPathWithoutId(String url) {
		try {
			URI uri = new URI(url);
			String path = uri.getPath();
			return path.substring(0, path.lastIndexOf('/'));
		} catch (URISyntaxException ex) {
			return "";
		}
	}
}
