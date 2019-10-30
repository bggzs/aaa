/**
 * 
 */
function Initialize() {
	console.log("test");
	$.ajax({
		type:"POST",
		url:"./getFaultMassage.do",
		data:{
			msg:"test"
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
			console.log(massge);
			var json=eval(massge);
			showMassage(json);
		} 
	});
}

function showMassage(json) {
	for(var i=0;i<json.length;i++){
		 document.getElementById('row_panel').innerHTML+=`
			 <div class="col-lg-4">
		            <div class="panel panel-red">
		            <div class="panel-heading">
		            <h3 class="panel-title">故障类型：${json[i]["fault_type"]}</h3>
		            </div>
		            <div class="panel-body">
		            <p>${json[i]["fault_content"]}</p>
		            </div>
		            </div> 
		            </div>
			 `
	}
}