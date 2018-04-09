<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <title>系统登陆</title>
</head>
<script type="text/javascript">
  function login() {
      $.post('${pageContext.request.contextPath}/user/login',$('#form1').serialize(),function(data){
        if(data==0){
            $("#msg").html("账户密码错误")
        }
          if(data==1){
              $("#msg").html("账户以冻结")
          }
          if(data==2){
              window.location.href="${pageContext.request.contextPath}/account.jsp";
          }
      })
  }
</script>

<body>
<center>
    <h2>系统登陆</h2>
    <form id="form1"method="post">
        <span id="msg"></span><br/>
        账号:<input name="number"/><br/>
        密码:<input name="pwd"/><br/>
        <input type="button" onclick="login()" value="登陆"/>
    </form>
</center>



</body>
</html>