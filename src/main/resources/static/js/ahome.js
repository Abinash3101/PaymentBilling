var request;
	function sendInfo() {
		if(null != document.getElementById('messageDiv')){
			document.getElementById('messageDiv').style.visibility = 'hidden';
		}
		var branch = document.myform.select.value;
		var v = document.myform.findName.value;
		var url = "afindname?val=" + v + "&branch=" + branch;
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		if (request.readyState == 4) {
			var val = JSON.parse(request.responseText);
			console.log(val.length)
			//document.getElementById('location').innerHTML = val;
			var html = "<table border='5|5'>";
			html+="<tr>";
	        html+="<td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>Name</B></td><td><B>Salary</B></td>";
	        html+="</tr>";
		    for (var i = 0; i < val.length; i++) {
		        html+="<tr>";
		        html+="<td>"+"<a href='#' name='"+val[i].id+"' onclick='javascript:viewAll(this.name)'>"+val[i].id+"</a>"+"</td>";
		        html+="<td>"+val[i].username+"</td>";
		        html+="<td>"+val[i].salary+"</td>";
		        
		        html+="</tr>";

		    }
		    html+="</table>";
		    document.getElementById('location').innerHTML = html;
		}
	}

	function viewAll(name) {
		var v = name;
		var url = "aviewall?val=" + v;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = getAllInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	function getAllInfo() {
		if (request.readyState == 4) {
			var val = JSON.parse(request.responseText);
			console.log(val);
			var html = "<br/>"+"<table border='5|5' style='width: 300px; white-space: nowrap; overflow: hidden; text-overflow:ellipsis;'>";
			html+="<tr>";
	        html+="<td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>User name</B></td><td><B>Password</B></td><td><B>Date of joining</B></td><td><B>Date of Birth</B></td><td><B>Salary</B></td><td><B>Remove</B></td>";
	        html+="</tr>";
		   // for (var i = 0; i < val.length; i++) {
		        html+="<tr>";
		        html+="<td>"+"<a href='#' name='"+val.id+"' onclick='javascript:editAccountant(this.name)'>"+val.id+"</a>"+"</td>";
		        html+="<td>"+val.username+"</td>";
		        html+="<td>"+val.userpass+"</td>";
		        html+="<td>"+val.dateOfJoining+"</td>";
		        html+="<td>"+val.dateOfBirth+"</td>";
		        html+="<td>"+val.salary+"</td>";
		        html+="<td>"+"<a href='#' name='"+val.id+"' onclick='javascript:deleteAccountant(this.name)'>"+'Delete'+"</a>"+"</td>";
		        
		        html+="</tr>";

		   // }
		    html+="</table>";
			document.getElementById('bottom').innerHTML = html;
		}
	}
	
	function editAccountant(name) {
		document.location.href ='editAccountant?id='+name;
	}
	
	function deleteAccountant(name) {
		var v = name;
		var url = "adelete?val=" + v;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = getDeleteStatus;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function getDeleteStatus() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById('bottom').innerHTML = val;
			sendInfo();
		}
	}