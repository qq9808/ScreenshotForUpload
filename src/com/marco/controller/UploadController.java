package com.marco.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Decoder.BASE64Decoder;
import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONObject;

/**
 * @author Marco
 * @date 2017年5月30日 上午8:17:19
 * 截图上传Controller.
 */
@Controller
public class UploadController {

	/**
	 * 截图上传
	 */
	@RequestMapping(value="/upload/images", produces="application/json; charset=utf-8")
	@ResponseBody
	public String uploadTouxiang(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			
			//获取字符串形式的图片
			String strImage = request.getParameter("strImage");					

			//字符串不能为空
			if(StringUtils.isNotBlank(strImage)) {
				//字符串转换成jpg格式
				boolean uploadResult = generateImage(strImage, String.valueOf(System.currentTimeMillis()) + ".jpg");
				if(uploadResult) {
					//转换成功
					result.put("state", 200);
					result.put("msg", "成功！");
				}
				else {
					//转换失败
					result.put("state", -200);
					result.put("msg", "失败！");
				}
			}
			else {
				//参数为空
				result.put("state", -200);
				result.put("msg", "参数为空！");
			}		
			
		} catch (Exception e) {
			//异常处理
			e.printStackTrace();
			result.put("state", "4000");
			result.put("msg", "系统繁忙，请稍后再试！");
		}
		
		JSONObject jsonObject = JSONObject.fromObject(result);
		return jsonObject.toString();
	}

	/**
	 * base64字符串转化成图片  
	 * 对字节数组字符串进行Base64解码并生成图片  
	 * 成功返回true，失败返回false
	 */
    public static boolean generateImage(String imgStr, String imgName) {   
        
    	//图像数据为空，返回false
    	if(StringUtils.isBlank(imgStr) || StringUtils.isBlank(imgName)) {   		
    		return false;
    	}
  
        BASE64Decoder decoder = new BASE64Decoder();  
        
        try {    
        	
        	//创建图片存放目录
            String dirPath = "D:/upload";
            File dir = new File(dirPath);
            if(!dir.exists()) {
            	dir.mkdirs();
		    }
            
            //图片路径
            String imgFilePath = dirPath + File.separator + imgName;
        	
        	//Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i) {  
                if(b[i]<0)  
                {
                	//调整异常数据  
                    b[i]+=256;  
                }  
            }                     
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            
            //压缩图片
            String imgPath_compress = "D:/upload" + File.separator + "compress_" + imgName;
            compressImage(0.07f, imgFilePath, imgPath_compress);
            
            return true;  
        }   
        catch (Exception e) {  
            e.printStackTrace();   	
        }  
        
        return false;  
    }  
    
    /**
	 * 压缩图片
	 * @param size       压缩比例
	 * @param imgPath    原图片路径
	 * @param imgPath_compress 压缩图片的路径
	 */
    public static void compressImage(double size, String imgPath, String imgPath_compress) {   
    	  	
    	try {
			Thumbnails.of(imgPath).scale(0.50f).toFile(imgPath_compress);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
