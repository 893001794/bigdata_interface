package com.qtone.common.base.page;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * 分页对象
 * 
 * @version 1.0
 * @author tzp
 * 
 *         <pre>
 * 分页功能使用说明
 * </pre>
 *         <ul>
 *         <li>服务层的使用：<br>
 *         <code>
 *         import com.soa.base.page.Page;<br>
 *         public Page<T> findAllXX(@WebParam(name = "page")Page<T> page);<br>
 *         <font color="red">注意：方法参数是Page,返回也是Page</font>
 *       </code></li>
 *         <li>数据层的使用：<br>
 * 
 *         <pre>
 *      public Page&lt;T&gt; findAllXX(Page&lt;T&gt; page) {
 * 	String strSQL = "select * from dbowner.table_name"; //查询结果语句
 * 	String strCountSQL = "select count(*) from dbowner.table_name"; //统计表中记录数
 * 	page.paginationProcess(this.getJdbcTemplate().queryForLong(strCountSQL)); //计算总行数，总页数
 * 	String paginationSQL = page.getPaginationSQL(strSQL);//组装分页语句
 * 
 * 	Collection&lt;T&gt; list= this.getJdbcTemplate().query(paginationSQL,
 * 			new ParameterizedRowMapper&lt;T&gt;() {
 * 				@Override
 * 				public T mapRow(ResultSet rs, int rowNum)
 * 						throws SQLException {
 * 					T t = new T();
 * 					t.setPropertyName(rs.getString("column name"));
 * 					......
 * 					return t;
 * 				}
 * 			});
 * 	
 * 	page.setPageResult(list);
 * 	return page;
 * }
 * </pre>
 * 
 *         <font color="red">注意：参数T为泛性实体对象</font></li>
 *         <li>控制层的使用：
 * 
 *         <pre>
 * &#064;Controller
 * &#064;RequestMapping(&quot;/webService.do&quot;)
 * &#064;Scope(&quot;prototype&quot;)
 * public class WebServiceMangeController extends BaseController {
 * 	&#064;RequestMapping(params = &quot;action=index&quot;)
 * 	public ModelAndView index(HttpServletRequest request,
 * 			HttpServletResponse response, Long curPage, Long pageRows)
 * 			throws Exception {
 * 		Map&lt;String, Object&gt; map = new HashMap&lt;String, Object&gt;();
 * 		Page&lt;T&gt; page = new Page&lt;T&gt;(curPage, pageRows);
 * 		page.setUrl(&quot;webService.do?action=index&quot;); // 设置访问的地址
 * 		page = webservice.findAllXX(page);
 * 		map.put(&quot;page&quot;, page);
 * 		return new ModelAndView(&quot;ws/index&quot;, map);
 * 	}
 * }
 * </pre>
 * 
 *         </li>
 *         <li>表示层的使用：
 * 
 *         <pre>
 *      &lt;script language="JavaScript" src="/resource/js/global/page.js">&lt;/script&gt;
 * 	&lt;input type="hidden" id="page_per_num" value="3"/&gt;
 * 	&lt;span style="margin-right:20px;"&gt;共有&nbsp;&nbsp;&lt;font color="red"&gt;${page.totalRowsCount}&nbsp;&lt;/font&gt;&nbsp;&nbsp;条信息，每页&nbsp;&nbsp;&lt;font color="red"&gt;${page.pagePerRows}&lt;/font&gt;&nbsp;&nbsp;条，当前&nbsp;&nbsp;&lt;font color="red"&gt;${page.pageCurrent}&nbsp;/&nbsp;${page.totalPageCount}&lt;/font&gt;&nbsp;&nbsp;页&lt;/span&gt;
 * 	&lt;span style="padding-right:30px;"&gt;
 * 		&lt;img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/first.gif" onclick="navigationPage('${page.url}',${page.topPageNo})" title="第一页"/&gt;
 *         &lt;img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/prev.gif" onclick="navigationPage('${page.url}',${page.previousPageNo})"  title="上一页"/&gt;
 *         &lt;img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/next.gif" onclick="navigationPage('${page.url}',${page.nextPageNo})"  title="下一页"/&gt;
 *         &lt;img style="cursor:hand;margin-right:10px;" src="/resource/images/admin/last.gif" onclick="navigationPage('${page.url}',${page.bottomPageNo})"  title="最后页"/&gt;
 *     &lt;/span&gt;
 * </pre>
 * 
 *         </li>
 *         </ul>
 */
@XmlRootElement(name = "Pages")
@XmlType(name = "Page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page<T> implements java.io.Serializable {
	private static final long serialVersionUID = -8523555055477423700L;
	/**
	 * 总记录数
	 */
	@XmlElement(name = "totalRowsCount")
	private Long totalRowsCount;
	/**
	 * 总页数
	 */
	@XmlElement(name = "totalPageCount")
	private Long totalPageCount;
	/**
	 * 当前第几页
	 */
	@XmlElement(name = "pageCurrent")
	private Long pageCurrent = new Long(1);
	/**
	 * 每页显示多少条
	 */
	@XmlElement(name = "pagePerRows")
	private Long pagePerRows = new Long(1);

	/**
	 * 返回分页的结果集合
	 */
	private Collection<T> pageResult;
	/**
	 * 第一页
	 */
	@XmlElement(name = "topPageNo")
	private Long topPageNo;
	/**
	 * 上一页
	 */
	@XmlElement(name = "previousPageNo")
	private Long previousPageNo;
	/**
	 * 下一页
	 */
	@XmlElement(name = "nextPageNo")
	private Long nextPageNo;
	/**
	 * 最后页
	 */
	@XmlElement(name = "bottomPageNo")
	private Long bottomPageNo;
	/**
	 * 导航地址
	 */
	@XmlElement(name = "url")
	private String url;

	public Page() {
	}

	/**
	 * 
	 * @param pageCurrent
	 *            当前第几页
	 * @param pagePerRows
	 *            每页多少行
	 */
	public Page(Long pageCurrent, Long pagePerRows) {
		this.pageCurrent = pageCurrent;
		this.pagePerRows = pagePerRows;
	}

	/**
	 * 取得首页
	 * 
	 * @return
	 */
	public Long getTopPageNo() {
		topPageNo = new Long(1);
		return topPageNo;
	}

	/**
	 * 上一页
	 * 
	 * @return
	 */
	public Long getPreviousPageNo() {
		if (this.getPageCurrent() <= 1) {
			previousPageNo = new Long(1);
		} else {
			previousPageNo = this.getPageCurrent() - 1;
		}
		return previousPageNo;
	}

	/**
	 * 下一页
	 * 
	 * @return
	 */
	public Long getNextPageNo() {
		if (this.getPageCurrent() >= getBottomPageNo()) {
			nextPageNo = getBottomPageNo();
		} else {
			nextPageNo = this.getPageCurrent() + 1;
		}
		return nextPageNo;
	}

	/**
	 * 取得尾页
	 * 
	 * @return
	 */
	public Long getBottomPageNo() {
		bottomPageNo = this.getTotalPageCount();
		return bottomPageNo;
	}

	/**
	 * 处理分页过程信息
	 * 
	 * @param totalRowsCount
	 *            总记录数
	 * 
	 */
	public void paginationProcess(Long totalRowsCount) {
		this.totalRowsCount = totalRowsCount;
		if (totalRowsCount % pagePerRows == 0) {
			totalPageCount = totalRowsCount / pagePerRows;
		} else {
			totalPageCount = totalRowsCount / pagePerRows + 1;
		}
	}

	/**
	 * 获取分页的SQL
	 * 
	 * @param strSQL
	 * @return
	 */
	public String getPaginationSQL(String strSQL) {
		StringBuffer paginationSQL = new StringBuffer(" select * from ( ");
		paginationSQL.append(" select temp.* ,rownum num from ( ");
		paginationSQL.append(strSQL);
		paginationSQL.append("  ) temp where rownum <= " + this.getEndIndex());
		paginationSQL.append(" ) where  num >= " + this.getStartIndex());
		return paginationSQL.toString();
	}

	/**
	 * 总记录数
	 */
	public Long getTotalRowsCount() {
		return totalRowsCount;
	}

	/**
	 * 总页数
	 */
	public Long getTotalPageCount() {
		return totalPageCount;
	}

	/**
	 * 当前第几页
	 */
	public Long getPageCurrent() {
		return pageCurrent;
	}

	/**
	 * 当前第几页
	 */
	public void setPageCurrent(Long pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	/**
	 * 每页显示多少条
	 */
	public Long getPagePerRows() {
		return pagePerRows;
	}

	/**
	 * 每页显示多少条
	 */
	public void setPagePerRows(Long pagePerRows) {
		this.pagePerRows = pagePerRows;
	}

	/**
	 * 结束位置
	 */
	public Long getEndIndex() {
		long endIndex = 0;
		if (this.getPageCurrent() == this.getTotalPageCount()) {
			endIndex = this.getTotalRowsCount();
		} else {
			endIndex = this.getPageCurrent() * this.getPagePerRows();
		}
		return endIndex;
	}

	/**
	 * 开始位置
	 */
	public Long getStartIndex() {
		long startIndex = (this.getPageCurrent() - 1) * this.getPagePerRows()
				+ 1;
		return startIndex;
	}

	/**
	 * 返回分页的结果集合
	 */
	public Collection<T> getPageResult() {
		return pageResult;
	}

	/**
	 * 返回分页的结果集合
	 */
	public void setPageResult(Collection<T> pageResult) {
		this.pageResult = pageResult;
	}

	/**
	 * 导航地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 导航地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public void setTotalRowsCount(Long totalRowsCount) {
		this.totalRowsCount = totalRowsCount;
	}

	public void setTotalPageCount(Long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setTopPageNo(Long topPageNo) {
		this.topPageNo = topPageNo;
	}

	public void setPreviousPageNo(Long previousPageNo) {
		this.previousPageNo = previousPageNo;
	}

	public void setNextPageNo(Long nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public void setBottomPageNo(Long bottomPageNo) {
		this.bottomPageNo = bottomPageNo;
	}

}
