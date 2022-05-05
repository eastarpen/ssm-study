function deleteGoods(id, prefix) {
    layer.confirm('确定删除?', {icon: 3, title:'提示', anim: 6}, function(index){
        $.ajax({
            url: prefix+"/data/delete",
            method: "get",
            data: { id: id },
            success(result) {
                result = JSON.parse(result);
                if(result.success) {
                    layer.msg("成功删除!", {icon: 1, time: 750}, function () {
                        location.reload(true);
                    });
                } else {
                    layer.msg("操作失败!", {icon: 2, time: 750});
                }
            },
            error() {
                layer.msg("操作失败!", {icon: 2, time: 750});
            }
        });
        layer.close(index);
    });
}

function search(prefix) {
    let key = $('#searchInput').val();
    if(key == "") {
        layer.msg("请输入关键字搜索!", {icon: 2, time: 750, anim: 6});
        return false;
    }
    location.replace(prefix+'/manage?key='+key);
}