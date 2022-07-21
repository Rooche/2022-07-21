<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>사원정보</h3>
    <table border="1">
      <thead>
         <tr>
            <th>사원 번호</th>
            <th>사원 성</th>
            <th>사원 이름</th>
            <th>이메일</th>
            <th>입사일</th>
            <th>직책</th>
            <th>월급</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach items="${empList}" var="emp">
            <tr>
               <td>${emp.employee_id}</td>
               <td>${emp.first_name}</td>
               <td>${emp.last_name}</td>
               <td>${emp.email}</td>
               <td>${emp.hire_date}</td>
               <td>${emp.job_id}</td>
               <td>${emp.salary}</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   
</body>
</html>