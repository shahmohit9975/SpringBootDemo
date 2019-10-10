<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>



		 <br /> <br />
			 name:<input type="text" id="name" /> <br /> <br /> 
			designation:<input type="text" id="designation" /> <br /> <br /> 
			expertise:<input type="text" id="expertise" /> <br /> <br /> 
			createdAt:<input type="date" id="createdAt"> <br /> <br /> 
			<input type="submit" name="submit">
<div id="displayDiv" style="display:none"><h3>JSON Data returned from Server after processing</h3>
		<div id="processedData"></div>
	</div>
	<script>
	jQuery(document).ready(function($) {
 	alert("hello");
		$("#submit").click(function(){
			var employeeData = {};
			employeeData["name"] = $("#name").val();
			employeeData["designation"] = $("#designation").val();
			employeeData["expertise"] = $("#expertise").val();
			employeeData["createdAt"] = $("#createdAt").val();

			
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "employees",
				data : JSON.stringify(employeeData),
				dataType : 'json'				
				success : function(data) {
					$('#processedData').html(JSON.stringify(data));
					$('#displayDiv').show();
				}
			});
		});
 
	});
</script>
</body>
</html>