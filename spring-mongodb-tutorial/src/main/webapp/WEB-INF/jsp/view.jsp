<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<html>
<head>
<link rel='stylesheet' type='text/css' media='screen'
	href='<c:url value="/resources/css/style.css"/>' />
<script type='text/javascript'
	src='<c:url value="/resources/js/jquery-1.6.4.min.js"/>'></script>
<script type='text/javascript'
	src='<c:url value="/resources/js/custom.js"/>'></script>

<title>User Records</title>

<script type='text/javascript'>
	function loadTable() {
		$.get("view/records", function(response) {
	 		$('#tableUsers').find('tbody').remove();
	 		
	 		 for (var i=0; i<response.graph.length; i++) {
				var row = '<tr>';
				row += '<td><input type="radio" name="index" id="index" value="'+i+'"></td>';
				row += '<td>' + response.graph[i].id + '</td>';
				row += '<td>' + response.graph[i].task + '</td>';
				row += '<td>' + response.graph[i].prodF + '</td>';
				
				row += '</tr>';
		 		$('#tableUsers').append(row);
	 		}
	 	});
	}
	
/* 	$(function() {
			
		$('#clickbtn').on("click",function() { 
			alert("clicked button");
			loadTable();
		});
	}); */
	</script>
</head>

<body>
	<h1 id='banner'>P-Graph table <input type='button' value='click here' id='clickbtn' onclick="loadTable()"/></h1>
	<hr />

	<table id='tableUsers'>
		<caption></caption>
		<thead>
			<tr>
				<th></th>
				<th>User</th>
				<th>Task</th>
				<th>Productivity factor</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>