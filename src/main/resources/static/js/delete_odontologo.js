function deleteBy(id) {
    const url = '/odontologo/'+id
    const settings = {
        method : 'DELETE'
    }

    fetch(url,settings)
        .then(response => response.json)
        .then(data => {
            console.log("eliminado");
            location.reload();
        })
}