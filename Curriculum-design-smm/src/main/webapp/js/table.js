function Initialize() {
	$.ajax({
		type:"POST",
		url:"./getMachineInfo.do",
		data:{
			massage:"test"
		},
		statusCode : {
			404 : function() {
				alert("404");
			},
			500 : function() {
				alert("500");
			}
		},
		success : function(massge, Status) {

			var json=eval(massge);
			userOperationRecordTableInit(json);
			
		} 
	});
}

function userOperationRecordTableInit(json){
	var first=true;
	console.log("初始化");
	$('#userOperationRecordTable').bootstrapTable({
		columns:[{
			field : 'machine_id',
			title : '纺机ID'
		},{
			field : 'machine_type',
			title : '纺机类型'
		},{
			field : 'person',
			title : '责任人'
		},{
			field : 'maintenance_stat',
			title : '维护状态'
		}],
		data:json,
		sortable: false,   
		pageList : [ 5,10,20],
		pageSize : 10,
		sidePagination: "client",  
		clickToSelect : true,
		pagination : true,
	});
	
	$('#search_button').click(function(event) {
		var machine_id=$('#search_input_type').val();
		/* Act on the event */
		console.log(machine_id);
		var data=[];
		for(var i=0;i<json.length;i++){
			if(json[i]["machine_id"]==machine_id){
				data.push(json[i]);
				break;
			}
		}

		console.log(data);
		$('#userOperationRecordTable').bootstrapTable('load',data);
		
		$.ajax({
			type:"POST",
			url:"./getMachineFault.do",
			data:{
				machine_id:machine_id
			},
			statusCode : {
				404 : function() {
					alert("404");
				},
				500 : function() {
					alert("500");
				}
			},
			success : function(massge, Status) {
				var json1=eval(massge);
				userOperationRecordTableInit1(json1,first)
				first=false;
			} 
		});

	});

}
function userOperationRecordTableInit1(json,first) {
	if(first==true){
		$('#userOperationRecordTable1').bootstrapTable({
			columns:[{
				field : 'fault_time',
				title : '故障时间'
			},{
				field : 'fault_id',
				title : '故障编号'
			},{
				field : 'fault_type',
				title : '故障类型'
			},{
				field : 'fault_special',
				title : '具体故障事件'
			},{
				field : 'maintenance_personnel',
				title : '维修人员'
			}],
			data:json,
			sortable: false,   
			pageList : [ 5,10,20],
			pageSize : 10,
			sidePagination: "client",  
			clickToSelect : true,
			pagination : true,
		});
		
	}else if (first==false) {
		$('#userOperationRecordTable1').bootstrapTable('load',json);
	}

}




//	if(first==true){
//	$('#userOperationRecordTable1').bootstrapTable({
//	columns:[{
//	field : 'fault_time',
//	title : '故障时间'
//	},{
//	field : 'fault_id',
//	title : '故障编号'
//	},{
//	field : 'fault_type',
//	title : '故障类型'
//	},{
//	field : 'fault_special',
//	title : '具体故障事件'
//	},{
//	field : 'Maintenance_personnel',
//	title : '维修人员'
//	}],
//	data:json1,
//	sortable: false,   
//	pageList : [ 5,10,20],
//	pageSize : 10,
//	sidePagination: "client",  
//	clickToSelect : true,
//	pagination : true,
//	});
//	first=false;
//	}else if (first==false) {
//	$('#userOperationRecordTable1').bootstrapTable('load',json2);
//	}



//	┏┛ ┻━━━━━┛ ┻┓
//	┃　　　　　　 ┃
//	┃　　　━　　　┃
//	┃　┳┛　  ┗┳　┃
//	┃　　　　　　 ┃
//	┃　　　┻　　　┃
//	┃　　　　　　 ┃
//	┗━┓　　　┏━━━┛
//	┃　　　┃   神兽保佑
//	┃　　　┃   代码无BUG！
//	┃　　　┗━━━━━━━━━┓
//	┃　　　　　　　    ┣┓
//	┃　　　　         ┏┛
//	┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//	┃ ┫ ┫   ┃ ┫ ┫
//	┗━┻━┛   ┗━┻━┛
