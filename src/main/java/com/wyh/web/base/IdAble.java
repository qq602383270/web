/**
 * <pre>
 * Date:			2013年10月17日
 * Author:			<a href="mailto:guuoming.qin@yeepay.com">guoming.qin</a>
 * Description:
 * </pre>
 **/
 
package com.wyh.web.base;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/** 
 * 	Id接口
 */
public interface IdAble<T extends Serializable> {
	public T getId();

	public void setId(T id);
}