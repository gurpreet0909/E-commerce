<div class="container">
	<div class="row">

		<!-- To display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual producrts -->
		<div class="col-md-9">
			<!-- added breadcrump componant -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">&nbsp/ All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">&nbsp/ Category /&nbsp</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>

							<tr>
								<th></th>
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>QTY. Available</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>

							<tr>
								<th></th>
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>QTY. Available</th>
								<th></th>
							</tr>
						</tfoot>

					</table>
				</div>
			</div>
		</div>
	</div>
</div>