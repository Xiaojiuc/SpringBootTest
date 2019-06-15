<html>
<head><title>展示用户数据</title>
    <meta charset="utf-9"></meta>
</head>
<body>
<table border="1" align="center" width="50%">\
    <p>你好我的世界！</p>
    <tr>
        <th>ID</th>
    </tr>
    <#list list as user >
    <tr>
        <td>${user.a}</td>
    </tr>
    </#list>
</table>
</body>
</html>