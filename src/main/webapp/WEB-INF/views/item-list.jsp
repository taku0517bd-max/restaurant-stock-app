<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.stock.model.Item" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>在庫一覧</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <h1>在庫一覧</h1>
    <form action="<%= request.getContextPath() %>/items" method="get" class="search-box">
    <input type="text" name="category" placeholder="カテゴリで検索"
           value="<%= request.getAttribute("category") != null ? request.getAttribute("category") : "" %>">
    <button type="submit">検索</button>
    <a class="button" href="<%= request.getContextPath() %>/items">全件表示</a>
</form>
    <p class="lead">
    登録済みの商品一覧です。在庫数が発注点以下の商品は「発注必要」と表示されます。
</p>
    <div class="container">
    <p>
    <a class="button" href="<%= request.getContextPath() %>/items/create">新規登録</a>
</p>

    <p>
        <a href="<%= request.getContextPath() %>/">トップへ戻る</a>
    </p>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>商品名</th>
            <th>カテゴリ</th>
            <th>単位</th>
            <th>現在庫数</th>
            <th>発注点</th>
            <th>仕入単価</th>
            <th>状態</th>
            <th>メモ</th>
            <th>操作</th>
        </tr>

        <%
            List<Item> itemList = (List<Item>) request.getAttribute("itemList");

            for (Item item : itemList) {
        %>
        <tr>
            <td><%= item.getId() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getCategory() %></td>
            <td><%= item.getUnit() %></td>
            <td><%= item.getStockQuantity() %></td>
            <td><%= item.getReorderPoint() %></td>
            <td><%= item.getPurchasePrice() %>円</td>
            <td>
                <% if (item.isReorderNeeded()) { %>
    <span class="status-alert">発注必要</span>
<% } else { %>
    <span class="status-ok">在庫あり</span>
<% } %>
            </td>
            <td><%= item.getMemo() %></td>
            <td>
   <a class="button" href="<%= request.getContextPath() %>/items/edit?id=<%= item.getId() %>">編集</a>
<a class="button button-danger" href="<%= request.getContextPath() %>/items/delete?id=<%= item.getId() %>"
   onclick="return confirm('本当に削除しますか？');">削除</a>
</td>
        </tr>
        <%
            }
        %>
    </table>
    </div>
</body>
</html>