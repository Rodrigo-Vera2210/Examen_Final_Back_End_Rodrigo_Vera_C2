var paciente
window.addEventListener('load',function (params) {
    const idPaciente = new URLSearchParams(window.location.search).get("id")
    const url = '/paciente/'+idPaciente
    const settings = {
        method: 'GET',
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data =>{
            paciente = data
            document.querySelector('#idPaciente').innerHTML = paciente.id
            document.querySelector('#nombre').value = paciente.nombre
            document.querySelector('#apellido').value = paciente.apellido
            document.querySelector('#cedula').value = paciente.cedula
            document.querySelector('#fechaIngreso').value = paciente.fechaIngreso
            document.querySelector('#email').value = paciente.email
            document.querySelector('#calle').value = paciente.domicilio.calle
            document.querySelector('#numero').value = paciente.domicilio.numero
            document.querySelector('#localidad').value = paciente.domicilio.localidad
            document.querySelector('#provincia').value = paciente.domicilio.provincia
        })
    
})

function UpdateBy() {
    const formData = {
        id: paciente.id,
        nombre: document.querySelector('#nombre').value,
        apellido: document.querySelector('#apellido').value,
        cedula: document.querySelector('#cedula').value,
        fechaIngreso: document.querySelector('#fechaIngreso').value,
        domicilio:{
            id: paciente.domicilio.id,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
        },
        email: document.querySelector('#email').value
    }
    const url = '/paciente'
    const settings = {
        method: 'PUT',
        headers: {
            'Content-Type':'application/json',
        },
        body: JSON.stringify(formData)
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            console.log("actualizado");
        })
}