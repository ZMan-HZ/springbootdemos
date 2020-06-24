//获取复选框参数方法. 第三种
function getCheckBoxValue() {
    //获取input类型是checkBox并且 name="box"选中的checkBox的元素
    var data = $('input:checkbox[name="id"]:checked').map(function () {
        return $(this).val();
    }).get().join(",");
    //弹出结果
    alert(data);
}