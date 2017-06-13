<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.main {
	width: 200px;
	border: 1px solid black;
}

.month {
	background-color: black;
	font: bold 12px verdana;
	color: white;
}

.daysofweek {
	background-color: gray;
	font: bold 12px verdana;
	color: white;
}

.days {
	font-size: 12px;
	font-family: verdana;
	color: black;
	background-color: lightyellow;
	padding: 2px;
}

.days #today {
	font-weight: bold;
	color: red;
}
.error
{
color:red;

}
</style>



</head>
<body>
	<center>
		<student:form action="addStudent.student" method="post"
			commandName="student">
			<table>
				<tr>
					<td>Your Id</td>
					<td><student:input path="studentId" /></td>
					<td><student:errors path="studentId" cssClass="error"></student:errors></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><student:input path="firstName" /></td>
					<td><student:errors path="firstName" cssClass="error"></student:errors></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><student:input path="lastName" /></td>
					<td><student:errors path="lastName" cssClass="error"></student:errors></td>
				</tr>
				<tr>
					<td>DOB (dd/mm/yyyy)</td>
					<td><student:input path="dateOfBirth" /></td>
					<td><student:errors path="dateOfBirth" cssClass="error"></student:errors></td>
				</tr>
				<tr>
					<td>department</td>
					<td><student:select path="department">
							<student:options items="${departments}"
								itemLabel="departmentName" itemValue="departmentId"></student:options>
						</student:select></td>
					<td></td>
				</tr>

				<tr>
					<td>Courses</td>
					<td><student:checkboxes element="li" path="courses"
							items="${courses}" itemLabel="courseName" itemValue="courseId" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><student:radiobutton path="gender" value="M" />Male <student:radiobutton
							path="gender" value="F" />Female</td>
					<td><student:errors path="gender" cssClass="error"></student:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Student"></td>
					<td><input type="reset" value="clear"></td>
				</tr>

			</table>
		</student:form>
	</center>
</body>
</html>