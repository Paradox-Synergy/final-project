function renderListDipendenti(res) {
			
    for (let i = 0; i < res.length; i++) {
        $(`<tr>
                <td>${res[i].nome} ${res[i].cognome}</td>
                <td>età</td>
                <td>${res[i].ruolo}</td>
                <td>${res[i].azienda}</td>
                </tr>`)
            .appendTo("#lista_dipendenti");
    }
}
function renderDetail(res) {
    $('#detail_img').html('<img')
    $('#lista_dipendenti')
    .html(
        `<tr>
            <td>${res[i].id}</td>
            <td>${res[i].nome}</td>
            <td>${res[i].cognome}</td>
            <td>${res[i].ddn}</td>
            <td>${res[i].stipendio}</td>
            <td>${res[i].dataAssunzione}</td>
            <td>${res[i].ruolo}</td>
            <td>${res[i].azienda}</td>
        </tr>`);
    
}

$(document).ready(function () {
    
    function getDipendenti() {
        $.get("dipendenti", function(res) {
			
			for (let i = 0; i < res.length; i++) {
				$(`<tr>
						<td>${res[i].id}</td>
						<td>${res[i].nome}</td>
						<td>${res[i].cognome}</td>
						<td>${res[i].ddn}</td>
						<td>${res[i].stipendio}</td>
						<td>${res[i].dataAssunzione}</td>
                        <td>${res[i].ruolo}</td>
                        <td>${res[i].azienda}</td>
                        </tr>`)
					.appendTo("#lista_dipendenti");
        }

    })

}('#add').click(function() {
    const d = {
        nome: $('#nome').val(),
        cognome: $('#cognome').val(),
        ddn: $('#data_di_nascita').val(),
        stipendio: $('#stipendio').val(),
        dataAssunzione: $('#data_assunzione').val(),
        ruolo: $('#ruolo').val(),
        azienda: $('#azienda').val()
    }

    if(editMode) {
        d.id = idDaModificare; 
        modificaDipendente(d)
    } else {
        addDipendente(d);
    }
    // così carico i valori trovati dentro l'input
    $('#nome').val('')
    $('#cognome').val('')
    $('#data_di_nascita').val('')
    $('#stipendio').val('')
    $('#data_assunzione').val('')
    $('#ruolo').val('')
    $('#azienda').val('')
    
})
// richiamo jquery per sfruttare ajax rendendo la pagina statica
// si compone dentro la funzione e ha i campi
// url, type, data, success(+ function)

function modificaDipendente(dipendente) {
    $.ajax({
        url: `dipendenti`,
        type: 'PUT',
        data: JSON.stringify(dipendente),
        success: function(res) {
            if (res.msg === 'ok') {
                editMode = false
                idDaModificare = -1
                $('#add').text('Aggiungi')
                $('#lista_dipendenti').html('')
                getDipendenti()

            }
        }
    })
}

//parte ora del db, riceve i dati e li salva
function addDipendente(dipendente) {
    $.post('dipendenti', JSON.stringify(dipendente), function(res) {
        $('lista_dipendenti').html('')
        getDipendenti()
    })
}

$('#lista_dipendenti').on('click', '.delete', function() {
    const id = $(this).attr('data-id')
    deleteDipendente(id, $(this).parent().parent())
})

function deleteDipendente(id, htmlRow){
    $.ajax({
        url: `dipendenti/${id}`,
        type:'DELETE',
        success: function(res) {
            if (res.msg === 'ok') {
                htmlRow.remove()
            }
        }
    })
}

let editMode = false;
let idDaModificare = -1;

$('#lista_dipendenti').on('click', '.edit', function() {
    editMode = true;

    const id = $(this().attr('data-id'))
    idDaModificare = id,

    $.get(`dipendenti/${id}`, function(res) {
        $('#nome').val(res.nome)
        $('#cognome').val(res.cognome)
        $('#data_di_nascita').val(res.ddn)
        $('#stipendio').val(res.stipendio)
        $('#data_assunzione').val(res.dataAssunzione)
        $('#ruolo').val(res.ruolo)
        $('#azienda').val(res.azienda)
        $('#add').text('Modifica')
    })
)
function getAziende() {
    $.get("aziende", function(res) {
        
        for (let i = 0; i < res.length; i++) {
            $(`<tr>
                    <td>${res[i].id}</td>
                    <td>${res[i].ragioneSociale}</td>
                    <td>${res[i].partitaIva}</td>
                    <td>${res[i].indirizzo}</td>
                    <td>${res[i].email}</td>
                    <td>${res[i].nTel}</td>
                    </tr>`)
                .appendTo("#lista_aziende");
    }

})

}('#add').click(function() {
const d = {
    ragioneSociale: $('#ragione-sociale').val(),
    partitaIva: $('#partita-iva').val(),
    indirizzo: $('#indirizzo').val(),
    email: $('#email').val(),
    nTel: $('#numero_telefono').val()
}

if(editMode) {
    d.id = idDaModificare; 
    modificaAzienda(a)
} else {
    addAzienda(a);
}
// così carico i valori trovati dentro l'input
$('#ragione_sociale').val('')
$('#partita_iva').val('')
$('#indirizzo').val('')
$('#email').val('')
$('#numero_telefono').val('')
})
// richiamo jquery per sfruttare ajax rendendo la pagina statica
// si compone dentro la funzione e ha i campi
// url, type, data, success(+ function)

function modificaAzienda(azienda) {
$.ajax({
    url: `aziende`,
    type: 'PUT',
    data: JSON.stringify(azienda),
    success: function(res) {
        if (res.msg === 'ok') {
            editMode = false
            idDaModificare = -1
            $('#add').text('Aggiungi')
            $('#lista_aziende').html('')
            getAziende()

        }
    }
})
}

//parte ora del db, riceve i dati e li salva
function addAzienda(azienda) {
$.post('aziende', JSON.stringify(azienda), function(res) {
    $('lista_aziende').html('')
    getAziende()
})
}

$('#lista_aziende').on('click', '.delete', function() {
const id = $(this).attr('data-id')
deleteAzienda(id, $(this).parent().parent())
})

// per eliminare azienda bisogna eliminare anche tutti i dipendenti

function deleteAzienda(id, htmlRow){
$.ajax({
    url: `aziende/${id}`,
    type:'DELETE',
    success: function(res) {
        if (res.msg === 'ok') {
            htmlRow.remove()
        }
    }
})
}

let editMode = false;
let idDaModificare = -1;

$('#lista_aziende').on('click', '.edit', function() {
editMode = true;

const id = $(this().attr('data-id'))
idDaModificare = id

$.get(`aziende/${id}`, function(res) {
    $('#ragione_sociale').val(res.ragioneSociale)
    $('#partita_iva').val(res.partitaIva)
    $('#indirizzo').val(res.indirizzo)
    $('#email').val(res.email)
    $('#numero_telefono').val(res.nTel)
    $('#add').text('Modifica')
})
)
})
})


























