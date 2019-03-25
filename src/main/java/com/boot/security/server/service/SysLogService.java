package com.boot.security.server.service;

import com.boot.security.server.model.SysLogs;

/**
 * 日志service
 * 
 * @author jiaxin 13161618211@163.com
 *
 *         2017年8月19日
 */
public interface SysLogService {

	void save(SysLogs sysLogs);

	void save(Long userId, String module, Boolean flag, String remark);

	void deleteLogs();
}
