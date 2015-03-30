<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>
            <c:out value="${productName}"/>
        </title>
    </head>
        <body>
            <table>
                <c:forEach items="${listOfProduct}" var="product">
                <tr>
                    <td>
                        ${product.name}
                    </td>
                    <td>
                        ${product.price}
                    </td>
                </tr>
                </c:forEach>
            </table>
    </body>

</html>