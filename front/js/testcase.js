var CURRENT_PAGE = 1;
$(function(){
	selALLCase();
	selAllProject();
});

function selALLCase(testcaseName,modelId){
	var param={
			testcaseName:testcaseName,
			modelId:modelId,
			currentPage:CURRENT_PAGE,
			pageSize:$('#selectV option:selected').val()

			}		
				  $.ajax({
						type : 'POST',
						url :'/back/home/selectCaseBySearch',
						async : false,
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(param),
						dataType : "json",
						success : function(result) {
							//debugger;
	                        var data=result.data;
	                         $("#startdata")[0].innerText = result.startdate;
	                         $("#lastdata")[0].innerText=result.lastdate>result.total?result.total:result.lastdate;
	                          $("#totaldata")[0].innerText=result.total;
	                         
							//data.forEach(function(obj){
							var _html2='';
							_html2 += "<tr>" +"<td>用例id<td/>"
						      +"<td>用例名称<td/>"
						       +"<td>操作<td/>"
						      +"</tr>";
							var _html =' ';
							data.forEach(function(obj){
							_html +=  "<tr>"
							      +"<td>"+obj.testcaseId+"<td/>"
							      +"<td>"+obj.testcaseName+"<td/>"
								  +"<td onclick=\"deletecaseById('"+obj.testcaseId+"')\">删除</td>"
								  +"<td data-toggle=\"modal\" data-target=\"#updatecase\" onclick='caseContent("+JSON.stringify(obj)+")'>修改</td>"
								   +"<td data-toggle=\"modal\" data-target=\"#casestepManager\" onclick=\"selStepBycaseId('"+obj.testcaseId+"')\">编辑</td>"		
							      +"</tr>"	
							});
							$("#caseALL").html(_html2).append(_html);


                             var  last=result.last;
                             var _html="";
							 for(var i=1;i<=last;i++){
							 	if(i==CURRENT_PAGE){
                                   _html+="<li class=\"selectPage\" onclick=\"pageSpecial("+i+")\">"+i+"</li>" 
							 	}else{
							 		_html+="<li onclick=\"pageSpecial("+i+")\">"+i+"</li>"
							 	}


							 	
							 }
							$("#pageshow").html(_html);
							
				        //});
			        }
			      });
			     }
				 
function  pagesel(val){
     CURRENT_PAGE += val;
    selALLCase($('#caseName').val(),$('#ModelSelect option:selected').val());
}

function  pageSpecial(val){
     CURRENT_PAGE = val;
    selALLCase($('#caseName').val(),$('#ModelSelect option:selected').val());
}
function caseContent(data){
	//alert(data)
	//data = JSON.parse(data);
	$("#caseNameup").val(data.testcaseName);
	$("#catalogup").val(data.catalog);
	$("#modelIdup").val(data.modelId);
	$("#testcaseId").val(data.testcaseId);
	

}

function  selCaseBySearch(){
	 //  var param ={
		// 		testcaseName:$('#caseName').val(),
		// 		modelId:$('#ModelSelect option:selected').val(),
		// }
		CURRENT_PAGE=1;
	  selALLCase($('#caseName').val(),$('#ModelSelect option:selected').val());
      }
	  
function deletecaseById(val){
var param={
			testcaseId:val,
			}
			$.ajax({
										type : 'POST',
										url :'/back/home/deleteCaseByCaseid',
										async : false,
										contentType : "application/json; charset=utf-8",
										data : JSON.stringify(param),
										dataType : "json",
										success : function() {
											alert('删除成功')
											selALLCase();
										}
								  });
				 }
				 
				 
function insertTestcase(){
var param={
			//testcaseId:val,
			testcaseName:$('#caseName1').val(),
			catalog:$('#catalogAdd').val(),
			modelId:$('#catalogAdd').val(),
			}
			$.ajax({
										type : 'POST',
										url :'/back/home/insertTestcase',
										async : false,
										contentType : "application/json; charset=utf-8",
										data : JSON.stringify(param),
										dataType : "json",
										success : function() {
											alert('新增成功')
											selALLCase();
										}
								  });
				 }
				 
				 
function updateCaseByCaseid(){
var param={
			
			testcaseName:$('#caseNameup').val(),
			modelId:$('#modelIdup').val(),
			catalog:$('#catalogup').val(),
			testcaseId:$('#testcaseId').val()
			}
			$.ajax({
										type : 'POST',
										url :'/back/home/updateCaseByCaseid',
										async : false,
										contentType : "application/json; charset=utf-8",
										data : JSON.stringify(param),
										dataType : "json",
										success : function() {
											alert('修改成功')
											selALLCase();
										}
								  });
				 }
 


function selAllModel(){		
var param={
       projectId:$('#ProjectSelect option:selected').val()
			}
				  $.ajax({
						type : 'POST',
						url :'/back/Model/selectModelByproid',
						async : false,
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(param),
						dataType : "json",
						success : function(result) {
						var _html2='';
							_html2 += "<option value=''>请选择</option>"
							var _html =' ';
							result.forEach(function(obj){
							_html +=  
							      "<option value='"+obj.modelId+"'>"+obj.modelName+"</option>"
							});
							$("#ModelSelect").html(_html2).append(_html);
						
						}
				  });
			  } 
			  
function selAllProject(){		
var param={
			}
				  $.ajax({
						type : 'POST',
						url :'/back/home1/selectALLProject',
						async : false,
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(param),
						dataType : "json",
						success : function(result) {
						var _html2='';
							_html2 += "<option value=''>请选择</option>"
							var _html =' ';
							result.forEach(function(obj){
							_html +=  
							      "<option value='"+obj.projectId+"'>"+obj.projectName+"</option>"
							});
							$("#ProjectSelect").html(_html2).append(_html);
						
						}
				  });
			  }

function reloadPage()
  {
  window.location.reload()
  }


function  selStepBycaseId(testcaseId){
	var param={
		testcaseId:testcaseId
	}

	$.ajax({
			type : 'POST',
			url :'/back/casestep/selectStepByCaseId',
			async : false,
			contentType : "application/json; charset=utf-8",
			data :JSON.stringify(param),
			dataType : "json",
			success : function(result) {
				var _html2= ' ';
				_html2 += "<tr>"
				+"<td>"+"<label>序号</label>"+"</td>"
				+"<td>"+"<label>步骤名称</label>"+"</td>"
				+"<td>"+"<label>属性</label>"+"</td>"
				+"<td>"+"<label>属性值</label>"+"</td>"
				+"<td>"+"<label>操作方法</label>"+"</td>"
				+"<td>"+"<label>操作值</label>"+"</td>"
				+"<td>"+"<label>编辑列</label>"+"</td>"
				+"<td>"+"<span id=\"speCaseId\">"+testcaseId+"</span>"+"</td>"
				+"</tr>";
				var _html = ' ';

				result.forEach(function(obj){

					_html +="<tr>"
					+"<td>"+"<label>"+obj.sort+"</label>"+"</td>"
					+"<td>"+"<label>"+obj.stepName+"</label>"+"</td>"
					+"<td>"+"<label>"+obj.attributeName+"</label>"+"</td>"
					+"<td>"+"<label>"+obj.attributeValue+"</label>"+"</td>"
					+"<td>"+"<label>"+obj.operationMethod+"</label>"+"</td>"
					+"<td>"+"<label>"+obj.operationValue+"</label>"+"</td>"
					+"<td onclick=\"deletestepById('"+obj.stepId+"')\">删除</td>"
					+"</tr>"
				});
				$("#stepContent").html(_html2).append(_html);	
                $("#speCaseId").hide();
			                            }
	  });
}


function deletestepById(stepId){
	var param={
		stepId:stepId
	}

	 $.ajax({
						type : 'POST',
						url :'/back/casestep/deleteStepById',
						async : false,
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(param),
						dataType : "json",
						success : function(result) {
						alert('删除成功')
						}
				  });
      //此方法未能在弹框内刷新，需手动刷新
}


function insertStepBycaseId(){
	var param={
		stepName:$("#addstepName").val(),
	    testcaseId:$("#speCaseId")[0].innerText,
	   attributeName:$('#attributeNameSelect option:selected').val(),
	 attributeValue:$("#addattributeValue").val(),
	 operationMethod:$('#operationMethodSelect option:selected').val(),
	 operationValue:$("#addoperationValue").val(),
	 sort:$("#addsort").val(),
	}

	 $.ajax({
						type : 'POST',
						url :'/back/casestep/insertStepBycaseId',
						async : false,
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(param),
						dataType : "json",
						success : function(result) {
						alert('新增成功')
						}
				  });

}



