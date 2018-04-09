<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <title>转账页面</title>
</head>
<script type="text/javascript">
    function login() {
        $.post('${pageContext.request.contextPath}/user/account',$('#form1').serialize(),function(data){
            if(data==0){
                $("#msg").html("目标账户不存在")
            }
            if(data==1){
                $("#msg").html("目标账户以冻结")
            }
            if(data==2){
                $("#msg").html("账户余额不足")
            }
            if(data==3){
                window.location.href="${pageContext.request.contextPath}/success.jsp";
            }
        })
    }
</script>

<body>
<center>
    <h2>转账操作</h2>
    <form id="form1"method="post">
        <span id="msg"></span><br/>
        输入账户:<input name="number"/><br/>
        转账金额:<input name="balnace"/><br/>
        <input type="button" onclick="login()" value="确认转账"/>
    </form>
</center>



</body>
</html>