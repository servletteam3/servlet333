<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <title>Emp Info</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            color: #333;
            text-align: center; /* Center-align text on the page */
        }

        .container {
            max-width: 600px; /* Set a maximum width for the container */
            margin: 0 auto; /* Center the container horizontally */
            padding: 20px; /* Add padding inside the container */
            background-color: #ffffff; /* White background for the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Shadow for depth */
        }

        h1 {
            color: #3498db; /* Blue color for the heading */
            margin-bottom: 20px; /* Space below the heading */
        }

        p {
            font-size: 16px; /* Slightly larger text for better readability */
            line-height: 1.6; /* Increased line height for better spacing */
            margin-bottom: 10px; /* Space below each paragraph */
            color: #555; /* Slightly lighter text color for paragraphs */
        }

        .info-label {
            font-weight: bold; /* Make labels bold */
            color: #2c3e50; /* Darker color for labels */
        }
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
    <h1>Employee Information</h1>
    <p><span class="info-label">사원번호:</span> ${ requestScope.selectedEmp.empId }</p>
    <p><span class="info-label">사원명:</span> ${ requestScope.selectedEmp.empName }</p>
    <p><span class="info-label">부서코드:</span> ${ requestScope.selectedEmp.deptCode }</p>
    <p><span class="info-label">직급코드:</span> ${ requestScope.selectedEmp.jobCode }</p>
    <p><span class="info-label">급여:</span> ${ requestScope.selectedEmp.salary }</p>
</div>
</body>
</html>
