<html>
    <#include "../common/head.ftl">
    <body>
        <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">
        <#--主要内容connent-->
        <div id="page-content-wrapper">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAddress}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.orderStatusEnum().msg}</td>
                                <td>${orderDTO.payStatusEnum().msg}</td>
                                <td>${orderDTO.createTime}</td>
                                <td>
                                    <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                                </td>
                                <td>
                                    <#if orderDTO.orderStatusEnum().msg != "已取消" && orderDTO.orderStatusEnum().msg != "完结">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>
                        <#if orderDTOPage.getTotalPages() gt 6>
                            <#list 1..3 as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <li class="disabled"><a href="#">...</a></li>
                            <li><a href="/sell/seller/order/list?page=${orderDTOPage.getTotalPages()}&size=${size}">${orderDTOPage.getTotalPages()}</a></li>
                        <#else>
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                        </#if>
                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>
                        <#--页面跳转-->
                        <#--<div class="col-md-3 column">-->
                        <#--<text>sdd</text>-->
                        <#--<button type="button" class="btn btn-default">按钮</button>-->
                        <#--</div>-->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        var websocket = null;
        if('WebSocket' in window){
            websocket = new WebSocket('ws://127.0.0.1:8080/sell/webSocket');
        }else{
            alert('该浏览器不支持websocket');
        }
        websocket.onopen = function (event) {
            console.log('建立连接');
        }
        websocket.onclose = function (event) {
            console.log('连接关闭');
        }
        websocket.onmessage = function (event) {
            console.log('收到消息:' + event.data)
            //弹窗提醒, 播放音乐
//            $('#myModal').modal('show');
//
//            document.getElementById('notice').play();
        }
        websocket.onerror = function () {
            alert('websocket通信发生错误！');
        }
        window.onbeforeunload = function () {
            websocket.close();
        }
    </script>
    </body>
</html>
<#--<#list orderDTOPage.content as orderDTO>-->
    <#--${orderDTO.orderId}<br>-->
<#--</#list>-->