<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>飲食店向け在庫管理アプリ</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<div class="container top-container">

    <div class="hero">
        <div>
            <h1>飲食店向け在庫管理アプリ</h1>
            <p class="lead">
                食材・備品の在庫数を管理し、発注が必要な商品をひと目で確認できる業務支援アプリです。
            </p>

            <div class="actions">
                <a class="button" href="<%= request.getContextPath() %>/items">在庫一覧を見る</a>
                <a class="button" href="<%= request.getContextPath() %>/items/create">商品を新規登録する</a>
            </div>
        </div>

        <div class="hero-card">
            <p class="hero-label">現在の主な機能</p>
            <h2>在庫管理・発注判断</h2>
            <p>在庫数と発注点を比較し、発注が必要な商品を自動で表示します。</p>
        </div>
    </div>

    <h2>主な機能</h2>

    <div class="feature-grid">
        <div class="feature-card">
            <h3>商品登録</h3>
            <p>食材・備品の名前、カテゴリ、在庫数、発注点を登録できます。</p>
        </div>

        <div class="feature-card">
            <h3>在庫一覧表示</h3>
            <p>登録済みの商品を一覧で確認できます。</p>
        </div>

        <div class="feature-card">
            <h3>商品編集</h3>
            <p>在庫数や発注点、メモをあとから変更できます。</p>
        </div>

        <div class="feature-card">
            <h3>商品削除</h3>
            <p>不要になった商品データを削除できます。</p>
        </div>

        <div class="feature-card">
            <h3>発注アラート</h3>
            <p>在庫数が発注点以下になると「発注必要」と表示します。</p>
        </div>
    </div>

</div>
</body>
</html>