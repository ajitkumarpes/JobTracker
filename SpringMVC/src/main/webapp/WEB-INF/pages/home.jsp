<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Item details using ajax</title>
<style type="text/css">
.formLayout {
	background-color: #f3f3f3;
	border: solid 1px #a1a1a1;
	padding: 10px;
	width: 300px;
}

.label {
	display: block; /* block float the labels to left column, set a width */
	float: left;
	width: 150px;
	padding: 0;
	margin: 5px 0 0;
	/* set top margin same as form input - textarea etc. elements */
	text-align: right;
}
</style>
<script src="/SpringMVC/src/main/java/com/target/common/js/jquery.js"></script>
<script type="text/javascript">
function doAjaxPost() {  
	  // get the form values  
	  var id = $('#id').val();	  
	   
	  $.ajax({  
	    type: "POST",  
	    url: "/itemCheck",  
	    data: "id=" + id,  
	    success: function(response){  
	      // we have the response  
	      $('#info').html(response);
	      alert('Error: ' );    
	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  
</script>
</head>
<body>
	<%-- <form:form action="itemCheck" method="get"> --%>
	<form:form method="post" commandName="itemForm">
   Enter Item Id:<input type="text" name="id">
		<br />

		<div align="center">
			<input type="submit" onclick="doAjaxPost()" value="Get Item Details">
		</div>
		<div id="info" style="color: green;"></div>

		<!--  <div id="details" style="display:none";> -->
		<div id="details">
			<table>
				<tr>
					<!--  <td colspan="2" align="center"><h2>Item fetch Succeeded!</h2></td> -->
				</tr>
				<tr>
					<td colspan="2" align="center">
						<h3>Thank you for accessing! Here's the review of your
							details:</h3>
					</td>
				</tr>
				<tr>
					<td>Part Number:</td>
					<td>${itemForm.itemDetails.partNumber}</td>
				</tr>
				<tr>
					<td>Map Price:</td>
					<td>${itemForm.itemDetails.mapPrice}</td>
				</tr>
				<tr>
					<td>PPU:</td>
					<td>${itemForm.itemDetails.ppu}</td>
				</tr>
				<tr>
					<td>SOI Flag:</td>
					<td>${itemForm.itemDetails.soiFlag}</td>
				</tr>
				<tr>
					<td>Map Price Flag:</td>
					<td>${itemForm.itemDetails.mapPriceFlag}</td>
				</tr>
				<tr>
					<td>Last Update:</td>
					<td>${itemForm.itemDetails.lastUpdate}</td>
				</tr>

			</table>
			<div class="formLayout">
				<!-- List Price -->
				<b style="margin-left: 30%">List Price</b>

				<div>
					<table>
						<tr>
						</tr>
						<tr>
							<td>Max Price:</td>
							<td>${itemForm.itemDetails.listPrice.maxPrice}</td>
						</tr>
						<tr>
							<td>Min Price:</td>
							<td>${itemForm.itemDetails.listPrice.minPrice}</td>
						</tr>
						<tr>
							<td>Price:</td>
							<td>${itemForm.itemDetails.listPrice.price}</td>
						</tr>
						<tr>
							<td>Formatted Price:</td>
							<td>${itemForm.itemDetails.listPrice.formattedPrice}</td>
						</tr>
						<tr>
							<td>Price Type:</td>
							<td>${itemForm.itemDetails.listPrice.priceType}</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- Offer Price -->
			<div class="formLayout">
				<b style="margin-left: 30%">Offer Price</b>

				<div>
					<table>
						<tr>
						</tr>
						<tr>
							<td>Max Price:</td>
							<td>${itemForm.itemDetails.offerPrice.maxPrice}</td>
						</tr>
						<tr>
							<td>Min Price:</td>
							<td>${itemForm.itemDetails.offerPrice.minPrice}</td>
						</tr>
						<tr>
							<td>Price:</td>
							<td>${itemForm.itemDetails.offerPrice.price}</td>
						</tr>
						<tr>
							<td>Formatted Price:</td>
							<td>${itemForm.itemDetails.offerPrice.formattedPrice}</td>
						</tr>
						<tr>
							<td>Price Type:</td>
							<td>${itemForm.itemDetails.offerPrice.priceType}</td>
						</tr>
					</table>
				</div>

			</div>

		</div>


	</form:form>
</body>
</html>