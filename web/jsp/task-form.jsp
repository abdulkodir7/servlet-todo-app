<%@include file="/jsp/header.jsp" %>
<title>Add Task</title>
</head>
<body>
<section class="vh-100" style="background-color: #2779e2;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-9">
                <c:choose>
                    <c:when test="${selectedTask.id != null}">
                        <h1 class="text-white mb-4">Edit Task</h1>
                    </c:when>
                    <c:otherwise>
                        <h1 class="text-white mb-4">Add a new fresh Task</h1>
                    </c:otherwise>
                </c:choose>
                <form method="post" action="<c:url value="/tasks"/>">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <div class="form-group">
                                <input hidden value="${selectedTask.id}" name="id" type="text" class="form-control">
                            </div>
                            <div class="row align-items-center pt-4 pb-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Title</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input type="text" value="${selectedTask.title}" name="title" required
                                           class="form-control form-control-lg"
                                           placeholder="Task title"
                                           style="font-size: 1rem"/>
                                </div>
                            </div>

                            <hr class="mx-n3">

                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Description</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                <textarea class="form-control" required name="description" rows="3"
                                          placeholder="Task description">${selectedTask.description}</textarea>
                                </div>
                            </div>

                            <hr class="mx-sm-3">

                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Deadline</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" value="${selectedTask.deadline}" required
                                           name="deadline" type="datetime-local">
                                </div>
                            </div>
                            <hr class="mx-n3">
                            <div class="px-5 py-4">
                                <c:choose>
                                    <c:when test="${selectedTask.id != null}">
                                        <button type="submit" class="btn btn-primary btn-lg">Edit task</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button type="submit" class="btn btn-primary btn-lg">Add task</button>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

</body>
</html>
