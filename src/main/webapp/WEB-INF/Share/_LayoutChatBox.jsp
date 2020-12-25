<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="chatbox">
    <div class="iconchatbox" onclick="actionchatbox()">
        <i class="fa fa-connectdevelop"></i>
    </div>

    <div class="contentchatbox" id="contentchatbox">
        <div class="chatboxheader">
            <div>
                <i class="fa fa-times" onclick="actionchatbox()"></i>
            </div>
            <div>
                <h3><span style="color:#ff7315">TVT</span> Shop</h3>
                <p>Thuờng trả lời tin nhắn sau 1 giờ</p>
            </div>
        </div>

        <div class="midchatbox">
            <p class="timechat">12:00 PM</p>
            <p class="tvtchat">Xin chào!</p>
            <div class="iconTS"><span style="color:#ff7315">T</span>S</div>
            <p class="tvtchat">Tôi có thể giúp gì cho bạn ?</p>
            <p class="userchat">Xin chào!</p>
        </div>
        <div class="chatboxfooter">
            <p>Nhập tin nhắn ở đây...</p>
            <i class="fa fa-thumbs-o-up"></i>
        </div>

        <script>
            function actionchatbox() {
                let element = document.getElementById("contentchatbox");
                if (element.classList.contains("actionchatbox")) element.classList.remove("actionchatbox");
                else element.classList.add("actionchatbox");
            }
        </script>
    </div>
</div>