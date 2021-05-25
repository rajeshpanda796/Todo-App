<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Add Todo page for ${name}</h1>
	<form:form method="post" modelAttribute="todo">
		<form:hidden path="id" />
		<div class="row">
			<div class="col-md-7">
				<!--<label>Description : </label>-->
				<form:label path="desc">Description : </form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-warning"></form:errors>
			</div>
			<div class="offset-1 col-md-4">
				<form:label path="targetDate">Target Date : </form:label>
				<form:input path="targetDate" type="text" placeholder="dd/mm/yyyy"
					class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			</div>
		</div>
		<br>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>