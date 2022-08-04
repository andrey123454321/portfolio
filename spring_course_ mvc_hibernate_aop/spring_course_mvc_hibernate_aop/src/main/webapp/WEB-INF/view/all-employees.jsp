<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!Doctype html>
<html>
<body>
<h2>All Employees</h2>
<br>

<table>
<%-- <tr> - тег означающий - строка таблицы--%>
    <tr>
<%--    <th> - шапка таблицы    --%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operation</th>
<%-- первая строка окончена --%>
    </tr>
<%-- var - временная переменная  ="emp" - название --%>
    <c:forEach var="emp" items="${allEmps}" >
<%-- <c:url - ссылка связанная со значение переменной --%>
        <c:url var="updateButton" value="/updateInfo">
<%-- помещаем внутрь ссылки параметр --%>
            <c:param name = "empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <tr>
<%--  <td>- ячейка таблицы--%>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
            onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                onclick="window.location.href= '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
<%-- указываем ссылку, которая будет открываться при нажатии на кнопку      --%>
        onclick="window.location.href = 'addNewEmployee'"/>
</body>
</html>