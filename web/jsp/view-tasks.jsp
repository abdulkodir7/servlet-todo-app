<%@include file="/jsp/header.jsp" %>
<title>Tasks</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <!-- Container wrapper -->
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarButtonsExample">
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a href="/jsp/task-form.jsp">
                        <button type="button" class="btn btn-success me-3">
                            Add new ultra fresh task
                        </button>
                    </a>
                </li>

            </ul>
            <!-- Left links -->

            <div class="d-flex align-items-center">
                <a href="/logout">
                    <button type="button" class="btn btn-link px-3 me-2">
                        Logout
                    </button>
                </a>

                <a href="/">
                    <button type="button" class="btn btn-link px-3 me-2">
                        Home
                    </button>
                </a>

            </div>
        </div>
        <!-- Collapsible wrapper -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->


<c:choose>
    <c:when test="${taskList.size()>0}">
        <div class="row" style="padding: 20px">
            <c:forEach var="task" items="${taskList}">
                <div class="col-sm-4" style="padding: 10px">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${task.title}</h5>
                            <p class="card-text">${task.description}</p>
                            <p>Deadline: <span class="badge rounded-pill bg-danger"
                                               style="color: white">${task.deadline}</span>
                            </p>
                            <a href="<c:url value="/editTask?id=${task.id}"/>" class="btn btn-primary">Edit</a>
                            <a href="<c:url value="/deleteTask?id=${task.id}"/>" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container" style="alignment: center;  width: 40%; padding: 100px; color: gray">
            <h1>No tasks yet...</h1>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
