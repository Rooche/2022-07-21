<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
</head>
<body>

   <h4>사원 수정</h4>
   <form action="update" method="post">
      <input type="hidden" name="employeeId" value="${emp.employeeId}">
      <div>
         firstName<input name="firstName" value="${emp.firstName }">
      </div>
      <div>
         lastName<input name="lastName" value="${emp.lastName }">
      </div>
      <div>
         hireDate<input type="date" name="hireDate" value="${emp.hireDate }">
      </div>
      <div>
         email<input name="email" value="${emp.email }">
      </div>
      <div>
         jobId<input name="jobId" value="${emp.jobId }">
      </div>

      <button>수정</button>
      <button type="button" onclick="empDelete(${emp.employeeId})">삭제</button>
   </form>

</body>
<script type="text/javascript">
   function empDelete(id){
      location.href="/mvc/empDelete?employeeId="+id;
   }
</script>
</html>