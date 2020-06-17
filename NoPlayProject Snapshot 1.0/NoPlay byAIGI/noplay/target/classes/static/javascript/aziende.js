$(document).ready(function() {

    getAziende()

    function getAziende() {
        $('#lista-aziende').html('')
        $.get("/aziende", function(res) {
            for (let i = 0; i < res.length; i++) {
                $(`<tr data-id="${res[i].id}">
                <td>${res[i].ragioneSociale}</td>
                <td>${res[i].partitaIva}</td>
                <td>${res[i].indirizzo}</td>
                <td>${res[i].email}</td>
                <td>${res[i].nTel}</td>
                </tr>`)
                .appendTo("#lista-aziende")
            }
        })
    }

    function getDipendentiByIdAzienda(id) {
        $('#lista-dipendenti').html('')
        $.get(`/aziende/${id}`, function(res) {
            const dipendenti = res.dipendenti;
            if (dipendenti.length == 0) {
            	$('#lista-dipendenti').html('<tr><td><hr></td><td><hr></td><td><hr></td><td><hr></td><td><hr></td></tr>')
            } else {
            	for (let i = 0; i < dipendenti.length; i++) {
            		$(`<tr data-id="${dipendenti[i].id}">
            				<td>${dipendenti[i].nome}</td>
            				<td>${dipendenti[i].cognome}</td>
            				<td>${dipendenti[i].ddn}</td>
            				<td>${dipendenti[i].ruolo}</td>
            				<td>€${dipendenti[i].stipendio}</td>
            		</tr>`)
            		.appendTo("#lista-dipendenti")
            	}
            }
            /* 
            var competenze = dipendenti.competenze
            for (let i = 0; i < competenze.length; i++) {
                const c = competenze[i];
                $(`<li>${c.competenza.nome}<span class="value">Lvl: ${c.livello}</span></li>`)
                .appendTo("#lista-competenze")
            }
            var certificati = dipendenti.certificati
            for (let i = 0; i < certificati.length; i++) {
                const c = certificati[i];
                $(`<li>${c.certificato.nome}<span class="value">Scade: ${c.dataScadenza}</span></li>`)
                .appendTo("#lista-certificati")
            } */
        })
    }

    $('tr').click(
        function() {
            $(this).addClass('active');
        },
        function() {
            $(this).removeClass('active');
        }

    )
    
    $("#lista-aziende").on("click", "tr", function() {
    	let nomeAzienda = $(this).children(':nth-child(1)').text()
    	$('#nome-azienda').text( nomeAzienda )
    	
        $(this).addClass('active')
        $(this).siblings().removeClass('active')

        getDipendentiByIdAzienda($(this).data("id"))
        
    })

    $('#header').click(function() {
        $(window.location).attr('href','./home.html')
    })

})