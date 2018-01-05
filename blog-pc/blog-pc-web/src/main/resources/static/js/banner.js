$(function () {

    var index = 0;
    var playTime = 5000;
    var timer = null;
    var totalCount = $("#big_img_ul").find("li").length;
    var txArr = ["bounceInDown", "bounceInLeft", "bounceInRight", "bounceInUp"];

    // 下一页
    $("#nextBtn").on("click", function () {
        if (timer) {
            clearInterval(timer);
        }
        index++;
        if (index >= totalCount) {
            index = 0;
        }
        banner_main(index);
    }).mouseout(function () {
        auto_play_banner();
    });

    // 上一页
    $("#prevBtn").on("click", function () {
        if (timer) clearInterval(timer);
        index--;
        if (index < 0) {
            index = totalCount - 1;
        }
        banner_main(index);
    }).mouseout(function () {
        auto_play_banner();
    });

    // 鼠标放在小图片上后的操作（1:清除计时 2:大图片联动）
    $("#small_img_ul").find("li").mouseover(function () {
        if (timer) {
            clearInterval(timer);
        }
        banner_main($(this).index());
    }).mouseout(function () {
        auto_play_banner();
    });

    // Main方法
    function banner_main(index) {
        var $liObj = $("#big_img_ul").find("li").eq(index);
        var $toolbar = $("#small_img_ul").find("li").eq(index);
        // 显示当前index图片,隐藏其他图片
        $liObj.fadeTo(800, 1).attr("class", "").addClass("animated " + txArr[Math.floor(Math.random() * txArr.length)]).siblings().hide();
        // 控制现图片的联动
        $toolbar.find("img").addClass("on");
        // 按钮联动
        $toolbar.siblings().find("img").removeClass("on");
    }

    // 自动播放轮播图
    function auto_play_banner() {
        timer = setInterval(function () {
            if (index >= totalCount - 1) {
                index = 0;
            } else {
                index++;
            }
            banner_main(index);
        }, playTime);
    }

    //初始化自动轮播
    auto_play_banner();
});

