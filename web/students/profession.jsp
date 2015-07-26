<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profession List</title>
    </head>
    <body>
        <table border="1">
            <c:forEach var="profession" items="${professionList}">
                <tr>
                    <td>${profession.professionId}</td>
                    <td>${profession.professionName}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
