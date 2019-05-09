<%--
  Created by IntelliJ IDEA.
  User: iammh
  Date: 5/10/19
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <link rel="stylesheet" href="/static/design/css/materialize.min.css">
</head>
<body>


  <div class="container-fluid">
    <div class="row">
      <div class="col lg12">
        <div class="card blue-grey darken-1">
          <div class="card-content white-text">
            <span class="card-title">Login</span>


            <input type="email" style="display: none;" name="usernamehidden" >
            <input type="password" style="display: none;" name="usernamehidden" >

            <form class="col s12">
              <div class="row">
                <div class="input-field col s12">
                  <input id="email" type="email" class="validate" autocomplete="off">
                  <label for="email">Email</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="password" type="password" class="validate" autocomplete="off">
                  <label for="password">Password</label>
                </div>
              </div>
              <button class="btn teal" style="width: 100%;">Login</button>
            </form>


          </div>
        </div>
      </div>
    </div>
  </div>

<script src="/static/design/js/materialize.min.js"></script>
</body>
</html>
