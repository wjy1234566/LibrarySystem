<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

        <!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>联系我们</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <%-- action 映射到 "/feedback" --%>
                    <form method="get" class="form-horizontal" action="/feedback">
                         <div class="form-group">
                            <label class="col-sm-2 control-label">留言：</label>
                            <div class="col-sm-10">
                                <input name="feedback" type="tel" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn btn-white" onclick="javascrtpt:window.location.href='index.jsp'">取消</button>
                            </div>
                        </div>
                    </form>

                    <h3 style="color: green;">
                        <%
                        if(request.getAttribute("success")!= null){
                        out.print(request.getAttribute("success"));
                        }
                        %>
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>