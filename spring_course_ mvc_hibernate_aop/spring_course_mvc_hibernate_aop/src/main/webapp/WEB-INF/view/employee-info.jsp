<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Employee Info</h2>
<br><br>
<form:form action="saveEmployee" modelAttribute="employee ">
<%--   создаем скрытую форму --%>
    <form:hidden path="id"/>
    
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="Ok"/>
</form:form>

</body>
</html>