<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <div th:replace="layout :: header-css"></div>
</head>
<body>


<div class="container">
    <div class="row">
        <div th:if="${hasError}">
            You have error in form
        </div>
        <form class="col lg12" th:action="@{/auth/register}" th:object="${user}" method="post">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="email" th:field="*{email}" class="validate" autocomplete="off">
                            <label for="email">Email</label>
                            <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}">Email Error
                                Error</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{username}" type="text" class="validate" autocomplete="off">
                            <label for="username">Username</label>
                            <span th:if="${#fields.hasErrors('username')}" th:errors="*{username}">Username Error
                                Error</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{password}" name="password" class="validate" autocomplete="off">
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
