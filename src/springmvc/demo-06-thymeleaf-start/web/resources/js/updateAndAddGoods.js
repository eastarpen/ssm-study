function upload(operation, prefix) {
    let submit = $('#submit')
    if(!(function (){
        let flag = true;
        $("input[type='text']").each(function () {
            return flag= $(this).val() != "";
        })
        return flag;
    })()) {
        layer.msg("请填写数据!!", {icon: 2, time: 1000}, );
        return false;
    }
    let flag = operation=="add";
    let url;
    url = prefix+"/data/"+(flag?"add":"update");
    console.log(url);
    layer.confirm('继续操作?', {icon: 3, title:'提示'}, function(index){
        $.ajax({
            url: url,
            method: "post",
            data: {
                id: flag?-1: $('#goodsId').val(),
                name: $('#goodsName').val(),
                type: $('#goodsType').val(),
                origin: $('#goodsOrigin').val(),
                price: $('#goodsPrice').val(),
                productionDate: $('#goodsDate').val()
            },
            success(result) {
                result = JSON.parse(result);
                if(result.success) {
                    layer.msg("操作成功!", {icon: 1, time: 750}, function () {
                        window.location.href = prefix+"/manage";
                    });
                } else {
                    layer.msg("操作失败, 请检查数据格式!", {icon: 2, time: 750});
                }
            },
            error() {
                layer.msg("操作失败!", {icon: 2, time: 750});
            }
        });
        layer.close(index)
    });
    return true;
}
