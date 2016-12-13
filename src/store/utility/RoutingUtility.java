package store.utility;

import java.net.URI;
import java.net.URISyntaxException;
import store.business.Product;

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
	
	public static String toBuyButton(Product product) {
		String retVal = "";
		if(product.getQuantity() > 0) {
			retVal = "<form class=\"form-inline add_to_cart\"><div class=\"form-group\">"
					+ "<label class=\"sr-only\">Price</label>"
					+ "<p class=\"form-control-static\">$" + product.getPrice() + "</p>"
					+ "</div><button type=\"submit\" data-value=\"" + product.getProductId() + "\" "
					+ "class=\"btn btn-default add_to_cart\">Add To Cart</button></form>";
		} else {
			retVal = "<form class=\"form-inline add_to_cart\"><div class=\"form-group\">"
					+ "<label class=\"sr-only\">Price</label>"
					+ "<p class=\"form-control-static\">$" + product.getPrice() + "</p>"
					+ "</div><button type=\"submit\" data-value=\"" + product.getProductId() + "\" "
					+ "class=\"btn btn-default disabled add_to_cart\">Out of Stock</button></form>";
		}
		return retVal;
	}
	
	public static String toImageURL(String urls) {
        String[] urlArray = urls.split("\\|");
    	if(urlArray.length <= 0) {
    		return "https://placeholdit.imgix.net/~text?txtsize=33&txt=no%20image&w=330&h=330";
    	} else {
    		if(urlArray[0].indexOf("uploads") != -1) {
    			return "/FastrSale/files" + urlArray[0];
    		} else {
    			return "/FastrSale/img/products/" + urlArray[0];
    		}
    	}
    }
}

