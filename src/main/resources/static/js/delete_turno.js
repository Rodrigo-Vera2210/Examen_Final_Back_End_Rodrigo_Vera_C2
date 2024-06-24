function deleteBy(id) {
    console.log(id);
    const url = '/turno/'+id
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