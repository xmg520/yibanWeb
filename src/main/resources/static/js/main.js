var nums = 120;
var nums2 = 3;
var clock;
var validate_studentId = false;
var validate_name = false;
var validate_tel = false;
var validate_idNumber = false;
var validate_qq = false;

"use strict"; !
	function (t, i) {
		var e = {
			id: "#cardArea",
			sid: ".card-item"
		};
		i.fn.cardArea = function (t) {
			var t = i.extend({},
				e, t);
			return this.each(function () {
				var e = i(t.id),
					n = e.find(t.sid);
				n.on("mouseenter",
					function () {
						i(this).addClass("active").siblings().removeClass("active")
					})
			})
		};
	}(window, jQuery);

//选择表单结果验证样式
function switchFromValidateStyle(fromGroupId, style, info) {

	//移除验证结果提示
	$(fromGroupId).removeClass('has-success has-warning has-error has-feedback');//颜色样式
	$(fromGroupId + ' .help-block').remove();//helpBlock文本提示
	$(fromGroupId + ' .glyphicon').removeClass('glyphicon-ok glyphicon-warning-sign glyphicon-remove');//框内图标提示

	switch (style) {
		case 'success':
			$(fromGroupId).addClass('has-success has-feedback');
			$(fromGroupId + ' .glyphicon').addClass('glyphicon-ok');
			break;
		case 'warning':
			$(fromGroupId).addClass('has-warning has-feedback');
			$(fromGroupId + ' .glyphicon').addClass('glyphicon-warning-sign');
			break;
		case 'error':
			$(fromGroupId).addClass('has-error has-feedback');
			$(fromGroupId + ' .glyphicon').addClass('glyphicon-remove');
			break;
	}
	if (info != '') {
		$(fromGroupId + ' input').after('<span class="help-block">' + info + '</span>');
	}

}

// //加载班级信息
// function loadCls(param) {
// 	postRquest(api_getCls, param, function (result) {
// 		if (result.errorCode == 0) {
// 			var clses = result.data;
// 			$('#cls').empty();
// 			$.each(clses, function (i, cls) {
// 				$('#cls').append('<option value=\"' + cls.cls + '\">' + cls.cls + '</option>');
// 			});
// 		}
// 	});
// }


$("#cardArea").cardArea();

//报名须知倒计时
$('#myModa3').on('show.bs.modal', function () {
	$('#waitText').css('display', 'block');
	$('#applyBtn').css('display', 'none');
	clock = setInterval(function () {
		nums2--;
		if (nums2 > 0) {
			$('#waitText').text('请先仔细阅读以上信息(' + nums2 + ')');
		} else {
			clearInterval(clock); //清除js定时器
			$('#applyBtn').css('display', 'inline');
			$('#waitText').css('display', 'none');
			$('#waitText').text('请先仔细阅读以上信息(3)');
			nums2 = 0; //重置时间
		}
	}, 1000); //一秒执行一次
});

//滚动箭头
$('#arrow').on('click', function () {
	var t = $(window).scrollTop();
	$('body,html').animate({ 'scrollTop': t + 1000 }, 1500);
});


// //初始化班级信息
// loadCls({ grade: 15, department: '网络资源系' });
//
// //系别下拉事件监听
// $('#department').on('change', function () {
// 	var garde = parseInt($('#grade').val());
// 	var department = $('#department').val();
//
// 	var param = {
// 		grade: garde,
// 		department: department
// 	}
//
// 	loadCls(param);
// });
//
// //年级下拉事件监听
// $('#grade').on('change', function () {
// 	var garde = parseInt($('#grade').val());
// 	var department = $('#department').val();
//
// 	var param = {
// 		grade: garde,
// 		department: department
// 	}
//
// 	loadCls(param);
// });

// 学号框失去焦点检验
$('#studentId').blur(function () {
	var xhNumber = $('#studentId').val();
	if (!xhNumber) {
		validate_studentId = false;
		switchFromValidateStyle('#studentId-group', 'error', '请输入学号');
	} else {
		validate_studentId = true;
		switchFromValidateStyle('#studentId-group', '', '');
	}
});

// 姓名框失去焦点检测
$('#name').blur(function () {
	var InName = $('#name').val();
	if (!InName) {
		validate_name = false;
		switchFromValidateStyle('#studentId-group', 'error', '请输入姓名');
	} else {
		validate_name = true;
		switchFromValidateStyle('#studentId-group', '', '');
	}
});

//手机框失去焦点检测
$('#tel').blur(function () {
	var telNumber = $('#tel').val();
	var istrue = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/.test(telNumber);
	if (!istrue) {
		validate_tel = false;
		switchFromValidateStyle('#tel-group', 'error', '请输入11位有效手机号码');
	} else {
		validate_tel = true;
		switchFromValidateStyle('#tel-group', '', '');
	}
});

// //身份证号码失去焦点检测
// $('#idNumber').blur(function () {
// 	if (!(/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/.test($('#idNumber').val()))) {
// 		validate_idNumber = false;
// 		switchFromValidateStyle('#idNumber-group', 'error', '身份证号码格式错误');
// 	} else {
// 		validate_idNumber = true;
// 		switchFromValidateStyle('#idNumber-group', '', '');
// 	}
// });

//qq框失去焦点检测
$('#qq').blur(function () {
	if (!(/^[1-9][0-9]{4,12}$/.test($('#qq').val()))) {
		validate_qq = false;
		switchFromValidateStyle('#qq-group', 'error', '密码请勿留空，若遗忘填写qwe123');
	} else {
		validate_qq = true;
		switchFromValidateStyle('#qq-group', '', '');
	}
});

// //发送短信验证码
// function sendCode() {
// 	var telNumber = $('#tel').val();
// 	var istrue = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/.test(telNumber);
// 	//手机号码格式检测
// 	if (!istrue) {
// 		validate_tel = false;
// 		switchFromValidateStyle('#tel-group', 'error', '请输入11位有效手机号码');
// 		return;
// 	}
// 	//手机号码是否已被绑定检测
// 	getRequest(api_telCheck + telNumber, function (result) {
// 		if (result.errorCode == -1) {
// 			switchFromValidateStyle('#tel-group', 'error', '此手机号码已被绑定，请重新输入。');
// 		} else if (result.errorCode == 0) {
// 			switchFromValidateStyle('#tel-group', '', '');
// 			postRquest(api_sendMessage, { tel: telNumber }, function (result) {
// 				if (result.errorCode == 0) {
// 					var btn = document.getElementById('getCode');
// 					btn.disabled = true; //将按钮置为不可点击
// 					btn.value = nums + '秒后可重新获取';
// 					clock = setInterval(function () {
// 						nums--;
// 						if (nums > 0) {
// 							$(btn).text('获取验证码(' + nums + ')');
// 						} else {
// 							clearInterval(clock); //清除js定时器
// 							btn.disabled = false;
// 							$(btn).text('获取验证码');
// 							nums = 120; //重置时间
// 						}
// 					}, 1000); //一秒执行一次
// 					switchFromValidateStyle('#tel-group', 'success', '验证码发送成功，请在10分钟内填写！');
// 				} else if (result.errorCode == -30) {
// 					switchFromValidateStyle('#tel-group', 'error', '发送短信失败，请联系管理员。');
// 				} else {
// 					switchFromValidateStyle('#tel-group', 'error', '失败，请联系管理员。');
// 				}
// 			})
// 		}
// 	});
// }

//提交报名
function apply() {
	if (validate_studentId && validate_name) {
		var param = {
			studentId: $('#studentId').val(),
			name: $('#name').val(),
			ybpasswd: '123456',
			department: $('#department').val(),
		};

		$.ajax({
			url: '/saveMem',
			type:'post',
			data: param,
			success: function (result) {
				if (result.state == 200) {
					// layer.msg('添加成功', { anim: 6, icon: 1, skin: 'layui-layer-molv' })
					alert("添加成功");
				} else {
					alert("添加失败");
				}
			}
		});

	}


}
//查看准考信息
function lookContestInfo() {
	var param = {
		userName: $('#look-name').val(),
		passWord: $("#look-id").val()
	}

	$.ajax({
		url: '/login',
		type:'post',
		data: param,
		success: function (result) {
			if (result.state == 200) {
				location.href = "/admin/user";
				// location.href = "page/main.html";
			} else {
				alert("用户名或者密码错误");
			}
		}
	});

}

// //重置查询准考信息UI
// $('#myModa4').on('hidden.bs.modal', function () {
// 	$('#look').html('<div class="row">' +
// 		'                    <label class="col-sm-3 col-sm-offset-2 text-right">姓名:</label>' +
// 		'                    <div class="col-sm-3">' +
// 		'                        <input  class="form-control" type="text" id="look-name" >' +
// 		'                    </div>' +
// 		'                </div>' +
// 		'                <div class="space-35"></div>' +
// 		'                <div class="row">' +
// 		'                    <label class="col-sm-3 col-sm-offset-2 text-right">身份证号码(后4位):</label>' +
// 		'                    <div class="col-sm-3">' +
// 		'                        <input  class="form-control" type="text" id="look-id" >' +
// 		'                    </div>' +
// 		'                </div>' +
// 		'                <div class="row">' +
// 		'                    <div id="tip" class="col-sm-7 col-sm-offset-5" style="color: red;padding: 10px;"></div>' +
// 		'                </div>');
// 	$('#look-footer').css("display", "block");
// })
//
//
