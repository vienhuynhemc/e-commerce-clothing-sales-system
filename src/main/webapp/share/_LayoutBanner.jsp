<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    //  Lấy ra ngôn ngữ hiện tại của session
    String language = (String) session.getAttribute("lang");

    //  Nếu null thì mặc đinh là tiếng việta
    if(language == null){
        language = "vietnamese";
    }

    //  Lấy ra title
    String title = null;
    if (language.equals("vietnamese")) {
        title = request.getParameter("titleVietnamese");
    } else {
        title = request.getParameter("titleEnglish");
    }

%>

<section id="aa-catg-head-banner">

    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content1">
                <h2><%=title%>
                </h2>
                <ul class="breadcrumbb">
                    <li><a href="IndexLanguageController">

                        <% if (language.equals("vietnamese")) { %>
                        Trang chủ
                        <% } else { %>
                        Home
                        <%}%>

                    </a> <i class="fa fa-angle-double-right"></i></li>
                    <li><%=title%>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>