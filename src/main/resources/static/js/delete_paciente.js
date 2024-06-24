function deleteBy(id) {
    const url = '/paciente/eliminar/'+id
    const settings = {
        method : 'DELETE'
    }

    fetch(url,settings)
        .then(response => response.json)
        .then(data => {
            console.log("eliminado");
            location.reload()
        })
}