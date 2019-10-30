var global_json;
function Initialize() {
    // body...
	$.ajax({
		type:"POST",
		url:"./getFaultReview.do",
		data:{
			test:"test"
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
			global_json=json;
			show(json);
		} 
	});
    
	
	   

}
function show(json) {
	 for(var i=0;i<json.length;i++){
	       var review_stat=json[i]["review_stat"];	       
	        if(review_stat=="false" || review_stat=="未审核" ){
	        	document.getElementById('row_panel').innerHTML+=`
	                <div class="col-sm-4">
	                <div class="panel panel-red">
	                <div class="panel-heading">
	                <h3 class="panel-title">机器ID：${json[i]["machine_id"]}</h3>
	                </div>
	                <div class="panel-body">
	                <a href="#" data-toggle="modal" data-target="#myModal" onclick="getID(`+i+`)">报修人：${json[i]["maintenance_personnel"]}</a>
	                </div>
	                </div> 
	                </div>
	                `
	        }else if(review_stat=="true") {
	        	document.getElementById('row_panel').innerHTML+=`
	                <div class="col-sm-4">
	                <div class="panel panel-green">
	                <div class="panel-heading">
	                <h3 class="panel-title">机器ID：${json[i]["machine_id"]}</h3>
	                </div>
	                <div class="panel-body">
	                <a href="#" data-toggle="modal" data-target="#myModal" onclick="getID(`+i+`)">报修人：${json[i]["maintenance_personnel"]}</a>
	                </div>
	                </div> 
	                </div>
	                `
	        }
	    }
	 $('button_save').click(function(event) {
	        /* Act on the event */
	        console.log("save,test");
	    });
}
function getID(number) {
	$('#myModal').modal("hide");
   $('#review_stat').text(global_json[number]["review_stat"]);
   $('#fault_id').text(global_json[number]["fault_id"]); 
   $('#machine_id').text(global_json[number]["machine_id"]);  
   $('#maintenance_personnel').text(global_json[number]["maintenance_personnel"]);
   $('#fault_time').text(global_json[number]["fault_time"]);  
   $('#fault_type').text(global_json[number]["fault_type"]); 
   $('#button_save').click(function(event) {
       /* Act on the event */
	   $.ajax({
			type:"POST",
			url:"./insertFaultMassage.do",
			data:{
				fault_id:global_json[number]["fault_id"],
				fault_type:global_json[number]["fault_type"],
				fault_special:global_json[number]["fault_special"],
				fault_time:global_json[number]["fault_time"],
				maintenance_personnel:global_json[number]["maintenance_personnel"],
				machine_id:global_json[number]["machine_id"]
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
			} 
		});
       
   });
   	
}