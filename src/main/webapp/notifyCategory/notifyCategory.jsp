<%--
  Created by IntelliJ IDEA.
  User: 84168
  Date: 1/19/2021
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý danh mục</title>
    <style>
        .main-notify{
            width: 450px;
            height: 250px;
            padding: 10px 10px 10px 10px;
        }
        .header-notify{
            width: 100%;
            height: 10%;
            font-weight: bold;
            display: flex;
        }
        .header-notify button{
            outline: none;

        }
        .body-notify{
            width: 100%;
            justify-content: center;
        }
        .body-notify p{
            width: 35%;
            height: 20%;
            background-color: #0000FF;
            border-radius: 10px;
            color: white;
        }

    </style>
</head>

<body>
    <div class="main-notify">
        <div class="header-notify" id="header-notify">
            <div> Quản lí danh mục</div>
            <button> &times;</button>
        </div>
        <div class="body-notify" id ="body-notify">
        <span> Thêm sản phẩm thành công!</span>
            <p>Trở về</p>
        </div>
        <div class="layer-notify" id="layer-notify">

        </div>

    </div>
</body>
</html>
