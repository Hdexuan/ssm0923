<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
    table {
	   width: 80%;
	   text-align: center;
	   border-collapse: collapse;
	   
}
 
 
 </style>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>

</head>
<body>
 <center>
  <!-- 获取到会话中的对象 -->
    欢迎，${u.username }&nbsp;&nbsp;
    <table border="1">
       <tr>
          <th>编号</th>
          <th>账号</th>
          <th>密码</th>
          <th>操作</th>
       </tr>
    <c:forEach  items="${list }" var="user">
        <tr>
          <td>${user.id }</td>
          <td>${user.username }</td>
          <td>${user.password }</td>
          <td>
             <!-- ${pageContext.request.contextPath}是JSP取得绝对路径的方法   :/ssm-0920   -->
             <a href="${pageContext.request.contextPath }/queryById/${sp }/${user.id } ">修改</a>
             |
             <a href="javascript:void(0);"  onclick="deleteById(${sp},${user.id })">删除</a>
          </td>
        </tr>
    </c:forEach>
   </table>
    
       总记录数：${totals }&nbsp;&nbsp;
       总页数：  ${pageCounts } &nbsp;&nbsp;
       当前页： ${sp }  &nbsp;&nbsp;  
     <a href="${pageContext.request.contextPath}/list/1">首页</a>&nbsp;&nbsp;
     <a href="${pageContext.request.contextPath}/list/${sp-1 }">上一页</a>&nbsp;&nbsp;
     <form action="${pageContext.request.contextPath }/list" method="post" style="display: inline;">
        <input type="text" name="currentPage" value="${sp }" size="4">
     </form> &nbsp;&nbsp;
     <a href="${pageContext.request.contextPath}/list/${sp+1 }" >下一页</a>&nbsp;&nbsp;
     <a href="${pageContext.request.contextPath}/list/${pageCounts } "></a>
       <input type="text" value="${pageContext.request.contextPath}"> 
   
   </center> 
    

</body>
</html>