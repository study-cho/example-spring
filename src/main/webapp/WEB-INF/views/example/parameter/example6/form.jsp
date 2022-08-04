<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Example6</title>
</head>
<body>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(function() {
        var json = {
            user: {
                name: '홍길동',
                age: 14,
                address: '대한민국'
            }
        };

        $.ajax({
            url: '/example/parameter/example6/saveData',
            type: 'post',
            data: JSON.stringify(json),
            contentType: 'application/json',
            dataType: 'json',
            success: function(data) {
                console.log(data);
            }

        });
    });
</script>
</body>
</html>