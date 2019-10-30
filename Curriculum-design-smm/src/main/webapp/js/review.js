function review() {
    $('#button_review').click(function(event) {
       
        /* Act on the event */
       
       var fault_id=$('#fault_id').val();
       var fault_type=$('#fault_type').val();
       var fault_special=$('#fault_special').val();
       var fault_time="2019-07-05";
       var maintenance_personnel=$('#person_name').val();
       var machine_id=$("#machine_id").val();
       var review_stat="false";
       console.log(fault_special);
        $.ajax({
			type:"POST",
			url:"./insertFaultInfo.do",
			data:{
				fault_id:fault_id,
				fault_type:fault_type,
				fault_special:fault_special,
				fault_time:fault_time,
				maintenance_personnel:maintenance_personnel,
				machine_id:machine_id,
				review_stat:review_stat
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