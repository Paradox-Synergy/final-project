$(document).ready(function() {

    getDipendenti()

    function getDipendenti() {
        $('#lista-dipendenti').html('')
        $.get("/dipendenti", function(res) {
            for (let i = 0; i < res.length; i++) {
                $(`<tr data-id="${res[i].id}">
                <td>${res[i].nome}</td>
                <td>${res[i].cognome}</td>
                <td>${res[i].ddn}</td>
                <td>${res[i].ruolo}</td>
                <td>${res[i].azienda.ragioneSociale}</td>
                </tr>`)
                .appendTo("#lista-dipendenti")
            }
        })
    }

    function getOneDipendente(id) {
        $('#lista-competenze, #lista-certificati').html('')
        $.get(`/dipendenti/${id}`, function(res){
            $("#nome-cognome").text(res.nome+" "+res.cognome)
            $("#ddn").text("Nato/a il "+res.ddn)
            $("#stipendio").text("€"+res.stipendio)
            $("#data-assunzione").text(res.dataAssunzione)
            $("#ruolo").text(res.ruolo)
            $("#azienda").text(res.azienda.ragioneSociale)

            var competenze = res.competenze
            for (let i = 0; i < competenze.length; i++) {
                const c = competenze[i];
                $(`<li>${c.competenza.nome}<span class="value">Lvl: ${c.livello}</span></li>`)
                .appendTo("#lista-competenze")
            }
            var certificati = res.certificati
            for (let i = 0; i < certificati.length; i++) {
                const c = certificati[i];
                $(`<li>${c.certificato.nome}<span class="value">Scade: ${c.dataScadenza}</span></li>`)
                .appendTo("#lista-certificati")
            }
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
    
    $("#lista-dipendenti").on("click", "tr", function() {
        $(this).addClass('active')
        $(this).siblings().removeClass('active')

        getOneDipendente($(this).data("id"))
        
    })
    
    $('#header').click(function() {
        $(window.location).attr('href','./home.html')
    })

})