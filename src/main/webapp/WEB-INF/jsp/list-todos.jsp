
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Your Todos</h1>
		<table class="table table-striped text-center">
			<caption>Your todos are</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Descripation</th>
					<th scope="col">Target Date</th>
					<th scope="col">Is it Done?</th>
					<th scope="col" colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-primary"
							href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-danger"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a type="button" class="btn btn-success" href="/add-todo">Add a
				Todo</a>
		</p>
	</div>

	<%@ include file="common/footer.jspf"%>