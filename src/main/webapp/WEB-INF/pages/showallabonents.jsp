<%@include file="include.jsp" %>
<html>
<head>
    <title>All abonents</title>
</head>
<body>

    <c:set var="abonents" value="${abonents}"/>

    <div align="center" style="width: 1024px; margin: 30px auto;">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Services</th>
                <th>Balance</th>
                <th>AddService</th>
                <th>PayOnLine</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${abonents}" var="abonent">
                <tr>
                    <td>${abonent.name}</td>
                    <td>${abonent.type}</td>
                    <td>${abonent.services}</td>
                    <td>${abonent.balance}</td>
                    <td><button class="AddService">Add service</button></td>
                    <td><button class="PayOnline">Pay online</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>








