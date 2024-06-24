var turno;
var odontologos
var pacientes
window.addEventListener("load", function (params) {
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

    const idTurno = new URLSearchParams(window.location.search).get("id");
    const url3 = "/turno/" + idTurno;
    const settings3 = {
        method: "GET",
    };

    fetch(url3, settings3)
        .then((response) => response.json())
        .then((data) => {
            turno = data;
            document.querySelector("#idTurno").innerHTML = turno.id;
            document.querySelector("#paciente").value = turno.paciente.id;
            document.querySelector("#odontologo").value = turno.odontologo.id;
            document.querySelector("#fecha").value =
                turno.fecha;
        });
});

function UpdateBy() {
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
        id: turno.id,
        paciente: pacienteSeleccionado,
        odontologo: odontologoSeleccionado,
        fecha: document.querySelector('#fecha').value,
    }
    const url = '/turno'
    const settings = {
        method: 'PUT',
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
        })
        .catch(error => {
            console.log(error);
        })
    
}
