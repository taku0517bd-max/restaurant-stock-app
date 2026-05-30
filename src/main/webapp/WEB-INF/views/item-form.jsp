<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品登録</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="container">
    <h1>商品登録</h1>

    <div class="form-box">
        <form action="<%= request.getContextPath() %>/items/create" method="post">
            <p>
                商品名：<br>
                <input type="text" name="name" required>
            </p>

            <p>
                カテゴリ：<br>
                <input type="text" name="category">
            </p>

            <p>
                単位：<br>
                <input type="text" name="unit">
            </p>

            <p>
                現在庫数：<br>
                <input type="number" name="stockQuantity" required>
            </p>

            <p>
                発注点：<br>
                <input type="number" name="reorderPoint" required>
            </p>

            <p>
                仕入単価：<br>
                <input type="number" name="purchasePrice">
            </p>

            <p>
                メモ：<br>
                <input type="text" name="memo">
            </p>

            <button type="submit">登録</button>
        </form>
    </div>

    <p>
        <a href="<%= request.getContextPath() %>/items">在庫一覧へ戻る</a>
    </p>
</div>
</body>
</html>