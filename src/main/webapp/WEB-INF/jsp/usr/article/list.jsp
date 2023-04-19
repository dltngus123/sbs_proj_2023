<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>article 메~인</title>
</head>
<body>
   <h1>article</h1>
   
   <hr />
   <table border="1" style="text-align:center;">
      <thead>
         <tr>
            <th>번호</th>
            <th>작성날짜</th>
            <th>수정날짜</th>
            <th>작성자</th>
            <th>제목</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="article" items="${articles }">
         <tr>
            <td>${article.id }</td>
            <td><fmt:formatDate value="${article.regDate }" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${article.updateDate }" pattern="yyyy-MM-dd"/></td>
            <td>${article.memberId }</td>
            <td>
               <a href="../article/detail?id=${article.id }">${article.title }</a>
            </td>
         </tr>
         </c:forEach>
      </tbody>
   </table>
</body>
</html>