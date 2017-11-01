<%@include file="WEB-INF/pages/include.jsp"%>

<html>
<head>
    <title>Kievstar online menu</title>
</head>
<body>

<div class="centerDiv" align="center" style="width: 1024px; margin: 0 auto;">
    <button id="calculatebalance" style="width: 100px">calculate balance</button><br>
    <button id="paydebt" style="width: 100px">pay debts</button><br>
    <button id="showallabonents" style="width: 100px">show all abonents</button><br>
    <button id="showservices" style="width: 100px">show all services</button><br>
</div>

<script>
    $('#calculatebalance').click(function () {
        //location.href='calculatebalance';
         location.href='showallabonents';
    })
    $('#paydebt').click(function () {
        //location.href='paydebt';
        location.href='showallabonents';
    })
    $('#showallabonents').click(function () {
        location.href='showallabonents';
    })
    $('#showservices').click(function () {
        //location.href='showservices';
        location.href='showallabonents';
    })
</script>

</body>
</html>
