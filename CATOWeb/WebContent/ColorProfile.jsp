<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Position Define</title>
</head>
<body>
	<form id="defineform" method="post" name="defineform" action="DefineColorProfile">
		<table>
			<tbody>
				<tr>
					<td>Select Color Profile</td>
					<td><select name="colorprofile">
						<option selected value="p1">Profile1</option>
						<option value="p2">Profile2</option>
					</select>
					</td>
					
				</tr>
			</tbody>
		</table>
		<button type="submit" name="Submit" value="Submit" id="Submit">Submit</button>
	</form>
</body>
</html>