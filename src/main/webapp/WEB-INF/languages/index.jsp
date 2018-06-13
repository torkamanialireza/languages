<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Languages</title>

</head>
<body>
<%@taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>All Languages</h1>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">#ID</th>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <l:forEach items="${languages}" var="language">
    <tr>
      <th scope="row"><l:out value="${language.id}"/></th>
      <td><a href="languages/${language.id}"><l:out value="${language.name}"/></a></td>
      <td><l:out value="${language.creator}"/></td>
      <td><l:out value="${language.currentVersion}"/></td>
      <td><a href="languages/edit/${language.id}">edit</a>| <a href="languages/delete/${language.id}">Delete</a></td>
    </tr>
  </l:forEach>
    
  </tbody>
</table>

<table class="table table-striped">
  <thead>
    <tr>
      
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>

    <tr>
      <form action="/new" method="post">
      <td>Name:<input type="text" name="name"/></td>
      <td>Creator:<input type="text" name="creator"/></td>
      <td>Current Version:<input type="text" name="currentVersion"/></td>
      <td><input type="submit" name="Submit"/></td>
      
      </form>  
    </tr>

  </tbody>
</table>


<!-- <a href="/languages">New Language</a> -->
</body>
</html>