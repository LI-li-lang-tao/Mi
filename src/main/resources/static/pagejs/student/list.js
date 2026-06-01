layui.use('table', function(){
    let table = layui.table;

    let inst = table.render({
    elem: '#tbStudent',
    url:"/api/student/list",
    cols: [[ //标题栏
{field: 'id', title: 'ID', width: 80, sort: true},
{field: 'name', title: '用户', width: 120},
{field: 'sno', title: '学号', minWidth: 160},
{field: 'sex', title: '性别', width: 80,
templet:(row)=>{
    if(row.sex==1){
        return "男"
    }else if(row.sex==2)
    {
        return "女"
    }
    else{
        return "未知"
    }
}},

{field: 'age', title: '年龄', width: 100},
{field: 'score', title: '成绩', width: 80, sort: true}
    ]],

    page: true, // 是否显示分页
    limits: [5, 10, 15],
    limit: 5 // 每页默认显示的数量
});
});

