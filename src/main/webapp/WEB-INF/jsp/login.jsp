
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="col-md-10 offset-md-1">
		<h1 class="display-3 text-center">Log In</h1>
		<form class="form-conatiner" method="post">
			<div class="form-row">
				<div class="col ">
					<input type="text" class="form-control" placeholder="User Name"
						name="name">
				</div>
				<div class="col">
					<input type="password" class="form-control" placeholder="Password"
						name="password">
				</div>
			</div>
			<br>
			<p style="color: red">User Name: rajesh, Password: rajesh123</p>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
		<p style="color: red">${errorMessage}</p>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
