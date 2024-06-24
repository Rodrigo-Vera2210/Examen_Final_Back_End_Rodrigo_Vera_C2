var odontologos
var pacientes
window.addEventListener('load', function (params){
    const url = '/odontologo';
    const settings = {
        method: 'GET',
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            odontologos = data
            for (odontologo of data) {
                //por cada pelicula armaremos una fila de la tabla
                //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
                var selectOdontologo = document.getElementById("odontologo");
                var option = document.createElement("option")
                option.text = odontologo.nombre + " " + odontologo.apellido
                option.value = odontologo.id
                selectOdontologo.add(option)
            }
        })
    
    const url2 = '/paciente';
    const settings2 = {
        method: 'GET',
    };

    fetch(url2, settings2)
        .then(response => response.json())
        .then(data => {
            pacientes = data
            for (paciente of data) {
                //por cada pelicula armaremos una fila de la tabla
                //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
                var selectPaciente = document.getElementById("paciente");
                var option = document.createElement("option")
                option.text = paciente.nombre + " " + paciente.apellido
                option.value = paciente.id
                selectPaciente.add(option)
            }
        })
})
    
function guardar(params) {
    var odontologoSeleccionado
    var pacienteSeleccionado
    for (odontologo of odontologos) {
        if(odontologo.id == document.getElementById("odontologo").value){
            odontologoSeleccionado = odontologo
        }
    }
    for (paciente of pacientes) {
        if(paciente.id == document.getElementById("paciente").value){
            pacienteSeleccionado = paciente
        }
    }
    const formData = {
        paciente: pacienteSeleccionado,
        odontologo: odontologoSeleccionado,
        fecha: document.querySelector('#fecha').value,
    }
    const url = '/turno'
    const settings = {
        method: 'POST',
        headers:{
            'Content-Type':'application/json',
        },
        body: JSON.stringify(formData)
    }
    console.log(formData);
    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            let  successAlert = '<div class="alert alert-success alert-dismissible">'+
                '<button type="button" class="close" data-dismiss="alert">&times</button>'+
                '<strong></strong> Paciente Guardado </div>'
            document.querySelector('#response').innerHTML = 'Aqui';
            document.querySelector('#response').style.display = "block"
            //resetUploadForm();
        })
        .catch(error => {
            console.log(error);
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            '<strong> Error intente nuevamente</strong> </div>'

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
            //se dejan todos los campos vacíos por si se quiere ingresar otra pelicula
            //resetUploadForm();
        })
    
}