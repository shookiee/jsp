<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>log-in page</title>

    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/css/signin.css" rel="stylesheet">

  </head>

  <body>

     <div class="container">

      <form class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
<%--       <form class="form-signin" action="<%=request.getContextPath() %>/loginPractice" method="post"> --%>
        
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">USER ID</label>
        <input type="text" id="userId" name="userId" class="form-control" value="brown" placeholder="ID" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" value="brown1234" name="password" class="form-control" placeholder="Password" required>
        
        <div class="checkbox">
        
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      
      </form>

    </div> <!-- /container -->



  </body>
</html>