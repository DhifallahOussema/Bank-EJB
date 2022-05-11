function deleteClient(cin) {
  Swal.fire({
    title: "Are you sure ?",
    text: "Once deleted,you can't recover your information!'",
    icon: "warning",
    buttons: true,
    showCloseButton: true,
    showCancelButton: true,
    dangerMode: true,
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        url: "ClientController",
        type: "POST",
        data: {
          action: "delete",
          cin: cin,
        },
        success: function () {
          $("#tr" + cin).remove();
          Swal.fire({title:"Client deleted succefully !" ,
            icon: "success",
          });
        },
        error: function () {
          Swal.fire({title:"server error !",
            icon: "error",
          });
        },
      });
    }
  });
}
$("#btnAdd").click(function () {
  Swal.fire({
    title: "Add Client",
    html: `<form>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="cin" class="col-form-label">Cin</label>
            </div>
            <div class="col-10">
              <input class="form-control" type="text" name="cin" id="cin">
            </div>
        </div>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="nom" class="col-form-label">nom</label>
            </div>
            <div class="col-10">
              <input class="form-control" type="text" name="nom" id="nom">
            </div>
        </div>
        <div class="row g-3 align-items-center">
            <div class="col-2">
              <label for="prenom" class="col-form-label">prenom</label>
            </div>
            <div class="col-10">
              <input class="form-control" type="text" name="prenom" id="prenom">
            </div>
        </div>
    
        <div class="row g-3 align-items-center">
            <div class="col-2">
            <label for="adresse" class="col-form-label">adresse</label>
            </div>
            <div class="col-10">
            <input class="form-control" type="text" name="adresse" id="adresse">
            </div>
        </div>
    </form>`,
    confirmButtonText: "Add",
    focusConfirm: false,
    preConfirm: () => {
      const cin = Swal.getPopup().querySelector("#cin").value;
      const nom = Swal.getPopup().querySelector("#nom").value;
      const prenom = Swal.getPopup().querySelector("#prenom").value;
      const adresse = Swal.getPopup().querySelector("#adresse").value;
      if (!cin || !nom || !prenom || !adresse) {
        swal.showValidationMessage(`Please enter your personal details`);
      }
      return { cin: cin, nom: nom, prenom: prenom, adresse: adresse };
    },
  }).then((result) => {
    $.ajax({
      url: "ClientController",
      type: "POST",
      data: {
        action: "add",
        cin: result.value.cin,
        nom: result.value.nom,
        prenom: result.value.prenom,
        adresse: result.value.adresse,
      },
      success: function () {
        location.reload();
      },
      error: function () {
        swal("Erreur du serveur !", {
          icon: "error",
        });
      },
    });
  });
});

function editClient(cin) {
  $.ajax({
    url: "ClientController",
    type: "GET",
    data: {
      action:"prepareUpdate",
      cin: cin,
    },
    success: function (data) {
      Swal.fire({
        title: "Edit Client",
        html: `<form>
				        <div class="row g-3 align-items-center">
				            <div class="col-2">
				              <label for="cin" class="col-form-label">Cin</label>
				            </div>
				            <div class="col-10">
				              <input class="form-control" type="text" name="cin" id="cin" value="${data.cin}">
				            </div>
				        </div>
				        <div class="row g-3 align-items-center">
				            <div class="col-2">
				              <label for="nom" class="col-form-label">nom</label>
				            </div>
				            <div class="col-10">
				              <input class="form-control" type="text" name="nom" id="nom" value="${data.nom}">
				            </div>
				        </div>
				        <div class="row g-3 align-items-center">
				            <div class="col-2">
				              <label for="prenom" class="col-form-label">prenom</label>
				            </div>
				            <div class="col-10">
				              <input class="form-control" type="text" name="prenom" id="prenom" value="${data.prenom}">
				            </div>
				        </div>
				    
				        <div class="row g-3 align-items-center">
				            <div class="col-2">
				            <label for="adresse" class="col-form-label">adresse</label>
				            </div>
				            <div class="col-10">
				            <input class="form-control" type="text" name="adresse" id="adresse" value="${data.adresse}">
				            </div>
				        </div>
				    </form>`,
        confirmButtonText: "Edit",
        focusConfirm: false,
        preConfirm: () => {
          const cin = Swal.getPopup().querySelector("#cin").value;
          const nom = Swal.getPopup().querySelector("#nom").value;
          const prenom = Swal.getPopup().querySelector("#prenom").value;
          const adresse = Swal.getPopup().querySelector("#adresse").value;
          if (!cin || !nom || !prenom || !adresse) {
            swal.showValidationMessage(`Please enter your personal details`);
          }
          return { cin: cin, nom: nom, prenom: prenom, adresse: adresse };
        },
      }).then((result) => {
        $.ajax({
          url: "ClientController",
          type: "POST",
          data: {
            action: "update",
            cin: result.value.cin,
            nom: result.value.nom,
            prenom: result.value.prenom,
            adresse: result.value.adresse,
          },
          success: function () {
            location.reload();
          },
          error: function () {
            swal("Erreur du serveur !", {
              icon: "error",
            });
          },
        });
      });
    },
    /*error: function () {
      Swal.fire("Erreur du serveur !", {
        icon: "error",
      });
    },*/
    error: function (request, status, error) {
        console.log(request.responseText);
        console.log(status);
        console.log(error);
    }
  });
}


