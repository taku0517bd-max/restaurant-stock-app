<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.stock.model.Item" %>

<%
    Item item = (Item) request.getAttribute("item");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品編集</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="container">
    <h1>商品編集</h1>

    <div class="form-box">
        <form action="<%= request.getContextPath() %>/items/update" method="post">
            <input type="hidden" name="id" value="<%= item.getId() %>">

            <p>
                商品名：<br>
                <input type="text" name="name" value="<%= item.getName() %>" required>
            </p>

            <p>
                カテゴリ：<br>
                <input type="text" name="category" value="<%= item.getCategory() %>">
            </p>

            <p>
                単位：<br>
                <input type="text" name="unit" value="<%= item.getUnit() %>">
            </p>

            <p>
                現在庫数：<br>
                <input type="number" name="stockQuantity" value="<%= item.getStockQuantity() %>" required>
            </p>

            <p>
                発注点：<br>
                <input type="number" name="reorderPoint" value="<%= item.getReorderPoint() %>" required>
            </p>

            <p>
                仕入単価：<br>
                <input type="number" name="purchasePrice" value="<%= item.getPurchasePrice() %>">
            </p>

            <p>
                メモ：<br>
                <input type="text" name="memo" value="<%= item.getMemo() %>">
            </p>

            <button type="submit">更新</button>
        </form>
    </div>

    <p>
        <a href="<%= request.getContextPath() %>/items">在庫一覧へ戻る</a>
    </p>
</div>
</body>
</html>