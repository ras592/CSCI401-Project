<jsp:include page="/views/includes/header.jsp" />
        <div class="container">
        	<form action="/FastrSale/login" method="POST" class="form-horizontal">
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
					<input type="password" class="form-control" id="password" name="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-1">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
        </div>
<jsp:include page="/views/includes/footer.jsp" />