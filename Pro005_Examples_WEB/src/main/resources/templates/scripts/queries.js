function personCreate() {
    jQuery.ajax({
        type: 'POST',
        url:  '/person/create',
        data: {
            name:    jQuery('#name').val(),
            surname: jQuery('#surname').val(),
            age:     jQuery('#age').val()
        }
    });
}

function createPersonsTable() {

}

