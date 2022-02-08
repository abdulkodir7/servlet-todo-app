<%@include file="/jsp/header.jsp" %>
<title>Login</title>
</head>
<body>
<section class="vh-100 bg-image" style="background: #007bff">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Sign in</h2>

                            <form method="post" action="<c:url value="/login"/>">

                                <div class="form-outline mb-4">
                                    <input type="text" name="username" class="form-control form-control-lg"/>
                                    <label class="form-label">Your username</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" name="password" class="form-control form-control-lg"/>
                                    <label class="form-label">Password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-primary btn-block btn-lg gradient-custom-4 text-body">
                                        Login
                                    </button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Don't have any account yet? <a
                                        href="<c:url value="/register"/>"
                                        class="fw-bold text-body"><u>Register
                                    here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
