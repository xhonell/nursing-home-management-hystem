$(function(){
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location !== self.location) top.location = self.location;

        // 进行登录操作
        form.on('submit(login)', function (data) {
            data = data.field;
            if (data.username === '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password === '') {
                layer.msg('密码不能为空');
                return false;
            }
            if (data.captcha === '') {
                layer.msg('验证码不能为空');
                return false;
            }
            $.ajax({
                url: '/login',
                type: 'post',
                data: data,
                dataType: 'json',
                success: function (res) {
                    if (res.code === 200) {
                        layer.msg('登录成功');
                        window.localStorage.setItem("role",res.data);
                        location.href = '/pageReal/index.html';
                    } else {
                        layer.msg(res.msg);
                    }
                },
            });
            return false;
        });
    });
})