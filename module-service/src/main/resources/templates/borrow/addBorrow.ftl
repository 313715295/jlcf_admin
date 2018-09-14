<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发布标的</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all"/>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <style type="text/css">
        .layui-form-item .layui-inline {
            min-width: 15%;
            float: left;
            margin-right: 0;
        }

        .layui-form-item .role-box {
            position: relative;
        }

    </style>
</head>
<body class="childrenBody">

<form class="layui-form">
    <input type="hidden" name="id" ">
    <table class="layui-table">
        <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="35%">
        </colgroup>
        <tbody>
        <tr>
            <td>标的类型</td>
            <td>
                <select  id="borrowType" title="请选择标的类型">
            <#list borrowType as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
            <td>标的分组</td>
            <td>
                <select  id="borrowGroup" title="请选择标的分组">
            <#list borrowGroup as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td>标的名称</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
            <td>标签</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
        </tr>
        <tr>
            <td>理财期限(天)</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
            <td>标的金额(元)</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
        </tr>
        <tr>
            <td>年化利率(%)</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
            <td>加息利率(%)</td>
            <td><input type="text" class="layui-input" name="name" value="${borrow.name}" lay-verify="required" placeholder="请输入标的名称"></td>
        </tr>
        <tr>
            <td>最小投标金额</td>
            <td>
                <select  id="borrowGroup" title="请选择标的分组">
            <#list blaList as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
            <td>最大投标金额</td>
            <td>
                <select  id="borrowGroup" title="请选择标的分组">
            <#list bmaList as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td>可以使用加息券</td>
            <td></td>
            <td>可以使用红包</td>
            <td>可以使用红包</td>
        </tr>
        <tr>
            <td>资金募集时间</td>
            <td>
                <select  id="borrowGroup" title="请选择标的分组">
            <#list bmaList as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
            <td>标的风险等级</td>
            <td>
                <select  id="borrowGroup" title="请选择标的分组">
            <#list bmaList as item>
                <option id="borrow${item.id}" data-value="${item.value}">${item.name}</option>
            </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td>借款人用户名</td>
            <td></td>
            <td>借款用途</td>
            <td>借款用途</td>
        </tr>
        <tr>
            <td>产品详情</td>
            <td></td>
            <td>address</td>
            <td>address</td>
        </tr>
        <tr>
            <td>借款人详情</td>
            <td colspan="3"><div id="content1"></div></td>
        </tr>
        <tr>
            <td>保障措施</td>
            <td colspan="3"><div id="content2"></div></td>
        </tr>
        <tr>
            <td>保障措施</td>
            <td colspan="3"><div id="content3"></div></td>
        </tr>
        <tr>
            <td colspan="4">图片</td>
        </tr>
        </tbody>
    </table>
    <div class="layui-form-item" style="text-align: center;">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="site">发布标的</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/wangEditor.min.js"></script>
<script>
    function editorCreat(content_editor) {
        //图片上传
        content_editor.customConfig.uploadImgServer = '${base}/file/uploadWang';
        content_editor.customConfig.uploadFileName = 'test';
        // 自定义处理粘贴的文本内容(这里处理图片抓取)
        content_editor.customConfig.pasteTextHandle = function (content) {
            if (undefined === content) {
                return content;
            }
            if (content.indexOf("src=") <= 0) {
                return content;
            }
            var loadContent = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.ajax({
                url: "${base}/file/doContent/",
                type: "POST",
                async: false,
                data: {"content": content},
                dataType: "json",
                success: function (res) {
                    layer.close(loadContent);
                    content = res.data;
                }
            });
            return content;
        };
        // 关闭粘贴样式的过滤
        content_editor.customConfig.pasteFilterStyle = false;
        content_editor.customConfig.customAlert = function (info) {
            // info 是需要提示的内容
            layer.msg(info);
        };
        content_editor.create();
    }
    layui.use(['form', 'layer', 'jquery', 'upload'], function () {
        var form = layui.form,
                layer = layui.layer,
                upload = layui.upload,
                E = window.wangEditor,
                $ = layui.jquery;

        var content_editor1 = new E('#content1');
        var content_editor2 = new E('#content2');
        var content_editor3 = new E('#content3');
        editorCreat(content_editor1);
        editorCreat(content_editor2);
        editorCreat(content_editor3);

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1',
            url: '${base}/file/upload',
            accept: 'images',
            exts: 'ico',
            field: 'test',
            before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            },
            done: function (res) {
                //如果上传失败
                if (res.success === false) {
                    return layer.msg('上传失败');
                }
                $("#logo").val(res.data.url);
            },
            error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });

        upload.render({
            elem: '#test2',
            url: '${base}/file/upload/',
            field: 'test',
            before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#userFace').attr('src', result); //图片链接（base64）
                });
                layer.load(2, {
                    shade: [0.3, '#333']
                });
            },
            done: function (res) {
                layer.closeAll('loading');
                //如果上传失败
                if (res.success === false) {
                    return layer.msg('上传失败');
                } else {
                    layer.msg("上传成功", {time: 1000}, function () {
                        $("input[name='authorIcon']").val(res.data.url);
                    })
                }
            }
        });


        form.on('submit(site)', function (data) {
            var c = content_editor.txt.html();
            if (null != c || "" !== c || undefined !== c) {
                c = c.replace(/\"/g, "'");
                data.field.description = c;
            }

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post('${base}/borrow/addBorrow', data.field, function (res) {
                layer.close(loadIndex);
                if (res.success) {
                    layer.msg("站点信息更新成功", function () {
                        location.reload();
                    });

                } else {
                    layer.msg(res.msg);
                }
            });
            return false;
        });
    });
</script>
</body>
</html>