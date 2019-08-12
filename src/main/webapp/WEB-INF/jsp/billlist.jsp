<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
       <div class="location">
           <strong>您现在所在的位置是:</strong>
           <span>当前排队患者页面</span>
       </div>
       <div class="search">
       <form method="post" action="${pageContext.request.contextPath }/pat/getPat">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>患者编号：</span>
			<input name="patientId" type="text" value="${param.patientId}">

<%--			<span>供应商：</span>--%>
<%--			<select name="providerId">--%>
<%--				<c:if test="${providerList != null }">--%>
<%--				   <option value="0">--请选择--</option>--%>
<%--				   <c:forEach var="provider" items="${providerList}">--%>
<%--				   		<option value="${provider.id}">${provider.proName}</option>--%>
<%--				   </c:forEach>--%>
<%--				</c:if>--%>
<%--       		</select>--%>
<%--			 --%>
<%--			<span>是否付款：</span>--%>
<%--			<select name="isPayment">--%>
<%--				<option value="">--请选择--</option>--%>
<%--				<option value="未付款" ${queryIsPayment == '未付款' ? "selected=\"selected\"":"" }>未付款</option>--%>
<%--				<option value="已付款" ${queryIsPayment == '已付款' ? "selected=\"selected\"":"" }>已付款</option>--%>
<%--       		</select>--%>
		   <input type="hidden" name="pageIndex" value="1"/>
			 <input	value="查 询" type="submit" id="searchbutton">

		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">患者编号</th>
              <th width="10%">患者姓名</th>
              <th width="8%">性别</th>
              <th width="7%">年龄</th>
			  <th width="15%">预约时间</th>
              <th width="30%">检查所见</th>
              <th width="20%">操作</th>
          </tr>
          <c:forEach var="pat" items="${patients }" varStatus="status">
				<tr>
					<td>
					<span>${pat.patientId }</span>
					</td>
					<td>
					<span>${pat.name}</span>
					</td>
					<td>
					<span>${pat.sex}</span>
					</td>
					<td>
					<span>${pat.age}</span>
					</td>
					<td>
					<span>
						<fmt:formatDate value="${pat.date}" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
					</span>
					</td>
					<td>
						<span>${pat.diag}</span>
					</td>
					<td>
					<span><a class="viewBill" href="javascript:;" patientId=${pat.patientId } examCode=${pat.examCode }><img src="${pageContext.request.contextPath }/images/c1.png" alt="呼叫" title="呼叫"/></a></span>
					<span><a class="viewBill" href="javascript:;" patientId=${pat.patientId } examCode=${pat.examCode }><img src="${pageContext.request.contextPath }/images/c3.png" alt="过号" title="过号"/></a></span>
							<%--					<span><a class="modifyBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>--%>
<%--					<span><a class="deleteBill" href="javascript:;" billid=${bill.id } billcc=${bill.billCode }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除" onclick="deleteBill(this)"/></a></span>--%>

					</td>
				</tr>
			</c:forEach>
      </table>
	<c:import url="rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}"/>
		<c:param name="currentPageNo" value="${currentPageNo}"/>
		<c:param name="totalPageCount" value="${totalPageCount}"/>
	</c:import>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>