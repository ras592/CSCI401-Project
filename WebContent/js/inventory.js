var inventory = (function() {
	/**
	 *
	 *
	 */
    var $inventory = $('#inventory');
    var $inventory_table = $('table#inventory_table');
    var $inventory_table_body = $('tbody#inventory_table');

    $inventory_table_body.delegate('a.remove_product', 'click', _removeProduct);

    function _removeProduct(e) {
        e.preventDefault();
        $this = $(this);
        if(!$this.hasClass('disabled')) {
            var url = '/FastrSale/products/api',
                args = {
                    "id": $this.attr('data-value')
                },
        		callback = function(resp) {
                    console.log("res");
                    console.log(resp);
                    _requestProducts();
        		};
        	$.get(url, args, callback);
        }
    }

    function _toRow(item) {
        return [
            '<tr>',
            '<td>' + '<img src="' + _toImageURL(item.productImageURLs) + '" alt="product image" class="inventory thumbnail">' + '</td>',
            '<td>' + item.productId + '</td>',
            '<td>' + item.productName + '</td>',
            '<td class="description">' + item.description + '</td>',
            '<td>$' + item.price + '</td>',
            '<td>' + item.quantity + '</td>',
            '<td>' + item.storeId + '</td>',
            '<td>' + item.categoryId + '</td>',
            '<td>' + category.categoryNameFromId(item.categoryId) + '</td>',
            '<td><a class="remove_product" href="/FastrSale/product_api" data-value="' + item.productId + '">Remove</a></td></tr>',
        ].join('');
    }

    function _appendItem(item) {
        $inventory_table_body.append(_toRow(item));
    }

    function _toImageURL(urls) {
        var urls = urls.split('|');
    	if(urls.length <= 0) {
    		return 'https://placeholdit.imgix.net/~text?txtsize=33&txt=no%20image&w=330&h=330';
    	} else {
    		if(urls[0].indexOf('uploads') !== -1) {
    			return '/FastrSale/files' + urls[0];
    		} else {
    			return '/FastrSale/img/products/' + urls[0];
    		}
    	}
    }

    function _requestProducts() {
    	var url = '/FastrSale/products/api',
    		args = {
                "store": true
            },
    		callback = function(resp) {
    			_renderProductsTable(resp);
    		};
    	$.get(url, args, callback);
    }

    function _renderProductsTable(products) {
        $inventory_table_body.html('');
        for(var product in products) {
            _appendItem(products[product]);
        }
    }

    function init() {
        _requestProducts();
    }

    return {
        init: init
    };
})();

inventory.init();
