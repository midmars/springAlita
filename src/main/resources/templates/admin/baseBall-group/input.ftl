<div class="container-fluid">

    <div class="box box-success">
        <div class="box-header">
            <h2>棒球隊</h2>
        </div>

        <div class="box-body">

            <h3>輸入頁面</h3>
            <form name='f' action='/admin/baseBall-group/save' method='POST'>
                <table>
                    <tr>
                        <td>名稱</td>
                        <td><input type='text' name="name" value=''></td>
                    </tr>
                    <tr>
                        <td>勝場數</td>
                        <td><input type='text' name="victory"/></td>
                    </tr>
                    <tr>
                        <td>敗場數</td>
                        <td><input type='text' name="defeat"/></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="儲存"/></td>
                    </tr>
                    <#--<!--<input name="_csrf" type="hidden" value="${_csrf}"/>&ndash;&gt;-->

                </table>
            </form>
        </div>
    </div>
</div>