window.addEventListener('load', function (params) {
    (function name(params) {
        const url = '/turno';
        const settings = {
            method: 'GET',
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                for (turno of data) {
                    //por cada pelicula armaremos una fila de la tabla
                    //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
                    var table = document.getElementById("turnoTable");
                    var turnoRow = table.insertRow();
                    let tr_id = turno.id;
                    turno.id = tr_id;

                    //por cada pelicula creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
                    //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                    //de llamar a la API para eliminar una pelicula
                    let deleteButton =
                        "<button" +
                        " id=" +
                        '"' +
                        "btn_delete_" +
                        turno.id +
                        '"' +
                        ' type="button" onclick="deleteBy(' +
                        turno.id +
                        ')" class="btn btn-danger btn_delete">' +
                        "&times" +
                        "</button>";

                    //por cada pelicula creamos un boton que muestra el id y que al hacerle clic invocará
                    //a la función de java script findBy que se encargará de buscar la pelicula que queremos
                    //modificar y mostrar los datos de la misma en un formulario.
                    let updateButton =
                        "<a href='../put_turno.html?id="+turno.id+"'> <button" +
                        " id=" +
                        '"' +
                        "btn_id_" +
                        turno.id +
                        '"' +
                        '" class="btn btn-info btn_id">' +
                        turno.id +
                        "</button></a>";

                    //armamos cada columna de la fila
                    //como primer columna pondremos el boton modificar
                    //luego los datos de la pelicula
                    //como ultima columna el boton eliminar
                    turnoRow.innerHTML =
                        '<td class="td_paciente">' +
                        turno.paciente.nombre.toUpperCase() + " " + turno.paciente.apellido.toUpperCase() +
                        "</td>" +
                        '<td class="td_odontologo">' +
                        turno.odontologo.nombre.toUpperCase() + " " + turno.odontologo.apellido.toUpperCase() +
                        "</td>" +
                        '<td class="td_fecha">' +
                        turno.fecha.toUpperCase() +
                        "</td>" +
                        "<td>" +
                        updateButton +
                        "</td>" +
                        "<td>" + 
                        deleteButton +
                        "</td>";

                    console.log(turnoRow);
                }
            })
    })();
});


