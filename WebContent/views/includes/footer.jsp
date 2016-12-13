		<div class="container">
		    <div class="row">
		        <div class="col-lg-12">
		            <ul class="nav nav-pills nav-justified">
		                <li><a href="#">© 2016 FastrSale.</a></li>
		                <li><a href="#">Terms of Service</a></li>
		                <li><a href="#">Privacy</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
		
		<!-- JavaScript CDNs -->
        <!-- jQuery CDN -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> -->
        <script src="./lib/jquery-3.1.1.min.js"></script>
        <!-- Bootstrap JS CDN -->
        <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->
        <script src="./lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
        <!-- Products JS -->
        <script src="./js/products.js"></script>
        <script>
        if(initProductsObj !== undefined) {
        	if (initProductsObj.init) {
        		products.init(initProductsObj.param);
        	}
        }
        </script>
	</body>
</html>