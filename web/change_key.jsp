<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>修改密码</title>
   
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
                        <%-- action 映射到 "/key" --%>
                        <form method="post" class="form-horizontal" action="/key">
                            <%-- 获得当前会话下的StuID，并传递出去 --%>
                            <%
                                String StuID = (String) session.getAttribute("StuID");
                            %>
                            <input  type="hidden" name="StuID" value=<%=StuID%>>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码：</label>
                                <div class="col-sm-10">
                                    <input name="key1" type="password" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">再次输入：</label>
                                <div class="col-sm-10">
                                    <input name="key2" type="password" class="form-control">                           
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">

                                    <button class="btn btn-primary" type="submit">保存</button>
                                    <button class="btn btn-white" onclick="javascrtpt:window.location.href='index.jsp'">取消</button>
                                </div>
                            </div>
                        </form>
                        <%--  修改不成功 --%>
                        <h3 style="color: red;">
                            <%
                                if(request.getAttribute("message_err")!= null){
                                    out.print(request.getAttribute("message_err"));
                                }
                            %>
                        </h3>
                        <%--   修改成功  --%>
                        <h3 style="color: green;">
                            <%
                                if(request.getAttribute("message_suc")!= null){
                                    out.print(request.getAttribute("message_suc"));
                                }
                            %>
                        </h3>
                        <%--   密码空  --%>
                        <h3 style="color: red;">
                            <%
                                if(request.getAttribute("message_null")!= null){
                                    out.print(request.getAttribute("message_null"));
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