<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container" style="margin-top: 100px"
	style="position : absolute">

	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">


				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>
				</div>

				<div class="panel-body" style="margin-top: 30px">
					<!-- From Elements -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Please
								Enter Product Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Please
								Enter Brand Name: </label>

							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="description">
								Product Description : </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write description for product..."
									class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Please
								Enter Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price in &#8377;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">
								Quantity Available : </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder=" Quantity Available" class="form-control" />
							</div>
						</div>

						<!-- file element image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file"> Select
								an Image : </label>

							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">
								Select Category : </label>

							<div class="col-md-8">
								<sf:select path="categoryId" id="categoryId"
									class="form-control" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>

						<div class="form-group" class="text-right">
							<c:if test="${product.id==0}">
								<br />
								<button type="button" data-toggle="modal"
									data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
									Category</button>
							</c:if>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit"
									class="btn btn-primary" />

								<!-- hidden fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="supplierID" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<!-- add category dialog -->

	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add new Category</h4>
				</div>

				<div class="modal-body">

					<!-- catogory from -->
					<sf:form id="categoryForm"  modelAttribute="category"
						action="${contextRoot}/manage/category" mothod="POST"
						class="form-horizontal">

						<div class="form-group">

							<label for="category_name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8">
							<sf:input type="text" path="name" id="category_name" name="name" class="form-control"/>
							</div>
						</div>

						<div class="form-group">

							<label for="category_description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8">
								<sf:textarea cols="5" rows="5" path="description"
									id="category_description" name="description" class="form-control" />
							</div>
						</div>


						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="brn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

     
	<!-- admin product control -->

	<div class="row" style="margin-top: 50px">

		<div class="col-xs-12">

			<h3>Available Products</h3>
			<hr />

		</div>

		<div class="col-lg-12" style="margin-top: 30px">
			<div style="overflow: auto" style="margin-top: 50px">

				<!--  Product table for Admin -->

				<table id="adminProductsTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
							<th></th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>

						</tr>
					</tfoot>
				</table>

			</div>
		</div>
	</div>




</div>