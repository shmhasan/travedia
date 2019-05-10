<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <div th:replace="layout :: header-css"></div>
</head>
<body>


<div class="container">
    <div class="row">
        <form class="col lg6" th:action="@{/auth/register}" method="post">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="email" type="email" name="email" class="validate" autocomplete="off">
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="username" name="username" type="text" class="validate" autocomplete="off">
                            <label for="username">Username</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" name="password" class="validate" autocomplete="off">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <button class="btn teal" style="width: 100%;">Register</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div th:replace="layout :: footer-scripts"></div>
</body>
</html>
