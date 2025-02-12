window.addEventListener('load',function (params) {
    const formulario = document.querySelector("#add_new_paciente");
    formulario.addEventListener('submit', function (event){
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            cedula: document.querySelector('#cedula').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            domicilio:{
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value,
            },
            email: document.querySelector('#email').value
        }
        const url = '/paciente'
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type':'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => reaponse.json())
            .then(data => {
                let  successAlert = '<div class="alert alert-success alert-dismissible">'+
                    '<button type="button" class="close" data-dismiss="alert">&times</button>'+
                    '<strong></strong> Paciente Guardado </div>'
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block"
                //resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                //se dejan todos los campos vacíos por si se quiere ingresar otra pelicula
                //resetUploadForm();
            })
    })
    
    function resetUploadForm() {
        document.querySelector('#titulo').value = ""
        document.querySelector('#categoria').value = ""
        document.querySelector('#premios').value = ""
    }

    (function(){
        let pathname = window.location.pathname
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active")
        }else if(pathname == "/peliculaList.html"){
            document.querySelector(".nav .nav-item a:first").addClass("active")
        }
    })()
})
