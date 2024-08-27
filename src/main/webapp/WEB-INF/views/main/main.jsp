<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <title>Main</title>
</head>
<body>
    <%-- 헤더 위치 --%>
    <jsp:include page="../common/header.jsp"/>

    <hr>

    <h3>1. tbl_employee 테이블에서 직원 전체 정보 조회</h3>
    <p>(퇴사하지 않은 직원만 조회할 것) : GET /employee/list</p>
    <button onclick="location.href='${pageContext.servletContext.contextPath}/employee/list'">전체 직원정보 조회하기</button>

    <hr>

    <h3>2. tbl_employee 테이블에서 emp_id를 이용하여 사원 정보 조회해오기</h3>
    <form action="employee/select">

    </form>

    <hr>

    <h3>3. tbl_employee 테이블에서 신규 직원 정보 추가</h3>
    <p>(필요한 정보를 입력받을 수 있는 form을 만들어서 추가할 것) : POST /employee/insert</p>
    <form action="${ pageContext.servletContext.contextPath }/employee/insert" method="post">

    </form>

    <h3>4. tbl_employee 테이블에서 직원 정보 수정</h3>
    <p>(사번과 변경할 정보를 입력 받아 사번과 일치하는 사원의 정보 변경 - 원하는 데이터 변경) : POST /employee/update</p>
    <form action="${ pageContext.servletContext.contextPath }/employee/update" method="post">
        사번 : <input type="text" name="empId"><br>
        이메일 : <input type="text" name="email"><br>
        phone : <input type="text" name="phone"><br>
        <button>직원 정보 변경</button>
    </form>

    <h3>5. tbl_employee 테이블에서 직원 정보 삭제 </h3>
    <p>(사번 입력 받아 사번과 일치하는 행 삭제) : POST /employee/delete</p>
    <form action="${ pageContext.servletContext.contextPath }/employee/delete" method="post">

    </form>
</body>
</html>
