<jsp:include page="/views/includes/header.jsp"></jsp:include>

<div id="inventory" class="container">
	<table id="inventory_table" class="table table-hover">
        <thead>
            <tr>
                <th>Image</th>
                <th>ID #</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Store ID</th>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Remove Product</th>
            </tr>
        </thead>
        <tbody id="inventory_table"></tbody>
    </table>
</div>

		<!-- JavaScript CDNs -->
        <!-- jQuery CDN -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> -->
        <script src="./lib/jquery-3.1.1.min.js"></script>
        <!-- Bootstrap JS CDN -->
        <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->
        <script src="./lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
        <!-- Category JS -->
        <script src="./js/category.js"></script>
        <!-- Inventory JS -->
        <script src="./js/inventory.js"></script>
	</body>
</html>
