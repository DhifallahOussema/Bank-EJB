function deleteAccount(rib) {
	Swal.fire({
		title: "Are you sure?",
		text: "Once deleted , you can't recover your account!",
		icon: "warning",
		buttons: true,
		showCancelButton: true,
		cancelButtonText:"Cancel",
		dangerMode: true,
	})
		.then((result) => {
			if (result.isConfirmed) {
				$.ajax({
					url: "CompteController",
					type: "POST",
					data: {
						action: "delete",
						rib: rib
					},
					success: function() {
						$("#tr" + rib).remove();
						Swal.fire({title:" The account has been deleted !", 
							icon: "success",
						});
					},
					error: function() {
						Swal.fire({text:"Erreur du serveur !", 
							icon: "error",
						});
					}
				});
			}
		});
}

/*$("#btnAdd").click(function () {
  $.ajax({
		url:"CompteController",
		type:"GET",
		data:{
			action:"getCin"
		},
		success: function (data) {
		     $( "#client" ).autocomplete({
           		source: data,
       		 });
		},
		
	});
  Swal.fire({
    title: "Add Client",
    html: `<form>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="cin" class="col-form-label">Solde</label>
            </div>
            <div class="col-10">
              <input class="form-control" type="text" name="solde" id="solde">
            </div>
        </div>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="nom" class="col-form-label">Client</label>
            </div>
            <div class="col-10">
           	<div class="ui-widget">
              <input class="form-control" type="text" name="client" id="client" autocomplete="off">
             </div>
            </div>
        </div>
        
    </form>`,
    confirmButtonText: "Add",
    focusConfirm: false,
    preConfirm: () => {
      const solde = Swal.getPopup().querySelector("#solde").value;
      const client = Swal.getPopup().querySelector("#client").value;
      if (!solde || !client ) {
        swal.showValidationMessage(`Please fill the form`);
      }
      return { solde: solde, client: client };
    },
  }).then((result) => {
    $.ajax({
      url: "CompteController",
      type: "POST",
      data: {
        action: "add",
        solde: result.value.solde,
        client: result.value.client,
      },
      success: function () {
        location.reload();
      },
      error: function () {
        Swal.fire("Erreur du serveur !", {
          icon: "error",
        });
      },
    });
  });
});*/

/*function updateAccount(rib){
	$.ajax({
		url: "CompteController",
	    type: "GET",
	    data: {
	    action:"prepareUpdate",
	    rib: rib
	    },
	    success:function(data){
			Swal.fire({
				title:"Edit Account",
				html:`<form>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="cin" class="col-form-label">Solde</label>
            </div>
            <div class="col-10">
              <input class="form-control" type="text" name="solde" id="solde" value ="${data.solde}">
            </div>
        </div>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="nom" class="col-form-label">Client</label>
            </div>
            <div class="col-10">
               <div class ="ui-widget">
              <input class="form-control" type="text" name="client" id="client" value="${data.client.cin}" autocomplete="off">
              <div>
            </div>
        </div>
        
    </form>`,
     confirmButtonText: "Edit",
     focusConfirm: false,
     preConfirm : ()=>{
		 const solde = Swal.getPopup().querySelector("#solde").value;
         const client = Swal.getPopup().querySelector("#client").value;
         if (!solde || !client ) {
            swal.showValidationMessage(`Please enter your Account details`);
          }
          return { solde: solde, client: client };
		}
			}).then((result)=>{
			$.ajax({
				url:"CompteController",
				type:"POST",
				data:{
					action:"update",
	    			rib: rib,
	    			solde:result.value.solde,
	    			client:result.value.client
				},
				success: function () {
		            location.reload();
		        },
		        error:function(){
					Swal.fire({title:"Erreur du serveur !",
		              icon: "error"
		            });
				}
				
			});
		});
		},
		});
		
	
}*/


$(function(){
	$.ajax({
		url:"CompteController",
		type:"GET",
		data:{
			action:"getCin"
		},
		success: function (data) {
		     $( "#client" ).autocomplete({
           		source: data,
       		 });
		},
		
	});
})

