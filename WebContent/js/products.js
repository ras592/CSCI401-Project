var products = (function() {
	/**
	 *
	 *
	 */
    var $products = $('#products');
    var $add_to_cart = $('form.add_to_cart');
    var $button_add_to_cart = $('button.add_to_cart');

    $products.delegate('button.add_to_cart', 'click', _addToCart);

    function _addToCart(e) {
        e.preventDefault();
        $this = $(this);
        if(!$this.hasClass('disabled')) {
            console.log($this.attr('data-value'));
        }
    }

    function _toProductHTML(productObj) {
        return ['<div class="col-sm-6 col-md-4 product">',
	        '<div class="thumbnail">',
	          '<img src="/FastrSale/img/products/' + _toImageURL(productObj.productImageURLs) + '" alt="product image" class="product thumbnail">',
	          '<div class="caption">',
	            '<h3>' + productObj.productName + '</h3>',
	            '<p>' + productObj.description + '</p>',
	            '<p>',
                    _toBuyButtonHTML(productObj),
                '</p>',
	          '</div>',
	        '</div>',
	      '</div>'].join('');
    }

    function _toBuyButtonHTML(productObj) {
        var buy_html = '<span class="error">Error</span>';
        if (productObj.quantity > 0) {
            buy_html = [
                '<form class="form-inline add_to_cart">',
    		          '<div class="form-group">',
                        '<label class="sr-only">Price</label>',
                        '<p class="form-control-static">$' + productObj.price + '</p>',
                      '</div>',
    		          '<button type="submit" data-value="' + productObj.productId + '" class="btn btn-default add_to_cart">Add To Cart</button>',
    		    '</form>'].join('');
        } else {
            buy_html = [
                '<form class="form-inline add_to_cart">',
                      '<div class="form-group">',
                        '<label class="sr-only">Price</label>',
                        '<p class="form-control-static">$' + productObj.price + '</p>',
                      '</div>',
                      '<button type="submit" data-value="' + productObj.productId + '" class="btn btn-default disabled add_to_cart">Add To Cart</button>',
                '</form>'].join('');
        }
        return buy_html;
    }

    function _toImageURL(urls) {
        var urls = urls.split('|');
    	if(urls.length <= 0) {
    		return 'https://placeholdit.imgix.net/~text?txtsize=33&txt=no%20image&w=330&h=330';
    	} else {
    		return urls[0];
    	}
    }

    function _requestProducts() {
    	var url = '/FastrSale/products/api',
    		args = {},
    		callback = function(resp) {
    			_renderProducts(resp);
    		};
    	$.get(url, args, callback);
    }

    function _renderProducts(products) {
        $products.html('');
        var row_index = 0;
        var rows = [$('<div class="row">')];
        for(var product in products) {
            if (product % 3 === 0 && product != 0) { // product is actually a string, weird
                rows.push($('<div class="row">'));
                row_index++;
            }
            rows[row_index].append(_toProductHTML(products[product]));
        }
        for(var row in rows) {
            $products.append(rows[row]);
        }
    }

    function init() {
        _requestProducts();
    }

    return {
        init: init
    };
})();

products.init();
