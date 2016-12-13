var category = (function() {
    var categoryList = null;
    var timeoutSet = false;

    function categoryNameFromId(id) {
        if(categoryList === null) {
            if(timeoutSet !== true) {
                timeoutSet = true;
                setTimeout(3000, function(id) {
                    return categoryNameFromId(id);
                });
            }
        } else {
            for(var i in categoryList) {
                if (categoryList[i].categoryId === id) {
                    return categoryList[i].categoryName;
                }
            }
        }
    }

    function _initializeCategories() {
        var url = '/FastrSale/category/api',
    		args = {},
    		callback = function(resp) {
    			categoryList = resp;
    		};
    	$.get(url, args, callback);
    }

    function init() {
        _initializeCategories();
    }

    return {
        init: init,
        categoryNameFromId: categoryNameFromId
    };

})();

category.init();
