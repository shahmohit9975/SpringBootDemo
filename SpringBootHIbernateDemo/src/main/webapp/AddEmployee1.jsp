<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
 

</head>
<body>
<h1>employee</h1>
<br>
<br>
<br>
<%-- <form action="/employees" method="post"> --%>

<br>
<br>
		 <br /> <br />
			 name:<input type="text" id="emp_name" /> <br /> <br /> 
			designation:<input type="text" id="designation" /> <br /> <br /> 
			expertise:<input type="text" id="expertise" /> <br /> <br /> 
			createdAt:<input type="date" id="createdAt"> <br /> <br /> 
			<input type="submit" id="submit">
			
			<script>
			
		
			$('#submit').click(function(event) {        
			
			    var name = $('#emp_name').val();
			    var designation = $('#designation').val();
			    var expertise = $('#expertise').val();
			    var createdAt = $('#createdAt').val();
			    var json = { "emp_name" : name, "designation" : designation, "expertise": expertise,"createdAt": createdAt};
			    $.ajax({
			        url: 'employees',
			        data: JSON.stringify(json),
			        type: "POST",           
			        beforeSend: function(xhr) {
			            xhr.setRequestHeader("Accept", "application/json");
			            xhr.setRequestHeader("Content-Type", "application/json");
			        }
			    	,
			        success: function(response){ 
			        	window.location = '/success.jsp';
			        }
			    });

			    event.preventDefault();
});

			</script>
<%-- </form> --%>
</body>
</html>