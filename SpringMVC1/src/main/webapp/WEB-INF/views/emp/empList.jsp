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
   <form>
   사번<input name="employeeId">
   부서<input type="checkbox" name="depts" value="10">10
   	  <input type="checkbox" name="depts" value="20">20
   	  <input type="checkbox" name="depts" value="30">30
   직무<select name="jobId">
   		<option value="IT_PROG">IT_PROG
   		<option value="ST_CLERK">ST_CLERK
   		<option value="ST_MAN">ST_MAN
   </select>
   입사일자<input type="date" name="sdt">~<input type="date" name="edt">
   <button>검색</button>
</form>
   <c:forEach items="${empList}" var="emp">
      <a href="empUpdate/${emp.employeeId }">${emp.employeeId}</a>
      ${emp.firstName }
      ${emp.departmentId }
   </c:forEach>

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
               <td>${emp.employeeId}</td>
               <td>${emp.firstName}</td>
               <td>${emp.lastName}</td>
               <td>${emp.email}</td>
               <td>${emp.hireDate}</td>
               <td>${emp.jobId}</td>
               <td>${emp.salary}</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
</body>
</html>