<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图片上传</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/amazeui.min.css">
	<link rel="stylesheet" type="text/css" href="css/amazeui.cropper.css">
	<link rel="stylesheet" type="text/css" href="css/custom_up_img.css">
    <style type="text/css">
 		.up-img-cover {width: 100px;height: 100px;}
 		.up-img-cover img{width: 100%;}
 		.background-color {background: rgba(0, 0, 0, 0.8);}
    </style>
</head>
<body>
	   	
	<div class="up-img-cover" id="up-img-touch" >
		<p id="autoClick" data-am-popover="{content: '点击上传', trigger: 'hover focus'}"></p>  		
	</div>
    	
  	<!--图片上传框-->
  	<div class="am-modal am-modal-no-btn up-frame-bj background-color" tabindex="-1" id="doc-modal-1">
		<div class="am-modal-dialog up-frame-parent up-frame-radius">
		    <div class="am-modal-hd up-frame-header">
		    	<label>修改头像</label>
		    	<a href="javascript:void(0)" class="am-close am-close-spin" style="font-size: 3rem;">&times;</a>
		    </div>
		    <div class="am-modal-bd  up-frame-body">
		        <div class="am-g am-fl">
			      	<div class="am-form-group am-form-file">
					    <div class="am-fl">
						    <button type="button" class="am-btn am-btn-default am-btn-sm">
						    <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
					    </div>
					    <input type="file" id="inputImage">
				   	</div>
		        </div>
		        <div class="am-g am-fl" >
			      	<div class="up-pre-before up-frame-radius">
			      		<img alt="" src="" id="image" >
			      	</div>
			      	<div class="up-pre-after up-frame-radius">
			      	</div>
		        </div>
			    <div class="am-g am-fl">
					<div class="up-control-btns">
			 			<span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
			 			<span class="am-icon-rotate-right" onClick="rotateimgright()"></span>
			 			<span class="am-icon-check" id="up-btn-ok" url="${pageContext.request.contextPath}/upload/images"></span>
					</div>
			   	</div>		      
			</div>
		</div>
	</div>
    	
   	<!--加载框-->
   	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">正在上传...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>
		
	<!--警告框-->
	<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">信息</div>
			<div class="am-modal-bd"  id="alert_content">上传成功！</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
	
	<script src="js/jquery.min.js" charset="utf-8"></script>
    <script src="js/amazeui.min.js" charset="utf-8"></script>
    <script src="js/cropper.min.js" charset="utf-8"></script>
    <script src="js/custom_up_img.js" charset="utf-8"></script>
    <script type="text/javascript"> 			
		window.onload = function(){ 
			$("#autoClick").click()
		}	
    </script> 
</body>
</html>
