<jsp:include page="/views/includes/header.jsp" />
<div class="container">
	<form action="/FastrSale/store_registration" method="POST"
		class="form-horizontal">
		<div class="form-group">
			<label for="store_name" class="col-sm-2 control-label">Store
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="store_name"
					name="store_name" placeholder="Store Name">
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="example@email.com">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<label for="confirm_password" class="col-sm-2 control-label">Confirm
				Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="confirm_password"
					name="confirm_password" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<label for="first_name" class="col-sm-2 control-label">First
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="first_name"
					name="first_name" placeholder="First">
			</div>
		</div>
		<div class="form-group">
			<label for="last_name" class="col-sm-2 control-label">Last
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="last_name"
					name="last_name" placeholder="Last">
			</div>
		</div>
		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">Address</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="address" name="address"
					placeholder="Address">
			</div>
		</div>
		<div class="form-group">
			<label for="city" class="col-sm-2 control-label">City</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="city" name="city"
					placeholder="City">
			</div>
		</div>
		<div class="form-group">
			<label for="state" class="col-sm-2 control-label">State</label>
			<div class="col-sm-10">
				<select class="form-control" id="state" name="state">
					<% 
					  	String[] states = {
							  "AL","AK","AZ","AR","CA","CO","CT","DE","DC","FL","GA","HI","ID","IL",
							  "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
							  "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR",
							  "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
					  	for (int i = 0; i < states.length; i++) {
					  %>
					<option><%= states[i] %></option>
					<% } %>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="zip" class="col-sm-2 control-label">Zip Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="zip" name="zip"
					placeholder="Zip Code">
			</div>
		</div>
		<div class="form-group">
			<label for="country" class="col-sm-2 control-label">Country</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="country">United States</p>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign Up</button>
			</div>
		</div>
	</form>
</div>
<jsp:include page="/views/includes/footer.jsp" />
