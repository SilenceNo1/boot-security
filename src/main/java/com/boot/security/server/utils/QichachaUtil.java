/**
 * 版权申明: 苏州朗动科技有限公司<br>
 * 项目描述: 企查查spring boot学习
 */
package com.boot.security.server.utils;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 描述：<br>
 * 
 * @author zhangwh<br>
 * @version 1.0<br>
 *          日期：2019年3月18日 下午7:11:08
 */
public class QichachaUtil {
	// 请登录http://yjapi.com/DataCenter/MyData
	// 查看我的秘钥 我的Key
	private static final String appkey = "959d5a1dd5c046039890fe86a5c77e5c";
	private static final String seckey = "B1E5BF76CB7FD702C1DCA21D31CF3E30";

	public static JSONObject get(Map<String, Object> params,String methodPath) {
		String reqInterNme = "http://api.qichacha.com"+methodPath;
		String paramStr = "keyword=新疆庆华能源集团有限公司";
		
		// 设置参数  
        if (params != null) {  
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();  
            for (Map.Entry<String, Object> entry : params.entrySet()) {  
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));  
            }  
            //EntityUtils.toString(new UrlEncodedFormEntity(nvps, charset));  
            paramStr= URLEncodedUtils.format(nvps, Consts.UTF_8);  
        }  
		String status = "";
		try {
			// auth header setting
			HttpHead reqHeader = new HttpHead();
			String[] autherHeader = RandomAuthentHeader();
			reqHeader.setHeader("Token", autherHeader[0]);
			reqHeader.setHeader("Timespan", autherHeader[1]);
			final String reqUri = reqInterNme.concat("?key=").concat(appkey).concat("&").concat(paramStr);
			String tokenJson = HttpHelper.httpGet(reqUri, reqHeader.getAllHeaders());
			out.println(String.format("==========================>this is response:{%s}", tokenJson));

			// parse status from json
			status = FormartJson(tokenJson, "Status");
			out.println(String.format("==========================>Status:{%s}", status));
			if (!HttpCodeRegex.isAbnornalRequest(status)) {
				//PrettyPrintJson(tokenJson);
				return JSONObject.parseObject(tokenJson);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return new JSONObject();
	}

	// 获取返回码 Res Code
	static class HttpCodeRegex {
		private static final String ABNORMAL_REGIX = "(101)|(102)";
		private static final Pattern pattern = Pattern.compile(ABNORMAL_REGIX);

		protected static boolean isAbnornalRequest(final String status) {
			return pattern.matcher(status).matches();
		}
	}

	// 获取Auth Code
	protected static final String[] RandomAuthentHeader() {
		String timeSpan = String.valueOf(System.currentTimeMillis() / 1000);
		String[] authentHeaders = new String[] { DigestUtils.md5Hex(appkey.concat(timeSpan).concat(seckey)).toUpperCase(), timeSpan };
		return authentHeaders;
	}

	// 解析JSON
	protected static String FormartJson(String jsonString, String key) throws JSONException {
		JSONObject jObject =   JSONObject.parseObject(jsonString);
		return (String) jObject.get(key);
	}

	// pretty print 返回值
	protected static void PrettyPrintJson(String jsonString) throws JSONException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Object obj = mapper.readValue(jsonString, Object.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			out.println(indented);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
