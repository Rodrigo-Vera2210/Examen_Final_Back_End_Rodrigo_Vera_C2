var odontologo;
window.addEventListener("load", function (params) {
    const idOdontologo = new URLSearchParams(window.location.search).get("id");
    const url = "/odontologo/" + idOdontologo;
    const settings = {
        method: "GET",
    };

    fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            odontologo = data;
            document.querySelector("#idOdontologo").innerHTML = odontologo.id;
            document.querySelector("#nombre").value = odontologo.nombre;
            document.querySelector("#apellido").value = odontologo.apellido;
            document.querySelector("#matricula").value =
                odontologo.numeroMatricula;
        });
});

function UpdateBy() {
    const formData = {
        id: odontologo.id,
        numeroMatricula: document.querySelector("#matricula").value,
        nombre: document.querySelector("#nombre").value,
        apellido: document.querySelector("#apellido").value,
    };
    const url = "/odontologo";
    const settings = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    };
    console.log(formData);
    fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            let successAlert =
                '<div class="alert alert-success alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times</button>' +
                "<strong></strong> Paciente Guardado </div>";
            document.querySelector("#response").innerHTML = "Aqui";
            document.querySelector("#response").style.display = "block";
            //resetUploadForm();
        })
        .catch((error) => {
            console.log(error);
            let errorAlert =
                '<div class="alert alert-danger alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                "<strong> Error intente nuevamente</strong> </div>";

            document.querySelector("#response").innerHTML = errorAlert;
            document.querySelector("#response").style.display = "block";
            //se dejan todos los campos vacíos por si se quiere ingresar otra pelicula
            //resetUploadForm();
        });
}
