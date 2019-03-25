package com.boot.security.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.boot.security.server.service.OssService;
import com.boot.security.server.utils.OSSClientUtil;

/**
 * 图片上传服务
 * <p>
 * Title: OssServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.kcallme.com
 * </p>
 * 
 * @author 贾鑫
 * @date 2015年9月4日下午2:50:42
 * @version 1.0
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public Map<String, Object> uploadPicture(MultipartFile uploadFile, boolean isOldName, String path) {
        Map<String, Object> resultMap = new HashMap<>();

        OSSClientUtil ossClient = new OSSClientUtil();
        try {

            String result = ossClient.uploadImg2Oss(uploadFile, isOldName, path);
            // 返回结果
            if (result.equals("")) {
                resultMap.put("code", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("code", 0);
            resultMap.put("url", result);
            return resultMap;

        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("message", "文件上传发生异常");
            e.printStackTrace();
            return resultMap;
        }

    }

}
