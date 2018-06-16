/* Logic Scripts */

function personCreate(event) {
    jQuery.ajax({
        type: 'POST',
        url:  '/person/create',
        data: {
            name:    jQuery('#name').val(),
            surname: jQuery('#surname').val(),
            age:     jQuery('#age').val()
        },
        success: function (response) {
            event.preventDefault();
            jQuery('#name').val('');
            jQuery('#surname').val('');
            jQuery('#age').val('');
        },
        error: function (errorThrown) {
            console.log( errorThrown );
        }
    });
}

function findAllPersons() {
    jQuery.ajax({
        type: 'GET',
        url:  '/person/findall',
        success: function (response) {
            processDataPersons(response);
        },
        error: function (errorThrown) {
            console.log( errorThrown );
        }
    });
}

/* UI Scripts */

function createPersonsTable() {
    jQuery('#workspace')
        .empty()
        .append('<table id="tblPersons">');
    jQuery('#tblPersons')
        .append('<caption>Persons Table</caption>')
        .append('<thead><tr id="header"></tr></thead>');
    jQuery('#header')
        .append('<th>ID</th>')
        .append('<th>NAME</th>')
        .append('<th>SURNAME</th>')
        .append('<th>AGE</th>');
    /* Получаем все имеющиеся записи*/
    findAllPersons();
}

function processDataPersons(response) {
    var person = JSON.parse(response);

    console.log(person);

    var tblPersons = document.getElementById('tblPersons');
    var tbody = document.createElement('tbody');
    tbody.id = "table-body";
    for (var i = 0; i < person.length; i++) {
        var tr = document.createElement('tr');
        tr.id = "body_row_" + i;
        tr.innerHTML =
                '<td id="person_name">'    + person[i].name    + '</td>' +
                '<td id="person_name">'    + person[i].name    + '</td>' +
                '<td id="person_surname">' + person[i].surname + '</td>' +
                '<td id="person_age">'     + person[i].age     + '</td>'
        tbody.appendChild(tr);
    }
    tblPersons.appendChild(tbody);
}

