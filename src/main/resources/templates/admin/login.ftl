<head>
    <#--<meta name="_csrf" content="${_csrf.token}"/>-->
    <#--<meta name="_csrf_header" content="${_csrf.headerName}"/>-->
</head>
<div class="container-fluid">

    <div class="box box-success">
        <div class="box-header">
            <h2>艾莉塔（<a href="http://localhost:8081/">Alita</a>)</h2>
        </div>

        <div class="box-body">

            <h3>登入頁面</h3>
            <form name='f' action='/admin/login/process' method='POST'>
                <table>
                    <tr>
                        <td>帳號</td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td>密碼</td>
                        <td><input type='password' name='password'/></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="登入"/></td>
                    </tr>
                    <#--<!--<input name="_csrf" type="hidden" value="${_csrf}"/>&ndash;&gt;-->

                </table>
                <div id="message" class="text-danger">${Session.SPRING_SECURITY_LAST_EXCEPTION!}</div>
            </form>
        </div>
    </div>
</div>