function Initialize() {
    // body...
	 $('#button_falut').click(function(event) {
	        /* Act on the event */
		 console.log("test");
		 var fault_type=$("#fault_type").val();
		 var fault_content=$('#fault_content').val();
		 var fault_id=1;
		 $.ajax({
				type:"POST",
				url:"./insertFault.do",
				data:{
					fault_id:fault_id,
					fault_type:fault_type,
					fault_content:fault_content
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
				
				} 
			});
	    });
}